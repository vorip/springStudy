package co.kr.spring.mng.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/mng/main/*")
public class MngMainController {
	
	@GetMapping(value="main")
	public String main() {
		return "/mng/main/main";
	}
}
