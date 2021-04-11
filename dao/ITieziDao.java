package com.web.teacher.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.teacher.pojo.Operate;
import com.web.teacher.pojo.Tiezi;
import com.web.teacher.pojo.User;
@Repository("tieziDao")
public interface ITieziDao {
         public void add(Tiezi tiezi);
         //鍙戣〃甯栧瓙
         public void delete(Integer tid);
         //鍒犻櫎甯栧瓙
         public void updatelnum(Tiezi tiezi);
         //鐐硅禐鏁版洿鏂�
         public void updateJsign(Tiezi tiezi);
         public List<Tiezi> searchBysection(String section);
         //鏍规嵁鏉垮潡鏌ユ壘
         public List<Tiezi> search();
         public List<Tiezi> searchAll();
         //妯＄硦鏌ヨ
		 public List<Tiezi> searchAll(Tiezi tiezi);
		//鏌ユ壘鍏ㄩ儴
		 public Tiezi getTieziByTid(Integer tid);
		//鏍规嵁id鏌ヨ甯栧瓙
		 public List<Tiezi> searchByS(Operate operate);
		 //收藏的帖子
		 public List<Tiezi> searchByRe(Operate operate);
		 //关注的人的帖子
		 public List<Tiezi> searchRe(Tiezi tiezi);
		 //推荐帖子
		 public List<Tiezi> searchJinghua(Tiezi tiezi);
		 //精华帖子
		 public List<Tiezi> searchMytiezi(Tiezi tiezi);
		 //查找我发布的帖子
		 public List<Tiezi> getTieziTid(Tiezi tiezi);
		 public List<Tiezi> searchtbyuid(Integer uid);
		 
		 
}
