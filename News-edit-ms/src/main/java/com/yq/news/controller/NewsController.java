package com.yq.news.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yq.news.pojo.News;
import com.yq.news.pojo.Result;
import com.yq.news.service.NewsEditService;

@RestController
public class NewsController {
	@Autowired
	private NewsEditService newsService;
	
	@RequestMapping("/addNews")
	public Result addNews(@RequestBody News news) {
		System.out.println(news.getId());
		System.out.println(news.getTitle());
		news.setCreatedate(new Date());
		Result result = new Result();
		int row = newsService.addNews(news);
		if(row>0) {
			result.setSuccess(true);
			result.setMessage("添加成功");
		}else {
			result.setSuccess(false);
			result.setMessage("添加失败！");
		}
		return result;
	}
	
	@RequestMapping("/updateNews")
	public Result updateNews(@RequestBody News news) {
		System.out.println(news.getId());
		System.out.println(news.getTitle());
		System.out.println(news.getCategoryid());
		Result result = new Result();
		int row = newsService.updateNews(news);
		if(row>0) {
			result.setSuccess(true);
			result.setMessage("修改成功");
		}else {
			result.setSuccess(false);
			result.setMessage("修改失败！");
		}
		return result;
	}
	
	@RequestMapping("/deleteNews")
	public Result deleteNews(Integer[] ids) {
		System.out.println(ids[0]);
		Result result = new Result();
		int row = newsService.deleteNews(ids);
		if(row>0) {
			result.setSuccess(true);
			result.setMessage("删除成功！");
		}else {
			result.setSuccess(false);
			result.setMessage("删除失败！");
		}
		return result;
	}
	
}
