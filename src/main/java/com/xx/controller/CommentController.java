package com.xx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xx.entity.Comment;
import com.xx.service.CommentService;
import com.xx.utils.Result;
import com.xx.utils.ResultUtil;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
	
	Comment comment=new Comment();
	
	@Autowired
	private CommentService commentService;

	
	@ResponseBody
	@RequestMapping(value = "/getlikeContent", method = RequestMethod.GET)
	public Result getlikeContent(String content) {
		System.out.println("====="+content);
		if(content.equals("")) {
			return ResultUtil.error();
		}
		else {
		System.out.println("====="+commentService.getlikeContent(content));
		List<Comment> comments=commentService.getlikeContent(content);
		return ResultUtil.success(comments);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Result add() {		
		comment.setContent("你好");
		commentService.add(comment);
		return ResultUtil.success(comment);		
	}
}
