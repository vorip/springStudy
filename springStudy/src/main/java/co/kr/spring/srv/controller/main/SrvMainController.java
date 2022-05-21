package co.kr.spring.srv.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SrvMainController {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@RequestMapping("/srv/main/main")
	public String main(HttpServletRequest request, HttpServletResponse response) {
		logger.info("가져옴");
		return "srv/main/main";
	}
	
}
