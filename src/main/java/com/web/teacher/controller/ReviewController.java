package com.web.teacher.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.teacher.pojo.Review;
import com.web.teacher.pojo.Tiezi;
import com.web.teacher.service.IReviewService;

//发表帖子

@Controller
public class ReviewController
{
	@Autowired
	private IReviewService reviewService;
	@RequestMapping("addReview")
	@ResponseBody
	public Integer addreview(Review review)
	{ //����
		review.setLastDate(new Date());
		reviewService.addreview(review);
		return 1;
	}
	@RequestMapping("searchReview")
	@ResponseBody
	public List<Review>searchreview(Review review,ModelMap model)
	{
	  //����ҳ����ʾ����
		return reviewService.searchreview(review);
		
	}
	@RequestMapping("deleteReview")
	@ResponseBody
	public Integer deleteReview(Review review)
	{ //����
		reviewService.delete(review);
		return 1;
	}
}
