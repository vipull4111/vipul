package com.rushi.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;

import com.rushi.project.model.Employee;
import com.rushi.project.respository.Repository;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:/application-junit.properties")
public class MainTest {
	

	@LocalServerPort
	private int port;

	@Autowired
	private Repository repo;
	
	private RequestSpecification requestSpecification;

	public void initrequestspecification() {
		final RequestSpecBuilder build=new RequestSpecBuilder();
		
RequestSpecification build2 = build.setBaseUri("http://localhost:"+port+"/employee").build();

	}
@BeforeEach
	public void setup() {
		repo.deleteAll();
	}
	
@Test
   public void testcreateemployee() {
	 //Given data of our Information is written
	Employee emp= new Employee();
	emp.setName("rushi");
	emp.setCity("Amravati");
	emp.setAddress("Gopal Naagar");
	 
	assertEquals(0, repo.count());
	
	//when after given Data To do
	
	RestAssured.given(requestSpecification)
	.contentType("application/json")
	.accept(MediaType.APPLICATION_JSON_VALUE)
	.body(emp).post("/create").then();
	
	//Then after all
	
	assertEquals(1,repo.count());
}
}
