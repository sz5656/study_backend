package com.yedam.app.dept.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller // Bean 등록, Web과 관련 
// 사용자의 요청(URI + Method) + 기능(Service) + 화면(View)
public class DeptController {
	private DeptService deptSvc;
	
	@Autowired
	public DeptController(DeptService deptService) {
		this.deptSvc = deptService;
	}
	
	//전체조회GET
	@GetMapping("deptList")
	public String deptAllList(Model model) {
		List<DeptVO> list = deptSvc.getDeptList();
		// 페이지에 데이터를 전달 => Model
		model.addAttribute("depts",list);
		return "list"; // 화면(View)
		// 경로 생성 => ViewResolver
		// /WEB-INF/views/list.jsp
	}
	
	@GetMapping("depts")
	public String redirectAllList() {
		
		return"redirect:deptList?keyword=Han";
	}
}
