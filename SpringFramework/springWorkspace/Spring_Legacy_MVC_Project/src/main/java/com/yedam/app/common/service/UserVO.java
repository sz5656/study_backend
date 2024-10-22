package com.yedam.app.common.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserVO {
	private String userId;
	private String userName;
	private String comments;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // => SimpleDateFormat
	private Date joinDate; // yy/MM/dd || <input type="date>: yyyy-MM-dd
}
