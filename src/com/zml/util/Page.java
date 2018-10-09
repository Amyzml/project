package com.zml.util;

import java.util.List;

public class Page <T>{
	//总页数
	private int pageTotal;//4
	//当前的页数
	private int pageNow;
	
	private List<T> items;
	//开始的行数
	private int start;
	private int pageSize = 3;
	//总行数
	private int total;
	
	
	public Page(int pageNow,int total){
		
		this.total = total;
		
		pageTotal = total / pageSize;
		
		if (total % pageSize != 0) {
			pageTotal++;
		}
		
		if (pageNow < 1) {
			pageNow = 1;
		}
		
		if (pageNow > pageTotal) {
			pageNow = pageTotal;
		}
		
		this.pageNow = pageNow;
		
		start = (pageNow - 1) * pageSize;
	}
	
	
	
	
	
	
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
	
}
