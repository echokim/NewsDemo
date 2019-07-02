package com.yq.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yq.news.mapper.CategoryMapper;
import com.yq.news.pojo.Category;
import com.yq.news.pojo.News;
import com.yq.news.pojo.PageResult;
import com.yq.news.service.NewsQueryService;

@RestController
public class NewsController {
	
	@Autowired
	private NewsQueryService newsQueryService;
	
	@RequestMapping(value="/findAllNews",method=RequestMethod.GET)
	public List<News> findAllNews(){
		return newsQueryService.findAllNews();
	}
	
	@RequestMapping(value="/findAllCategory",method=RequestMethod.GET)
	public List<Category> findAllCategory(){
		System.out.println("findAllCategory()");
		return newsQueryService.findAllCategory();
	}
	
	//通过@requestBody可以将请求体中的JSON字符串绑定到相应的bean上，当然，也可以将其分别绑定到对应的字符串上。
	@RequestMapping(value="/findNewsByCondition",method=RequestMethod.POST)
	public List<News> findNewsByCondition(@RequestBody News news){
		return newsQueryService.findNewsByCondition(news);
	}
	
	@RequestMapping(value="/getNews/{id}",method=RequestMethod.GET)
	public News getNews(@PathVariable int id){
		return newsQueryService.getNews(id);
	}
	
	//分页查询
	@RequestMapping(value="/findByPage",method=RequestMethod.GET)
	public PageResult findByPage(Integer pageNum,Integer pageSize){
		return newsQueryService.findByPage(pageNum, pageSize);
	}
}
