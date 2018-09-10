package com.gwg.demo.controller;

import com.gwg.demo.filter.OneFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(OneFilter.class);


	@RequestMapping(value = "/test1", method = RequestMethod.GET,  produces="application/json;charset=UTF-8")
	public String test1(){
		logger.info("************************test1 executed***********************");
		return "hello";
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET,  produces="application/json;charset=UTF-8")
	public  String test2(){
		logger.info("***********************test2 executed*********************");
		return "index";
	}



}
