package com.yq.news.service.impl;

import java.util.List;

import org.hibernate.validator.internal.util.privilegedactions.NewSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yq.news.mapper.CategoryMapper;
import com.yq.news.mapper.NewsMapper;
import com.yq.news.pojo.Category;
import com.yq.news.pojo.News;
import com.yq.news.pojo.NewsExample;
import com.yq.news.pojo.NewsExample.Criteria;
import com.yq.news.pojo.PageResult;
import com.yq.news.service.NewsQueryService;

@Service
@Transactional
public class NewsQueryServiceImpl implements NewsQueryService {
	
	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<News> findAllNews() {
		return newsMapper.selectByExample(null);
	}
	@Override
	public List<Category> findAllCategory() {
		return categoryMapper.selectByExample(null);
	}
	@Override
	public List<News> findNewsByCondition(News news) {
		NewsExample example = new NewsExample();
		Criteria criteria = example.createCriteria();
		if(news!=null) {
			if(news.getCategoryid()!=0) {
				criteria.andCategoryidEqualTo(news.getCategoryid());
			}
			if(news.getTitle()!=null&&!"".equals(news.getTitle())) {
				criteria.andTitleLike("%"+news.getTitle()+"%");
			}
		}
		List<News> list = newsMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public News getNews(int id) {
		return newsMapper.selectByPrimaryKey(id);
	}
	@Override
	public PageResult findByPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<News> page = (Page<News>) newsMapper.selectByExample(null);
		PageResult pageResult = new PageResult();
		pageResult.setRows(page.getResult());
		pageResult.setTotal(page.getTotal());
		return pageResult;
	}

}
