package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
	
	
		@Autowired
		StudentRepo repo;
		
		@PostMapping("/student")
		public ResponseEntity<Student>savedata(@RequestBody Student st)
		{
			return new ResponseEntity<>(repo.save(st),HttpStatus.CREATED);
		}
		
		@GetMapping("/student")
		public ResponseEntity<List<Student>>getdata()
		{
			return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
		}
		
		@GetMapping("/student/{id}")
		public ResponseEntity<Student>singledata(@PathVariable int id)
		{
			Optional<Student>obj=repo.findById(id);
			if(obj.isPresent())
			{
				return new ResponseEntity<>(obj.get(),HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		
		@PutMapping("/student/{id}")
		public ResponseEntity<Student>putdata(@PathVariable int id,@RequestBody Student stu)
		{
			Optional<Student>obj=repo.findById(id);
			if(obj.isPresent())
			{
			//obj.get().setName(stu.getName());
				obj.get().setDOB(stu.getDOB());
				obj.get().setGender(stu.getGender());
				
				return new ResponseEntity<>(repo.save(obj.get()),HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		@DeleteMapping("/student/{id}")
		public ResponseEntity<Student>deletedata(@PathVariable int id)
		{
			Optional<Student>obj=repo.findById(id);
			if(obj.isPresent())
			{
				repo.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}

	}


