package com.example.demo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Student {
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		
		private int id;
		//private String Name;
		private String DOB;
		private String Gender;
		
		public String getGender() {
			return Gender;
		}
		public void setGender(String gender) {
			Gender = gender;
		}
		public int getId()
		{
			return id;
		}
		public void setId(int id)
		{
			this.id=id;
		}
		/*public String getName()
		{
			return Name;
		}
		public void setName(String name)
		{
			this.Name=Name;
		}*/
		public String getDOB()
		{
			return DOB;
		}
		public void setDOB(String DOB)
		{
			this.DOB=DOB;
		}
		
		Student(int Id,String DOB,String Gender)
		{
		this.id=id;
		//this.Name=Name;
		this.Gender=Gender;
		this.DOB=DOB;
		}
		Student()
		{
			
		}
		@Override
		public String toString() {
			return "Student [id=" + id +  ", DOB=" + DOB + ", Gender=" + Gender + "]";
		}
		
		
		

	}


