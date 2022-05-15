package co.kr.spring.srv.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/srv/member/*")
public class SrvMemberController {
	
	@RequestMapping(value="singUp", method = RequestMethod.GET)
	public String signUpPage() {
		return "/srv/member/signUp";
	}
	@PostMapping(value="signUp")
	public String signUpSubmit() {
		return "redirect:/srv/main/main";
	}
	
}
