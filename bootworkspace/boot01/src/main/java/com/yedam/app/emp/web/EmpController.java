package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;

import com.yedam.app.emp.service.EmpService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // final 선언 필드를 생성자 강제 생성
public class EmpController {
	private final EmpService empService;
}
