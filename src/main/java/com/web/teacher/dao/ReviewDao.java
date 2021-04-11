package com.web.teacher.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.teacher.pojo.Review;
@Repository("reviewDao")
public   interface ReviewDao {
	
    //���ۤ�
	public void review(Review review);
	//��ѯ����
	public List<Review> searchreview(Review review);
	public void delete(Review review);
}
