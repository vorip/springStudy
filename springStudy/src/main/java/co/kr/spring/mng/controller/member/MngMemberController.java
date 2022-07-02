package co.kr.spring.mng.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.spring.dao.CommonDao;
import co.kr.spring.vo.MemberVo;
import co.kr.spring.vo.Paging;

@Controller
@RequestMapping(value="/mng/member/*")
public class MngMemberController {
	
	@Autowired
	CommonDao commonDao;
	
	final static String queryId = "co.kr.spring.mapper.MemberMapper.";
		
	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model) {
		
		int page = 1;
		if(request.getParameter("nowPage") != null) {
			page = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		int total = commonDao.selectOne(queryId + "memberCount");
		
		Paging paging = new Paging(total, page);
		
		List<MemberVo> memberList = commonDao.selectList(queryId + "memberList", paging);
		model.addAttribute("list", memberList);
		model.addAttribute("paging", paging);
		return "/mng/member/list";
	}
	
	@GetMapping("update")
	public String updatePage(String id, Model model) {
		MemberVo member = commonDao.selectOne(queryId + "memSel", id);
		model.addAttribute("mem", member);
		return "/mng/member/update";
	}
	
	@PostMapping("update")
	public String updateSubmit(MemberVo vo) {
		commonDao.update(queryId + "memUpdate", vo);
		return "redirect:/mng/member/list";
	}
	
	@RequestMapping("delete")
	public String memberDelete(String id) {
		commonDao.delete(queryId + "delete", id);
		return "redirect:/mng/member/list";
	}
	
}
