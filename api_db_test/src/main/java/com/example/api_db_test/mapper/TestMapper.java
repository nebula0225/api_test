package com.example.api_db_test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.api_db_test.dto.TestDto;

@Mapper
public interface TestMapper {
	public List<TestDto> get_list();
	public List<TestDto> get_one(String name);
	
	public List<TestDto> get_two(TestDto dto);
	
	public int insert(TestDto dto);
	public int update(TestDto dto);
	public int delete(TestDto dto);
}
