package co.kr.spring.mng.service.impl;

import java.io.IOException;

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
	
	public static void main(String[] args) {

		Document doc = null;

		int i = 1;
		while (true) {
			try {
//				String url = "https://www.lawmaking.go.kr/lmSts/govLm?pageIndex=" + i + "&stDtFmt=2022.+5.+1.&edDtFmt=2022.+5.+29.&pageSize=100";
				String url = "https://www.lawmaking.go.kr/lmSts/govLm?govLmStsScYn=Y&stDtFmt=2022.+5.+1.&edDtFmt=2022.+5.+22.&pageSize=100&pageIndex="+i;
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
					CrawlingVo vo = new CrawlingVo(); 
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
//					dao.insert(queryId + "insertGov", vo);
				}
			} catch (Exception e) {
				break;
			}
		}
	
	}

	@Override
	public void lawMaking() {
		lawMakingGov();
		lawMakingNsm();
	}

	// 정부
	private void lawMakingGov() {
		Document doc = null;

		int i = 1;
		while (true) {
			try {
//				String url = "https://www.lawmaking.go.kr/lmSts/govLm?pageIndex=" + i + "&stDtFmt=2022.+5.+1.&edDtFmt=2022.+5.+29.&pageSize=100";
				String url = "https://www.lawmaking.go.kr/lmSts/govLm?govLmStsScYn=Y&stDtFmt=2022.+5.+1.&edDtFmt=2022.+5.+22.&pageSize=100&pageIndex="+i;
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
					CrawlingVo vo = new CrawlingVo(); 
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

		int i = 1;
		while (true) {
			try {
				String url2 = "https://www.lawmaking.go.kr/lmSts/nsmLmSts/out?pageIndex=" + i;
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
							vo.setReg_date(Integer.parseInt(ie3.get(tds).text()));
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
