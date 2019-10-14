/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: GoodsController.java 
 * @Prject: zhangkai-senior2-week2
 * @Package: com.zhangkai.controller 
 * @Description: TODO
 * @author: 张凯   
 * @date: 2019年10月14日 上午10:08:41 
 * @version: V1.0   
 */
package com.zhangkai.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhangkai.domain.Goods;

/** 
 * @ClassName: GoodsController 
 * @Description: TODO
 * @author: 张凯
 * @date: 2019年10月14日 上午10:08:41  
 */
@Controller
public class GoodsController {

	@SuppressWarnings("rawtypes")
	@Autowired
	
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("findAll")
	public String findAll(Model model,@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "5") Integer pageSize) {
		List<Goods> list = redisTemplate.opsForList().range("productList", (page-1)*pageSize, (page-1)*pageSize+pageSize-1);
		model.addAttribute("list", list);
		if(page!=1) {
			model.addAttribute("prePage",page-1);
		}else {
			model.addAttribute("prePage",1);
		}
		
		model.addAttribute("nextPage",page+1);
		return "list";
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("findAllByZset")
	public String findAllByZset(Model model,@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "5") Integer pageSize) {
//		Set range = redisTemplate.opsForZSet().reverseRange("goodsZSet", (page-1)*pageSize, (page-1)*pageSize+pageSize-1);
		List<Goods> list = redisTemplate.opsForList().range("productList", (page-1)*pageSize, (page-1)*pageSize+pageSize-1);
		model.addAttribute("list", list);
		if(page!=1) {
			model.addAttribute("prePage",page-1);
		}else {
			model.addAttribute("prePage",1);
		}
		
		model.addAttribute("nextPage",page+1);
		return "list2zset";
	}
	
	
}
