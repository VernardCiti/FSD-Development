package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository empRepository;
	
	@GetMapping
	public Iterable<Employee> getEmployee() {
		return empRepository.findAll();}
	
	@PostMapping(consumes="application/json")
	public Employee createEmployee(@RequestBody Employee emp) {
		emp=empRepository.save(emp);
		return emp;}

}
