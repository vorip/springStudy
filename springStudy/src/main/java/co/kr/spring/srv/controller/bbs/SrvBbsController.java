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
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.spring.srv.mapper.BbsMapper;
import co.kr.spring.vo.BbsVo;
import co.kr.spring.vo.Paging;

@Controller
@RequestMapping("/srv/bbs/*")
public class SrvBbsController {

	@Autowired
	BbsMapper bbsMapper;
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model) {
		int page = 1;
		if(request.getParameter("nowPage") != null) {
			page = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		int total = bbsMapper.getTotal();
		
		Paging paging = new Paging(total, page);
		
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("start", (paging.getNowPage()-1)*paging.getCntPerPage());
//		param.put("cnt", paging.getCntPerPage());
		
		List<BbsVo> list = bbsMapper.getBbs(paging);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		
		return "/srv/bbs/list";
	}

	@RequestMapping(value="viewPost", method = RequestMethod.GET)
	public String viewPost(Model model, BbsVo vo) {
		BbsVo viewPost = bbsMapper.selectBbs(vo.getSeq());
		model.addAttribute("vo",viewPost);
		return "/srv/bbs/viewPost";
	}
//	@RequestMapping(value="viewPost", method = RequestMethod.POST)
//	public String viewPost2(Model model, BbsVo vo) {
//		BbsVo viewPost = bbsMapper.viewPost(vo.getSeq());
//		model.addAttribute("vo",viewPost);
//		return "/srv/bbs/viewPost";
//	}
	
	@GetMapping("write")
	public String writeGet() {
		return "/srv/bbs/write";
	}
	@PostMapping("write")
	public String writePost(BbsVo vo) {
		bbsMapper.insertBbs(vo);
		return "redirect:/srv/bbs/list";
	}
	
	@GetMapping("updatePost")
	public String updatePost(Model model, BbsVo vo) {
		BbsVo updatePost = bbsMapper.selectBbs(vo.getSeq());
		model.addAttribute("vo", updatePost);
		return "/srv/bbs/updatePost";
	}
	
	@PostMapping("updatePost")
	public String updatePostSubmit(BbsVo vo) {
		bbsMapper.updatePost(vo);
		return "redirect:/srv/bbs/viewPost?seq="+vo.getSeq();
	}
	
	@RequestMapping("comment")
	public String comWrite(BbsVo vo) {
		bbsMapper.comInsert(vo);
		return "redirect:/srv/bbs/viewPost?seq="+vo.getSeq();
	}
}
