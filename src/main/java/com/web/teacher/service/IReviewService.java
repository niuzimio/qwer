package com.web.teacher.service;


import java.util.List;

import com.web.teacher.pojo.Review;
public interface IReviewService {
	public void addreview(Review review);
	public  List<Review> searchreview(Review review);
	public void delete(Review review);
}
