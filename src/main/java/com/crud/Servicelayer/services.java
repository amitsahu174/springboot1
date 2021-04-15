package com.crud.Servicelayer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Daolayer.Daolayer;

import com.crud.entity.Student;
import com.crud.repository.Student_repository;

@Service

public class services {
	@Autowired
	private Daolayer daolayer;
	@Autowired
	private Student_repository studentrepository;
	
	public List<Student>getdails()
	{
		return this.daolayer.getdetails();
	}
	public Optional<Student> getstudent(int id)
	{
	
		return this.daolayer .getstudentby( id);
	}
	public void deltestudentbyid(int id)
	{
		this.daolayer.deltestudentbyid(id);
		
	}
	public void updatestudent(Student student, int id) {
		// TODO Auto-generated method stub
		List<Student> list=(List<Student>)this.daolayer.getdetails();
		list=list.stream().map(b->
		{
			if(b.getId()==id)
			{
				b.setStudentname(student.getStudentname());
				b.setFather_name(student.getFather_name());
			}
			return this.studentrepository.save(b);
			
		}
			).collect(Collectors.toList());
		
	
	}
	public  Optional<Student> updates(Student student, int id) {
		// TODO Auto-generated method stub
	return	this.daolayer.updates(student,id);
		
	}
	public Student update2(Student std) {
		// TODO Auto-generated method stub
		return this.studentrepository.save(std);
	}
	public List<Student> getstudentbyname(String studentname)
	{
	
		return this.daolayer .getstudentbyname(studentname);
	}

}
