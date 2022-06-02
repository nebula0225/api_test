package com.example.api_db_test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_db_test.dto.TestDto;
import com.example.api_db_test.service.TestService;

@RestController
@RequestMapping("/*")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	// private final TestService testService; // @RequiredArgsConstructor로 생성자 주입
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TestDto> list() {
		List<TestDto> list = testService.get_list();
		
		return list;
	}
	
	@RequestMapping(value = "/1", method = RequestMethod.POST)
	public List<TestDto> list_dto(@RequestBody TestDto dto) {
		// String name = "two";
		
		String name = dto.getName();
		
		return testService.get_one(name);
	}
	
	@RequestMapping(value = "/2", method = RequestMethod.POST)
	public List<TestDto> list_dto2(@RequestBody TestDto dto) {
		
		return testService.get_two(dto);
	}
	
	@RequestMapping(value = "/3", method = RequestMethod.POST)
	public ResponseEntity<Object> list_re(@RequestBody TestDto dto) {
	
		List<TestDto> list = testService.get_two(dto);
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Object> insert(@RequestBody TestDto dto) {
	
		String re = testService.insert(dto);
		if(re.equals("fail")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(re);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", re);
				
		return ResponseEntity.ok(map);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Object> update(@RequestBody TestDto dto) {
	
		String re = testService.update(dto);
		
		if(re.equals("fail")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(re);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", re);
				
		return ResponseEntity.ok(map);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Object> delete(@RequestBody TestDto dto) {
	
		String re = testService.delete(dto);
		
		if(re.equals("fail")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(re);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", re);
				
		return ResponseEntity.ok(map);
	}
	
	
}
