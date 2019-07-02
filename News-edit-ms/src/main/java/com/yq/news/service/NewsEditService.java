package com.yq.news.service;

import com.yq.news.pojo.News;

public interface NewsEditService {
	
	int addNews(News news);
	
	int updateNews(News news);
	
	int deleteNews(Integer[] ids);
}
