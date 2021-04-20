package com.web.teacher.dao;

import com.web.teacher.pojo.Announce;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("announceDao")
public interface AnnounceDao {

public void add(Announce announce);

public void delete(Integer aid);

public List<Announce> queryAll();

public void update(Announce announce);

public Announce getAnnounceByAid(Integer aid);
}