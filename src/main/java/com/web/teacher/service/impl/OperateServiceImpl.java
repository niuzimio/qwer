package com.web.teacher.service.impl;

import java.util.List;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.teacher.dao.OperateDao;
import com.web.teacher.pojo.Operate;
import com.web.teacher.pojo.Tiezi;
import com.web.teacher.service.IOperateService;
@Service("opt")
public class OperateServiceImpl implements IOperateService{
	@Autowired
       private OperateDao oDao;
       public void addGZ(Operate operate)
       {
    	   oDao.addGZ(operate);
       }
       public void deleteGZ(Operate operate)
       {
    	   oDao.deleteGZ(operate);
       }
       public void addSC(Operate operate)
       {
    	   oDao.addSC(operate);
       }
       public void deleteSC(Operate operate)
       {
    	   oDao.deleteSC(operate);
       }
       public void addDZ(Operate operate)
       {
    	   oDao.addDZ(operate);
       }
       public void deleteDZ(Operate operate)
       {
    	   oDao.deleteDZ(operate);
       }
       public List <Operate> searchAll(Operate operate)
       {
    	   return oDao.searcho(operate);
       }
       public Integer searctpo(Operate operate) {
   		//���Ҹ����ӷ������Ƿ񱻹�ע
   		   Operate op=oDao.searchtpo(operate);
   		   if(op==null)
   		   {
   			   return 0;
   		   }
   		   else {
   			 return 1;
   		}
       }
   	public Integer searcto(Operate operate) {
   		//�����Ƿ��ղ�
   		Operate op=oDao.searchto(operate);
   		 if(op==null)
   		   {
   			   return 0;
   		   }
   		   else {
   			 return 1;
   		}
   	}
   	public Integer searchtt(Operate operate) {
   		//�����Ƿ񱻵���
   		Operate op=oDao.searchtt(operate);
   		 if(op==null)
   		   {
   			   return 0;
   		   }
   		   else {
   			 return 1;//����
   		}
   	}
   	public Integer searchg(Operate operate) {
   		//�����Ƿ񱻵���
   		Operate op=oDao.searchg(operate);
   		 if(op==null)
   		   {
   			   return 0;
   		   }
   		   else {
   			 return 1;//����
   		}
   	}
	public Integer getGZuid(Operate operate) {
		// ��ȡҪ��ע��id
		 Operate op1=oDao.searchuid(operate);
	   	 int key = op1.getUid();
	   	return key;
	}
}
