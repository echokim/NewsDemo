package com.yq.news.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.yq.news.pojo.Category;
import com.yq.news.pojo.News;
import com.yq.news.pojo.PageResult;

public interface NewsQueryService {
	List<News> findAllNews();
	
	List<Category> findAllCategory();
	
	List<News> findNewsByCondition(News news);
	
	News getNews(int id);
	
	PageResult findByPage(Integer pageNum, Integer pageSize);
	
}
