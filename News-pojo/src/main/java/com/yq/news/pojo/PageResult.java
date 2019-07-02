package com.yq.news.pojo;

import java.util.List;

public class PageResult {
	//分页区间数
	private List rows;
	private Long total;
	
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	
	
}
