package com.example.CRUD.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
