package com.web.teacher.service.impl;

import com.web.teacher.dao.AnnounceDao;
import com.web.teacher.pojo.Announce;
import com.web.teacher.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("announceService")
public class AnnounceServiceImpl implements AnnounceService {
	@Autowired
	   private AnnounceDao announceDaoDao;
		public void add(Announce announce) {

			announceDaoDao.add(announce);
		}
        public void delete(Integer aid)
        {
        	announceDaoDao.delete(aid);
        }

        public void update(Announce announce)
        {
        	announceDaoDao.update(announce);
        }

		
		public List<Announce> queryAll() {
			
			return announceDaoDao.queryAll();
		}

	public Announce getAnnounceByAid(Integer aid) {

			return announceDaoDao.getAnnounceByAid(aid);
	}


}
