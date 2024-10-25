package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
/*
 * AJAX + JSON + 다양한 클라이언트의 등장 => REST (새로운 형태의 서버)
 *  1) 페이지 없이 순수 데이터만 제공
 *  2) Endpoint(URI + Method)를 구성하는 새로운 방식
 *     URI(자원) + Method(GET, POST, PUT, DELETE / 기능)
 * */

//@Controller + 모든 메소드에 @ResponseBody 적용 => @RestController
@RestController
@CrossOrigin // CORS 해결
public class EmpRestController {
	private EmpService empService;
	public EmpRestController(EmpService empService) {
		this.empService = empService;
	}
	
	// 전체조회 : GET
	@GetMapping("emps")
	public List<EmpVO> empList() {
		return empService.empList();
	}
	
	// 단건조회
	@GetMapping("emps/{employeeId}")
	public EmpVO empInfo(@PathVariable Integer employeeId) {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(employeeId);
		return empService.empInfo(emp);
	}
	// 등록
	@PostMapping("emps") // @RequestBody : JSON
	public int empInsert(@RequestBody EmpVO empVO) {
		return empService.empInsert(empVO);
	}
	// 수정 PUT ( <=> POST ) => 전체데이터
	@PutMapping("emps/{employeeId}")
	public Map<String, Object> empUpdate(@PathVariable Integer employeeId,
										@RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		return empService.empUpdate(empVO);
	}
	// 삭제
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> empDelete(@PathVariable Integer employeeId) {
		return empService.empDelete(employeeId);
	} 
}
