package com.web.teacher.service;

import java.util.List;

import javax.print.DocFlavor.STRING;

import com.web.teacher.pojo.Operate;
import com.web.teacher.pojo.Tiezi;
import com.web.teacher.pojo.User;

public interface ITieziService {
	public void add(Tiezi tiezi);
    public void delete(Integer tid);
    public void updatelnum(Tiezi tiezi);
    public void updatejsign(Tiezi tiezi);
    public Tiezi getTieziByTid(Integer tid);
    public List<Tiezi> searchBysection(String section);
    public List<Tiezi> searchAll(Tiezi tiezi);
    public List<Tiezi> searchRe(Tiezi tiezi);
    public List<Tiezi> searchJinghua(Tiezi tiezi);
    public List<Tiezi> search();
    public List<Tiezi> searchByS(Operate operate);
    public List<Tiezi> searchByRe(Operate operate);
    public List<Tiezi> searchMyTiezi(Tiezi tiezi);
    public List<Tiezi> getTieziTid(Tiezi tiezi);
    public List<Tiezi> searchtbyuid(Integer uid);
    
}
