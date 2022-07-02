package co.kr.spring.srv.controller.bbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.spring.dao.CommonDao;
import co.kr.spring.vo.BbsVo;
import co.kr.spring.vo.Paging;

@Controller
@RequestMapping("/srv/bbs/*")
public class SrvBbsController {

	@Autowired
	CommonDao commonDao;
	
	final static String queryId = "co.kr.spring.mapper.BbsMapper.";
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model) {
		int page = 1;
		if(request.getParameter("nowPage") != null) {
			page = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		int total = commonDao.selectOne(queryId + "getTotal");
		
		Paging paging = new Paging(total, page);
		
		List<BbsVo> list = commonDao.selectList(queryId + "getBbs", paging);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		
		return "/srv/bbs/list";
	}

	@RequestMapping("viewPost")
	public String viewPost(HttpServletRequest request, Model model, BbsVo vo) {
		BbsVo viewPost = commonDao.selectOne(queryId + "selectBbs", vo.getSeq());
		model.addAttribute("vo",viewPost);
		
		int page = 1;
		if(request.getParameter("nowPage") != null) {
			page = Integer.parseInt(request.getParameter("nowPage"));
		}
		int total = commonDao.selectOne(queryId + "comTotal", vo.getSeq());
		Paging paging = new Paging(total, page);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("seq", viewPost.getSeq());
		param.put("startIndex", paging.getStartIndex());
		param.put("cntPerPage", paging.getCntPerPage());
		
		List<BbsVo> comList = commonDao.selectList(queryId + "comSel", param);
		
		model.addAttribute("comList", comList);
		model.addAttribute("paging", paging);
		return "/srv/bbs/viewPost";
	}
	
	@GetMapping("write")
	public String writeGet() {
		return "/srv/bbs/write";
	}
	@PostMapping("write")
	public String writePost(BbsVo vo) {
		commonDao.insert(queryId + "insertBbs", vo);
		return "redirect:/srv/bbs/list";
	}
	
	@GetMapping("updatePost")
	public String updatePost(Model model, BbsVo vo) {
		BbsVo updatePost = commonDao.selectOne(queryId + "selectBbs", vo.getSeq());
		model.addAttribute("vo", updatePost);
		return "/srv/bbs/updatePost";
	}
	
	@PostMapping("updatePost")
	public String updatePostSubmit(BbsVo vo) {
		commonDao.update(queryId + "updatePost", vo);
		return "redirect:/srv/bbs/viewPost?seq="+vo.getSeq();
	}
	
	@RequestMapping("comInsert")
	public String comWrite(BbsVo vo) {
		commonDao.insert(queryId + "comInsert", vo);
		return "redirect:/srv/bbs/viewPost?seq="+vo.getSeq();
	}
	
	@GetMapping("updateCom")
	public String comUpdate(Model model, BbsVo vo) {
		BbsVo thisCom = commonDao.selectOne(queryId + "thisCom", vo.getComSeq());
		model.addAttribute("vo", thisCom);
		return "/srv/bbs/updateCom";
	}
	@PostMapping("updateCom")
	public String comUpdate2(Model model, BbsVo vo) {
		commonDao.update(queryId + "comUpdate", vo);
		String url="/srv/bbs/viewPost?seq="+vo.getSeq();
		model.addAttribute("url", url);
		return "/srv/bbs/updateCom";
	}
	@RequestMapping("delete")
	public String deleteBbs(int seq) {
		commonDao.delete(queryId + "delComAll", seq);
		commonDao.delete(queryId + "delPost", seq);
		return "redirect:/srv/bbs/list";
	}
	@RequestMapping("delCom")
	public String deleteCom(BbsVo vo) {
		commonDao.delete(queryId + "delCom", vo.getComSeq());
		return "redirect:/srv/bbs/viewPost?seq="+vo.getSeq();
	}
}
