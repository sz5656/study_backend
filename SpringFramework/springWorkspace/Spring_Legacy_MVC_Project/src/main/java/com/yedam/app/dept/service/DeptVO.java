package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
}
