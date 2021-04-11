package com.web.teacher.service;

import java.util.List;

import com.web.teacher.pojo.Operate;
import com.web.teacher.pojo.Tiezi;
import com.web.teacher.pojo.User;

public interface IOperateService {
        public void addGZ(Operate operate);
        public void deleteGZ(Operate operate);
        public void addSC(Operate operate);
        public void addDZ(Operate operate);
        public void deleteSC(Operate operate);
        public void deleteDZ(Operate operate);
        public List<Operate> searchAll(Operate operate);
        public Integer searctpo(Operate operate);
        public Integer getGZuid(Operate operate);
        public Integer searcto(Operate operate);
        public Integer searchtt(Operate operate);
        public Integer searchg(Operate operate);
}
