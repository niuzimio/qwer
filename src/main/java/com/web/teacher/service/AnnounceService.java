package com.web.teacher.service;

import com.web.teacher.pojo.Announce;

import java.util.List;

public interface AnnounceService {

	public void add(Announce announce);
	public void delete(Integer aid);

	public void update(Announce announce);

	public List<Announce> queryAll();

	public Announce getAnnounceByAid(Integer aid);
}

