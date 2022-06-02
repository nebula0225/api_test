package com.example.api_db_test.service;

import java.util.List;

import com.example.api_db_test.dto.TestDto;

public interface TestService {
	public List<TestDto> get_list();
	

	public List<TestDto> get_one(String name);
	

	public List<TestDto> get_two(TestDto dto);
	
	public String insert(TestDto dto);
	
	public String update(TestDto dto);
	
	public String delete(TestDto dto);
}
