package com.xx.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xx.dao.CommentDao;
import com.xx.entity.Comment;


@Repository
public class CommentDaoImpl implements CommentDao{

	@Resource
	private SessionFactory sessionFactory;			
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//模糊查询
	@SuppressWarnings("unchecked")
	public List<Comment> getlikeContent(String content) {
		System.out.println("=====getlikeContentDAO");
		return (List<Comment>) this.getSession()
				.createQuery("from Comment as o where o.content like '%"+content+"%'").list();  
	}

	public void add(Comment comment) {		
		this.getSession().save(comment);	
	}

	
}
