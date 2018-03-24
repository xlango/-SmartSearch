package com.xx.controller;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xx.entity.Person;
import com.xx.service.PersonService;
import com.xx.utils.Result;
import com.xx.utils.ResultUtil;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

	private Person person = new Person();
	
	@Autowired
	private PersonService personService;

	
	@RequestMapping(value = "/login")
	public String login() {
//		person.setAge(8);
//		person.setBirthday(Date.valueOf("1997-01-21"));
//		person.setHas_girlfriend(true);
//		//person.setId(2);
//		person.setName("xx");
//		person.setPassword("123");
//		personService.add(person);
//		System.out.println("================" + ResultUtil.success(person));
		return "login";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		person.setAge(8);
		person.setBirthday(Date.valueOf("1997-01-21"));
		person.setHas_girlfriend(true);
		person.setId(1);
		person.setName("xx");
		person.setPassword("123");
		System.out.println("================" + ResultUtil.success(person));
		return "test";
	}
	
	@ResponseBody
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public Result aha() {
		person.setAge(8);
		person.setBirthday(Date.valueOf("1997-01-21"));
		person.setHas_girlfriend(true);
		person.setId(1);
		person.setName("xx");
		person.setPassword("123");
		System.out.println("================" + ResultUtil.success(person));
		return ResultUtil.success(person);
	}

	@ResponseBody
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public Result dologin(String username,String password) {
		System.out.println(username+"====="+password);	
		person=personService.getbyName(username);
		if (person!=null) {
			if(person.getPassword().equals(password)) {			
				return ResultUtil.success();
			}else {
				return ResultUtil.error();
			}			
		}
		else {
			return ResultUtil.error();
		}		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public Result getuser(String username) {
		System.out.println(username);	
		person=personService.getbyName(username);
		if (person!=null) {		
				return ResultUtil.success();		
		}
		else {
			return ResultUtil.error();
		}		
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {			
		return "index";							
	}
	
	@ResponseBody
	@RequestMapping(value = "/indexdata", method = RequestMethod.GET)
	public Result indexdata() {	
		List<Person> persons=personService.gets();			
		return ResultUtil.success();							
	}
}
