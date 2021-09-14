package edu.spring.boot;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/hello.com")
	public ModelAndView hello() {
		
		System.out.println("컨트롤러 hello() 실행중");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("자바 프로그램");
		list.add("sql 프로그램");
		list.add("web server 프로그램");
		list.add("web client 프로그램");
		list.add("spring 프로그램");
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("insa", "hello boot");
		mv.addObject("list", list);
		mv.setViewName("hello");
		
		return mv;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/helloajax", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ArrayList<String> hello2(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("자바 프로그램");
		list.add("sql 프로그램");
		list.add("web server 프로그램");
		list.add("web client 프로그램");
		list.add("spring 프로그램");
		
		return list;
	}
}
