package com.xx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xx.dao.PersonDao;
import com.xx.entity.Person;


@Transactional
@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;
	
	public void add(Person person) {
	   System.out.println("addservice========1");
       personDao.add(person);
       System.out.println("addservice========2");
	}

	public void update(Person person) {
       personDao.update(person);
	}


	public List<Person> gets() {
		return personDao.gets();
	}
	
	public void deletebyId(String id) {
		personDao.deletebyId(id);  		
	}

    public Person getbyId(String id) {
		return personDao.getbyId(id);
	}
    
    public Person getbyName(String name) {		
		return personDao.getbyName(name);
	}
}
