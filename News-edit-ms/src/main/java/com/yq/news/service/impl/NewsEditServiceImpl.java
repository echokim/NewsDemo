package com.yq.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yq.news.mapper.NewsMapper;
import com.yq.news.pojo.News;
import com.yq.news.service.NewsEditService;

@Service
@Transactional
public class NewsEditServiceImpl implements NewsEditService{
	@Autowired
	private NewsMapper newsMapper;

	@Override
	public int addNews(News news) {
		return newsMapper.insert(news);
	}

	@Override
	public int updateNews(News news) {
		return newsMapper.updateByPrimaryKey(news);
	}

	@Override
	public int deleteNews(Integer[] ids) {
		int row = 0;
		for (Integer id : ids) {
			row =newsMapper.deleteByPrimaryKey(id);
		}
		return row;
	}

}
