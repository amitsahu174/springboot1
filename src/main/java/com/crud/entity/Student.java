package com.crud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="details")

public class Student {
		private int id ;
		private String studentname;
		private String father_name;

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Student(String studentname, String father_name, int id) {
			super();
			this.studentname = studentname;
			this.father_name = father_name;
			this.id = id;
		}
		public String getStudentname() {
			return studentname;
		}
		public void setStudentname(String studentname) {
			this.studentname = studentname;
		}
		public String getFather_name() {
			return father_name;
		}
		public void setFather_name(String father_name) {
			this.father_name = father_name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

				
}
