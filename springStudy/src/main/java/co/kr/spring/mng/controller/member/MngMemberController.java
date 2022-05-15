package co.kr.spring.mng.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/mng/member/*")
public class MngMemberController {
	
	@RequestMapping(value="list")
	public String list() {
		return "/mng/member/list";
	}
}
