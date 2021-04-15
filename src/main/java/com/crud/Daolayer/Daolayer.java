package com.crud.Daolayer;

import java.util.List;
import java.util.Optional;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.crud.entity.Student;
import com.crud.repository.Student_repository;

@Component
public class Daolayer {
	@Autowired
	private Student_repository studentrepository;
	
	public List<Student> getdetails()
	{
		List<Student> list=(List<Student>)this.studentrepository.findAll();
		return list;
	}
	
	public Optional<Student> getstudentby(int id)
	{
		return this.studentrepository .findById(id);
	}
	public List<Student> getstudentbyname(String studentname)
	{
		return (List<Student>)this.studentrepository.findBystudentname(studentname);
	}

	public void deltestudentbyid(int id) {
		// TODO Auto-generated method stub
		this.studentrepository.deleteById(id);
		
	}

	public Optional<Student>  updates(Student student, int id) {
		// TODO Auto-generated method stub
		
		Optional<Student> oldstd=studentrepository.findById(id);
		
		if(oldstd!=null)
		  {
		  oldstd.ifPresent(b->b.setStudentname(student.getStudentname()));
		  oldstd.ifPresent(b->b.setFather_name(student.getFather_name()));
		  oldstd.ifPresent(b -> studentrepository.save(b));
		
		return oldstd;
		  }
		else
		{
			return null;
		}
	}
	
	
}
