package com.rushi.project.respository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rushi.project.model.Employee;

@org.springframework.stereotype.Repository
public interface Repository  extends CrudRepository<Employee, Long>{
	
@Query(value="select from Employee where name=?1 and city=?2",nativeQuery = true)	
Employee getemployeeBynameAndcity(String name,String city);

}

