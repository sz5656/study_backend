package com.yedam.app.emp.service;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 기본생성자
@Getter
@Setter
@ToString
public class EmpVO {
	//COLUMN_NAME
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private Double salary;
	private double commissionPct;
	private Integer managerId;
	private Integer departmentId;
	//COLUMN_NAME END
}
