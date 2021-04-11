package com.web.teacher.util;

import java.util.ArrayList;
import java.util.List;


/**
 * 锟斤拷页
 * 1.锟斤拷前页
 * 2.锟杰硷拷录锟斤拷
 * 3.锟斤拷页锟斤拷
 * 4.每页锟斤拷示锟侥硷拷录锟斤拷
 */
public class PageBean<T> {
	private int rowsPerPage = 5;//每页锟斤拷示锟侥硷拷录锟斤拷---锟教讹拷写锟斤拷锟斤拷
	private int curPageno = 1;//锟斤拷前页---页锟芥传锟斤拷锟斤拷
	private int totalPageCount;//锟斤拷页锟斤拷
	private int totalRowsCount;//锟杰硷拷录锟斤拷
	private List<T> dataList = new ArrayList<T>();//锟斤拷诺锟角耙筹拷锟绞撅拷募锟铰�
	
	
	/**
	 * 锟斤拷页锟姐法
	 * @param list
	 * @param curPageStr
	 */
	public void page(List<T> list,String curPageStr){
		if(list==null){
			return;
		}
		
		totalRowsCount = list.size();
		
		//锟斤拷锟斤拷锟斤拷页锟斤拷
		if(totalRowsCount%rowsPerPage==0){//锟斤拷锟斤拷
			totalPageCount = totalRowsCount/rowsPerPage;
		}else{
			totalPageCount = totalRowsCount/rowsPerPage+1;
		}
		
		//锟斤拷前页
		try {
			curPageno = Integer.parseInt(curPageStr);
		} catch (Exception e) {
			curPageno = 1;
		}
		
		//锟斤拷锟斤拷前页 
		
		if(curPageno>=totalPageCount){
			curPageno = totalPageCount;
		}
		if(curPageno<=0){
			curPageno = 1;
		}
		
		int fromIndex = (curPageno-1)*rowsPerPage;
		int toIndex = fromIndex+rowsPerPage;
		
		if(toIndex>=totalRowsCount){
			toIndex = totalRowsCount;
		}
		//锟斤拷取锟斤拷前页锟斤拷录
		dataList = list.subList(fromIndex, toIndex);
		
	}
	
	
	
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	public int getCurPageno() {
		return curPageno;
	}
	public void setCurPageno(int curPageno) {
		this.curPageno = curPageno;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getTotalRowsCount() {
		return totalRowsCount;
	}
	public void setTotalRowsCount(int totalRowsCount) {
		this.totalRowsCount = totalRowsCount;
	}
	public List getDataList() {
		return dataList;
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
	
}

