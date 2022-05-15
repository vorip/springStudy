package co.kr.spring.mng.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/mng/auth/*")
public class MngAuthController {

	//주석다시추가
	@RequestMapping(value="list")
	public String list() {
		return "/mng/auth/list";
	}
}
