package com.example.api_test.test;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Test {
	
	private String name;
	private String pwd;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date reg_date;
}
