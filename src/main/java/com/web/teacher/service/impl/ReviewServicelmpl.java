package com.web.teacher.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.teacher.dao.ReviewDao;
import com.web.teacher.pojo.Review;
import com.web.teacher.service.IReviewService;
@Service("reviewService")
public class ReviewServicelmpl implements IReviewService
{
	@Autowired
	private ReviewDao reviewDao;
	public void addreview(Review review)
	{
		//评论
		review.setLastDate(new Date());
		reviewDao.review(review);
	}
	public List<Review> searchreview(Review review)
	{
		//显示评论
		return reviewDao.searchreview(review);
	}
	public void delete(Review review) {
		 reviewDao.delete(review);
	}
}
 
