package com.crud.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Servicelayer.services;
import com.crud.entity.Student;
import com.crud.repository.Student_repository;

@ RestController
public class Control {
	@Autowired
	private Student_repository repository;
	@Autowired
	private services service;
	@GetMapping("/views")
	public String view()
	{
		return "view here is";
	}
	@PostMapping("/insert")
	public String add(@RequestBody Student student)
	{
		
		this.repository.insert(student);
		System.out.print(student);
		return "Success";
	}
	
	@GetMapping("/show")
	public List<Student> show()
	{
		return this.service .getdails();
	}
	@GetMapping("/show/{id}")
	public Optional<Student> getstudent(@PathVariable("id") int id)
	{
		Optional<Student> st= this.service.getstudent(id);
		if(st==null)
		{   
			return Optional.empty();
		}
		else
		{
			return st;
		}
	}
	@GetMapping("/name/{studentname}")
	public List<Student> getstudentbyname(@PathVariable("studentname") String name)
	{
		List<Student> st= (List<Student>)this.service.getstudentbyname(name);
		if(st==null)
		{   
			return null;
		}
		else
		{
			return st;
		}
	}
	@DeleteMapping("delete/{id}")
	public String deltestudent(@PathVariable("id") int id)
	{
		this.service.deltestudentbyid(id);
		return "this id deleted"+id;
	}
	@PutMapping("update/{id}")
	public Student updatestudent(@RequestBody Student student, @PathVariable("id") int id)
	{
		this.service.updatestudent(student,id);
		
		return student;
	}
	@PutMapping("up/{id}")
	public Optional<Student> update(@RequestBody Student student,@PathVariable("id") int id)
	{	
		return this.service.updates(student, id);
		 
	}
	
	@PutMapping("update2/")
	public Student update2(@RequestBody Student std)
	{
		return this.service.update2(std);
	}

	
}