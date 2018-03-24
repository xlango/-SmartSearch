package com.xx.dao;

import java.util.List;

import com.xx.entity.Comment;


public interface CommentDao {

	public void add(Comment comment);

	/*public void update(Comment comment);

	public void deletebyId(String id);

	public List<Comment> gets();

	public Comment getbyId(String id);

	public Comment getbyName(String content);*/
	
	public List<Comment> getlikeContent(String content);
}
