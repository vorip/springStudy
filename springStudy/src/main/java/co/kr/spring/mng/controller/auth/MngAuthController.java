package co.kr.spring.mng.controller.auth;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.spring.dao.CommonDao;
import co.kr.spring.vo.AuthVo;
import co.kr.spring.vo.Paging;

@Controller
@RequestMapping(value="/mng/auth/*")
public class MngAuthController<E> {
	
	@Autowired
	CommonDao dao;

	final static String queryId = "co.kr.spring.mapper.AuthMapper.";
	
	@RequestMapping("typeList")
	public String typeList(HttpServletRequest request, Model model) {
		
		int page=1;
		if(request.getParameter("nowPage") != null) {
			page = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		int total = dao.selectOne(queryId + "authTotal");
		
		Paging paging = new Paging(total, page);
		
		List<AuthVo> list = dao.selectList(queryId + "typeList", paging);
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		return "/mng/auth/typeList";
	}
	
	@GetMapping("typeInsert")
	public String typeIsert() {
		return "/mng/auth/typeInsert";
	}
	
	@PostMapping("typeInsert")
	public String typeInsert(AuthVo vo) {
		dao.insert(queryId + "typeInsert", vo);
		return "/mng/auth/typeList";
	}
	
	@GetMapping("typeUpdate")
	public String typeUpdate(int seq) {
		
		
		return "/mng/auth/typeUpdate";
	}
	
	@PostMapping("typeUpdate")
	public String typeUpdate2(int seq, Model model) {
		AuthVo vo = dao.selectOne(queryId + "typeSelect", seq);
		model.addAttribute("vo", vo);
		return "/mng/auth/typeUpdate";
	}
	
	@RequestMapping("typeDelete")
	public String typeDelete() {
		return "/mng/auth/typeDelete";
	}
	
//======================================================================================================	
	
	
	
	@RequestMapping("codeList")
	public String codeList() {
		return "/mng/auth/codeList";
	}
	
	@RequestMapping("codeInsert")
	public String codeInsert() {
		return "/mng/auth/codeInsert";
	}
	
	@RequestMapping("codeUpdate")
	public String codeUpdate() {
		return "/mng/auth/codeUpdate";
	}
	
	@RequestMapping("codeDelete")
	public String codeDelete() {
		return "/mng/auth/codeDelete";
	}
	
}
