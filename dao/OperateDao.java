package com.web.teacher.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.teacher.pojo.Operate;
@Repository("oDao")
public interface OperateDao {
      public void addGZ(Operate operate);
      public void addSC(Operate operate);
      public void addDZ(Operate operate);
      public void deleteGZ(Operate operate);
      public void deleteSC(Operate operate);
      public void deleteDZ(Operate operate);
      public List <Operate> searcho(Operate operate);
      public Operate searchtpo(Operate operate);
      public Operate searchuid(Operate operate);
      public Operate searchto(Operate operate);
      public Operate searchtt(Operate operate);
      public Operate searchg(Operate operate);
}
