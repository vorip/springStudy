package co.kr.spring.srv.controller.main;

import java.awt.Button;
import java.awt.Event;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.kr.spring.srv.mapper.BbsMapper;
import co.kr.spring.vo.BbsVo;

@RestController("/srv")
public class SrvMainController {
	
	@Autowired
	BbsMapper bbsMapper;
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@GetMapping("/member")
	public String main(HttpServletRequest request, HttpServletResponse response) {
		List<BbsVo> list = bbsMapper.getBbs();
		Button btn = new Button();
		System.out.println("가져옴");
		return "srv/main/main";
	}
	@ResponseBody
	@PostMapping("/member")
	public String main1(@RequestBody String value, HttpServletRequest request, HttpServletResponse response) {
		List<BbsVo> list = bbsMapper.getBbs();
		System.out.println("가져옴");
		return "srv/main/main";
	}
	@GetMapping("/member")
	public String main2(HttpServletRequest request, HttpServletResponse response) {
		List<BbsVo> list = bbsMapper.getBbs();
		System.out.println("가져옴");
		return "srv/main/main";
	}
	@GetMapping("/member")
	public String main3(HttpServletRequest request, HttpServletResponse response) {
		List<BbsVo> list = bbsMapper.getBbs();
		System.out.println("가져옴");
		return "srv/main/main";
	}
	
}
