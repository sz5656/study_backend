package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.customer.Customer;
import com.yedam.app.customer.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryClient {
	@Autowired 
	CustomerRepository custRepo;
	
	//@Test
	public void select() {
		List<Customer> customer =  custRepo.findByName("홍길동");
		System.out.println(customer.get(0).getPhone());
	}
	
	@Test
	public void insert() {
		Customer cust = new Customer();
		cust.setName("홍길동");
		cust.setPhone("0101111");
		custRepo.save(cust);
		
		Optional<Customer> customer = custRepo.findById(1L);
		customer.get().setPhone("0109999");
		custRepo.save(customer.get());
		assertEquals( customer.get().getName(),  "홍길동" );
	}
}
