package co.kr.spring.srv.controller.member;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.spring.dao.CommonDao;
import co.kr.spring.vo.MemberVo;

@Controller
@RequestMapping("/srv/member/*")
public class SrvMemberController {
	
	@Autowired
	CommonDao commonDao;
	
	final static String queryId = "co.kr.spring.mapper.MemberMapper.";
	
	@RequestMapping("signUp")
	public String signUpPage(HttpServletRequest request, Model model, MemberVo vo) {
		String resString = "/srv/member/signUp";
		
		if("POST".equalsIgnoreCase(request.getMethod())) {
			int idList = commonDao.selectOne(queryId + "idSelect", vo.getId());
			String err = "";
			if(idList==0) {
				commonDao.insert(queryId + "signUp", vo);
				resString = "redirect:/srv/main/main";
			} else {
				err = "중복된 아이디입니다.";
				model.addAttribute("vo", vo);
				model.addAttribute("message", err); 
			}
			return resString;
		}
		model.addAttribute("vo", vo);
		return resString;
	}
	
	@GetMapping("login")
	public String login() {
		return "/srv/member/login";
	}
	
	@PostMapping("login")
	public String login2(MemberVo vo, Model model, HttpSession session) {
		int count = commonDao.selectOne(queryId + "login", vo);
		String message="";
		String resUrl = "";
		String inputId = "";
		
		if(count == 1) {
			session.setAttribute("userId", vo.getId());
			message="로그인이 완료되었습니다";
			resUrl = "/srv/main/main";
		} else {
			message="회원 정보가 일치하지 않습니다.";
			inputId = vo.getId();
		}
		
		model.addAttribute("message", message);
		model.addAttribute("resUrl", resUrl);
		model.addAttribute("inputId", inputId);
		return "/srv/member/login";
	}
	

}
