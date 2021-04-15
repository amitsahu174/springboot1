package com.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.entity.Student;



public interface student_repository extends MongoRepository<Student,Integer> {

}
