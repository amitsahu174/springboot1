package com.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.entity.Student;
@Repository
public interface Student_repository extends MongoRepository<Student,Integer>{

	List<Student> findBystudentname(String studentname);
	
	}
