package com.xx.dao;

import java.util.List;

import com.xx.entity.Person;

public interface PersonDao {

	public void add(Person person);

	public void update(Person person);

	public void deletebyId(String id);

	public List<Person> gets();

	public Person getbyId(String id);

	public Person getbyName(String name);
}
