package com.rushi.project.service;

import java.util.List;

import com.rushi.project.model.Employee;

public interface Service {

	
	void create(Employee employee);
	
	List<Employee>getall();
	
	void update(Long id ,Employee employee);
	
	void delete(Long id);
	
	Employee getemployee(String name,String city);
	
	
}
