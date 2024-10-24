package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {
	@Autowired
	private EmpMapper empMapper;	
	@Test
	void contextLoads() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("hong@hong.hong");
		empVO.setJobId("IT_PROG");
		
		int result = empMapper.insertInfo(empVO);
		assertEquals(result, 1);
	}

}
