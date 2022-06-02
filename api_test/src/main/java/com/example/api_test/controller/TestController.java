package com.example.api_test.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.api_test.test.Test;

@Controller
@RequestMapping(value = "/*")
public class TestController {

	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Object get(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "pwd") String pwd
			) {
		Test t = new Test();
		Date now = new Date();
		
		t.setName(name);
		t.setPwd(pwd);
		t.setReg_date(now);
		
		return t;
	}
	
	@ResponseBody
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<Test> post(@RequestBody Test t) throws Exception {

		ResponseEntity<Test> re;
		
		try {
			re = new ResponseEntity<>(t, HttpStatus.OK);
			System.out.println(re);
		} catch (Exception e) {
			e.printStackTrace();
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return re;
	}
	
	@ResponseBody
	@RequestMapping(value = "/post2", method = RequestMethod.POST)
	public Map<String, Object> post2(@RequestBody Test t) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", t.getName());
		map.put("pwd", t.getPwd());
		
		map.forEach((key,value) -> {
			System.out.println(key + ":" + value);
		});
		
		return map;
	}
	
	@ResponseBody
	@PostMapping("/post3")
	public Test post3(@RequestBody Test t) {
		Date now = new Date();
		t.setReg_date(now);
		System.out.println(t);
		return t;
	}
}
