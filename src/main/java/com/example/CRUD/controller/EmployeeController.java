package com.example.CRUD.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUD.exception.ResourceNotFoundException;
import com.example.CRUD.model.Employee;
import com.example.CRUD.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll()
;	}
	
//	@GetMapping("/employees")
//	public ResponseEntity<?> getEmployees(){
//		return ResponseEntity.ok(this.employeeRepository.findAll());
//	}
	
	//create employee rest API
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//get employee by id rest API
	@GetMapping("/employees/{id}")  // Update this line to match the URL you are accessing
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
	    Employee employee = employeeRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
	    return ResponseEntity.ok(employee);
	}

	
	//update employee rest APIn
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employeeDetails){
		 Employee employee = employeeRepository.findById(id)
	        		.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
		 
		 employee.setFirst_name(employeeDetails.getFirst_name());
		 employee.setLast_name(employeeDetails.getLast_name());
		 employee.setEmail_id(employeeDetails.getEmail_id());
		 
		 Employee updatedEmployee=employeeRepository.save(employee);
		 return ResponseEntity.ok(updatedEmployee);
	}
	
	//delete employee REST API
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable String id){
		 Employee employee = employeeRepository.findById(id)
	        		.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
		 
		 employeeRepository.delete(employee);
		 Map<String,Boolean> response=new HashMap<>();
		 response.put("deleted",Boolean.TRUE);
		 return ResponseEntity.ok(response);
		 
	}
}
