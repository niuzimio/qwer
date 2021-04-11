package com.web.teacher.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.teacher.dao.ITieziDao;
import com.web.teacher.pojo.Operate;
import com.web.teacher.pojo.Tiezi;
import com.web.teacher.pojo.User;
import com.web.teacher.service.ITieziService;
@Service("tieziService")
public class TieziServiceImpl implements ITieziService{
	@Autowired
      private ITieziDao tieziDao;
      public void add(Tiezi tiezi)
      {
    	  tiezi.setLnum(0);
    	  tiezi.setJsign(0);
    	  tiezi.setModifyDate(new Date());
    	  tieziDao.add(tiezi);
      }
      
      public void delete(Integer tid)
      {
    	  tieziDao.delete(tid);
      }
      
      public void updatelnum(Tiezi tiezi)
      {
    	  tieziDao.updatelnum(tiezi);
      }
      
      public List <Tiezi> searchBysection(String section)
      {
    	  return tieziDao.searchBysection(section);	  
      }
      
      public List<Tiezi> searchAll(Tiezi tiezi) {
  		System.out.println(">>>>==="+tiezi);
  		if(tiezi.getJsign()!=null && tiezi.getJsign()==-1) {
  			tiezi.setJsign(null);
  		}
  		if(tiezi.getUname()==null || tiezi.getUname().trim().equals("")) {
  			tiezi.setUname(null);
  		}
  		else{
  			tiezi.setUname("%"+tiezi.getUname()+"%");
  		}
  		if(tiezi.getTitle()==null || tiezi.getTitle().trim().equals("")) {
  			tiezi.setTitle(null);
  		}else{
  			tiezi.setTitle("%"+tiezi.getTitle()+"%");
  		}
  		return tieziDao.searchAll(tiezi);
  	}
	
	public List<Tiezi> searchRe(Tiezi tiezi)
	//�Ƽ������ӣ�������������
	{
		System.out.println(">>>>==="+tiezi);
		if(tiezi.getTitle()==null || tiezi.getTitle().trim().equals("")) {
			tiezi.setTitle(null);
		}else{
			tiezi.setTitle("%"+tiezi.getTitle()+"%");
		}
		return tieziDao.searchRe(tiezi);
	}
	public List<Tiezi> search() {
		// ȫ������
		return tieziDao.search();
	}
	public Tiezi getTieziByTid(Integer tid)
	   {
		   Tiezi tiezi=tieziDao.getTieziByTid(tid);
		   return tiezi;
	   }
	public List<Tiezi> searchByS(Operate operate) {
		// �ղص�����
		return tieziDao.searchByS(operate);
	}
	public List<Tiezi> searchJinghua(Tiezi tiezi) {
		// �Ӿ�������
		return tieziDao.searchJinghua(tiezi);
	}
	public List<Tiezi> searchByRe(Operate operate) {
		// ��ע���˷�������
		return tieziDao.searchByRe(operate);
	}

	public List<Tiezi> searchMyTiezi(Tiezi tiezi) {
		// TODO Auto-generated method stub
		return tieziDao.searchMytiezi(tiezi);
	}

	public List<Tiezi> getTieziTid(Tiezi tiezi) {
		// TODO Auto-generated method stub
		return tieziDao.getTieziTid(tiezi);
	}

	public List<Tiezi> searchtbyuid(Integer uid) {
		// TODO Auto-generated method stub
		return tieziDao.searchtbyuid(uid);
	}

	public void updatejsign(Tiezi tiezi) {
		tieziDao.updateJsign(tiezi);	
	}
}
