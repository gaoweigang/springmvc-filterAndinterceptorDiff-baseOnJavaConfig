package com.gwg.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController {

	@RequestMapping(value = "/queryUserInfoById", method = RequestMethod.POST,  produces="application/json;charset=UTF-8")
	public @ResponseBody  String hello(){
		return "{\"name\":\"hello\"}";
	}

}
