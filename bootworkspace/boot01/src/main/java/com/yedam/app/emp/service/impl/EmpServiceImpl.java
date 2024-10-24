package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{

	private EmpMapper empMapper;
	
	//@Autowired : 생성자가 하나만 사용될 경우 생략 가능
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}
	
	@Override
	public List<EmpVO> empList() {
		return empMapper.selectAllList();
	}

	@Override
	public EmpVO empInfo(EmpVO empVO) {
		return empMapper.selectInfo(empVO);
	}

	@Override
	public int empInsert(EmpVO empVO) {
//		return empMapper.insertInfo(empVO);
		int result = empMapper.insertInfo(empVO);
		return result == 1 ? empVO.getEmployeeId() : -1;
	}

	@Override
	public Map<String, Object> empUpdate(EmpVO empVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isSuccessed = false;
		
		int result = empMapper.updateInfo(empVO.getEmployeeId(), empVO);
		
		if(result == 1) isSuccessed = true;
		map.put("result", isSuccessed);
		map.put("target", empVO);
		// map 은 JSON 형태로 출력됨
		return map;
	}

	@Override
	public Map<String, Object> empDelete(int empId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = empMapper.deleteInfo(empId);
		
		if (result == 1) map.put("employeeId", empId);
		
		return map;
	}

}
