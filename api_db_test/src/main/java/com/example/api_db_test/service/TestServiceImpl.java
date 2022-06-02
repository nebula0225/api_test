package com.example.api_db_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_db_test.dto.TestDto;
import com.example.api_db_test.mapper.TestMapper;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper mapper;
	
	@Override
	public List<TestDto> get_list() {
		List<TestDto> list = mapper.get_list();
		return list;
	}

	@Override
	public List<TestDto> get_one(String name) {
		// where = name
		
		List<TestDto> list = mapper.get_one(name);
		
		return list;
	}

	@Override
	public List<TestDto> get_two(TestDto dto) {
		return mapper.get_two(dto);
	}

	@Override
	public String insert(TestDto dto) {
		int result;
		String re;
		
		result = mapper.insert(dto);
		if(result != 1) {
			re = "insert fail";
		} else {
			re = "insert success";
		}
		
		return re;
	}

	@Override
	public String update(TestDto dto) {
		int result;
		String re;
		
		result = mapper.update(dto);
		if(result != 1) {
			re = "update fail";
		} else {
			re = "update success";
		}
		
		return re;
	}

	@Override
	public String delete(TestDto dto) {
		int result;
		String re;
		
		result = mapper.delete(dto);
		if(result != 1) {
			re = "delete fail";
		} else {
			re = "delete success";
		}
		
		return re;
	}

}
