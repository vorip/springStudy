package co.kr.spring.mng.controller.rule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.spring.dao.CommonDao;
import co.kr.spring.vo.CrawlingVo;
import co.kr.spring.vo.Paging;

@Controller
@RequestMapping("/mng/rule/*")
public class MngRuleController {

	@Autowired
	CommonDao commonDao;
	
	final static String queryId = "co.kr.spring.mapper.RuleMapper.";
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@RequestMapping("keywordList")
	public String keywordList(Model model, HttpServletRequest request) {
		int page = 1;
		if(request.getParameter("nowPage") != null) {
			page = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		int total = commonDao.selectOne(queryId + "keywordCnt");
		
		Paging paging = new Paging(total, page);
		
		List<CrawlingVo> keywordList = commonDao.selectList(queryId + "keywordList", paging);
		model.addAttribute("list", keywordList);
		model.addAttribute("paging", paging);
		return "/mng/rule/keywordList";
	}
	
	@GetMapping("keywordInsert")
	public String keywordInsert1() {
		return "/mng/rule/keywordInsert";
	}
	
	@PostMapping("keywordInsert")
	public String keywordInsert(HttpServletRequest request, HttpSession session) {
		String keyword = request.getParameter("keyword");
		CrawlingVo vo = new CrawlingVo();
		vo.setKeyword(keyword);
		
		String regId = "";
		
		if(session.getAttribute("userId") != null) {
			regId = (String)session.getAttribute("userId");
		}
		
		vo.setReg_id(regId);
		
		commonDao.insert(queryId + "keywordInsert", vo);
		return "redirect:/mng/rule/keywordList";
	}
	
	@RequestMapping("keywordDelete")
	public String keywordDelete(int seq) {
		commonDao.delete(queryId + "keywordDelete", seq);
		return "redirect:/mng/rule/keywordList";
	}
	
	@GetMapping("keywordUpdate")
	public String keywordUpdate1(int seq, Model model){
		CrawlingVo vo = commonDao.selectOne(queryId + "keyword", seq);
		model.addAttribute("vo", vo);
		return "/mng/rule/keywordUpdate";
	}
	
	@PostMapping("keywordUpdate")
	public String keywordUpdate(CrawlingVo vo) {
		commonDao.update(queryId + "keywordUpdate", vo);
		return "redirect:/mng/rule/keywordList";
	}
}
