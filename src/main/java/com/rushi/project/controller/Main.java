package com.rushi.project.controller;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushi.project.model.Employee;
import com.rushi.project.service.Service;

@RestController
@RequestMapping("/Employee")
public class Main {
     
	@Autowired
	private Service service;
	
	private static final org.slf4j.Logger Log=LoggerFactory.getLogger(Main.class);
	
	@PostMapping("/create")
	public ResponseEntity<Void>createemployee(@RequestBody Employee emp ){
		
		Log.trace("Start:Main controler-->createemployee-->"+emp);
		service.create(emp);
		String output="Main"+emp;
		Log.error("End:Main controler-->createemployee-->"+emp);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/getdata")
	public ResponseEntity<List<Employee>> getemployee(){
		
		
		return new ResponseEntity<List<Employee>>(service.getall(),HttpStatus.OK);
		
		}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateemployee(@PathVariable("id")Long id,@RequestBody Employee employee){
		service.update(id, employee);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@GetMapping("/getbynamecity")
	public ResponseEntity<Employee> getemployeeasperdata(@RequestParam String name,@RequestParam String city){
		
		return new ResponseEntity<Employee>(service.getemployee(name, city),HttpStatus.OK);
		
	}
	
	
}
