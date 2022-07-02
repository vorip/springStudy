package co.kr.spring.mng.service.impl;

import java.io.IOException;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.spring.dao.CommonDao;
import co.kr.spring.mng.service.inf.GlobalScheduler;
import co.kr.spring.vo.CrawlingVo;

@Service
public class GlobalSchedulerImpl implements GlobalScheduler {

	@Autowired
	CommonDao dao;
	
	final static String queryId = "co.kr.spring.srv.mapper.CrawlingMapper.";
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Override
	public void lawMaking() {
		lawMakingGov();
		lawMakingNsm();
	}

	// 정부
	private void lawMakingGov() {
		CrawlingVo vo = new CrawlingVo();
		Document doc = null;

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR); //오늘의 년도
		int month = cal.get(Calendar.MONTH); //오늘의 월
		int date = cal.get(Calendar.DATE); //오늘의 일
		// 2021.+5.+1.
		int i = 1;
		while (true) {
			try {
				String url = "https://www.lawmaking.go.kr/lmSts/govLm?"
						+ "govLmStsScYn=Y"
						+ "&stDtFmt="+(year-1)+".+"+month+".+"+date+"."
						+ "&edDtFmt="+year+".+"+month+".+"+date+"."
						//검색어 추가 필수
						+ "&pageSize=100&pageIndex="+i;
				i++;

				try {
					doc = Jsoup.connect(url).get();
				} catch (IOException e) {
					e.printStackTrace();
				}

				Elements div = doc.select("div.con_wrap");
				Elements table = div.select("table.tbl_typeA");
				Elements tbody = table.select("tbody");
				Elements tr = tbody.select("tr");
				int trSize = tr.size();

				if(trSize == 1 && tr.get(0).select("td").size() == 1) {
					break;
				}
				
				for (int trs = 0; trs < trSize; trs++) {
					Elements tds = tr.get(trs).select("td");
					int tdsSize = tds.size();
					for (int tdSize = 0; tdSize < tdsSize; tdSize++) {
						String tdText = tds.get(tdSize).text();
						switch (tdSize) {
						case 1:
							vo.setLawName(tdText);
							break;
						case 2:
							vo.setLawType(tdText);
							break;
						case 3:
							vo.setRevision(tdText);
							break;
						case 4:
							vo.setDepartment(tdText);
							break;
						case 5:
							vo.setPromotion(tdText);
							break;
						default:
							break;
						}
					}
					dao.insert(queryId + "insertGov", vo);
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	// 국회
	private void lawMakingNsm() {
		Document doc = null;
		CrawlingVo c = new CrawlingVo();

		int i = 1;
		while (true) {
			try {
//				String url2 = "https://www.lawmaking.go.kr/lmSts/nsmLmSts/out?pageIndex=" + i;
				String url2 = "https://www.lawmaking.go.kr/lmSts/nsmLmSts/out?"
							+ "stDtFmt=" + c.getStDtFmt()
							+ "&edDtFmt=" + c.getEdDtFmt()
							+ "&scBlNm=" //검색어
							+ "&pageSize=100"
							+ "&pageIndex=" + i;
				i++;

				try {
					doc = Jsoup.connect(url2).get();
				} catch (Exception e) {
					e.printStackTrace();
				}

				Elements element = doc.select("table.tbl_typeA");
				Elements ie1 = element.select("tbody");
				Elements ie2 = ie1.select("tr");
				int tr = ie2.size();
				
				if(tr == 1 && ie2.get(0).select("td").size() == 1) {
					break;
				}
				
				for(int trs=0;trs<tr;trs++) {
					CrawlingVo vo = new CrawlingVo();
					Elements ie3 = ie2.get(trs).select("td");
					int tdSize = ie3.size();
					for(int tds=0;tds<tdSize;tds++) {
						switch (tds) {
						case 0:
							vo.setLawName(ie3.get(tds).text());
							break;
						case 1:
							vo.setPromonent(ie3.get(tds).text());
							break;
						case 2:
							vo.setCommittee(ie3.get(tds).text());
							break;
						case 3:
							vo.setStateCode(ie3.get(tds).text());
							break;
						case 4:
							vo.setDecisionRe(ie3.get(tds).text());
							break;
						case 5:
							vo.setBillNum(ie3.get(tds).text());
							break;
						case 6:
							vo.setReg_date(ie3.get(tds).text());
							break;
						default:
							break;
						}
					}
					dao.insert(queryId + "insertNsm", vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

}
