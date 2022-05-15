package co.kr.spring.mng.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/mng/auth/*")
public class MngAuthController {

	@RequestMapping(value="list")
	public String list() {
		return "/mng/auth/list";
	}
}
