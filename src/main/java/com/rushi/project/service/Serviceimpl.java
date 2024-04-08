package com.rushi.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.rushi.project.exception.Errorcode;
import com.rushi.project.exception.Resourcenotfoundexception;
import com.rushi.project.model.Employee;
import com.rushi.project.respository.Repository;

@org.springframework.stereotype.Service
public class Serviceimpl  implements Service{
     
	@Autowired
	private Repository repo;
	
	@Override
	public void create(Employee employee) {
		
		repo.save(employee);
		
	}

	@Override
	public List<Employee> getall() {
		
		return (List<Employee>)repo.findAll();
	}

	@Override
	public void update(Long id, Employee employee) {
	Optional<Employee> employeedata= repo.findById(id);
			if(employeedata.isPresent()) {
			Employee existingdata = employeedata.get();
			existingdata.setName(employee.getName());
			existingdata.setCity(employee.getCity());
			existingdata.setAddress(employee.getAddress());
			repo.save(existingdata);
	}
			else {
				throw new Resourcenotfoundexception(Errorcode.DATA_NOT_FOUND.getCode(),Errorcode.DATA_NOT_FOUND.getMessage());
			}
	}
	@Override
	public void delete(Long id) {
		
		repo.deleteById(id);
		
	}

	@Override
	public Employee getemployee(String name, String city) {
		
		return repo.getemployeeBynameAndcity(name, city);
	}

	
	
}
