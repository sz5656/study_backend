package com.yedam.app.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {
	
	@Autowired
	CustomerRepository repo;
	@ResponseBody
	@GetMapping("/customer")
	public List<Customer> list() {
		List<Customer> list = repo.findAll();
		//System.out.println(Integer.toString(list.size()));
		log.debug(Integer.toString(list.size()));
		
		return list;
	}
	
}
