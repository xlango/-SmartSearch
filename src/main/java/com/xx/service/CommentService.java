package com.xx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xx.dao.CommentDao;
import com.xx.entity.Comment;


@Transactional
@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	public List<Comment> getlikeContent(String content) {
         return commentDao.getlikeContent(content);
	}

	public void add(Comment comment) {
		 commentDao.add(comment);		
	}


	
}
