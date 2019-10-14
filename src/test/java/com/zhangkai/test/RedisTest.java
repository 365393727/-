package com.zhangkai.test;
import java.io.File;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhangkai.domain.Goods;
import com.zhangkai.utils.DateUtil;
import com.zhangkai.utils.RandomUtil;
import com.zhangkai.utils.StreamUtil;
import com.zhangkai.utils.StringUtil;

/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: RedisTest.java 
 * @Prject: zhangkai-senior2-week2
 * @Package:  
 * @Description: TODO
 * @author: 张凯   
 * @date: 2019年10月14日 上午9:30:17 
 * @version: V1.0   
 */

/** 
 * @ClassName: RedisTest 
 * @Description: TODO
 * @author: 张凯
 * @date: 2019年10月14日 上午9:30:17  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class RedisTest {
	
	@Autowired
	RedisTemplate redisTemplate;
	//往zset里存数据
	@SuppressWarnings("unchecked")
	@Test
	public void testReadZset() throws Exception {
		
		File file = new File("D:\\week2.txt");
		List<String[]> list = StreamUtil.readFile(file, "==");
//		String file2 = StreamUtil.readTextFile(file);
		for (String[] strings : list) {
			
			Goods goods = new Goods();
			goods.setId(strings[0]);
//			b)商品名称要使用hasText()方法判断有没有值。（2分）
			boolean b = StringUtil.hasText(strings[1]);
			if (b) {
				
				goods.setName(strings[1]);
			}else {
				System.out.println("姓名是空值！！！！");
			}
			goods.setPrice(strings[2]);
			if (b) {
				
				goods.setName(strings[2]);
			}else {
				System.out.println("价格是空值！！！！");
			}
			goods.setBaifen(strings[3]);
			System.out.println(goods);
			redisTemplate.opsForSet().add("goodsZSet", goods,10);
		}
		
	}
	
//	测试从zset取数据
	@SuppressWarnings("unchecked")
	@Test
	public void testFindZset() {
//		Set range = redisTemplate.opsForZSet().range("goodsZSet", 0, -1);
		Set<Goods> range = redisTemplate.opsForZSet().reverseRange("goodsZSet", 0, -1);
		for (Object object : range) {
			System.out.println(object);
		}
	}
//	//往list里存数据
	@SuppressWarnings("unchecked")
	@Test
	public void testRead() throws Exception {
		File file = new File("D:\\week2.txt");
		List<String[]> list = StreamUtil.readFile(file, "==");
//		String file2 = StreamUtil.readTextFile(file);
		for (String[] strings : list) {
			
			Goods goods = new Goods();
			goods.setId(strings[0]);
//			b)商品名称要使用hasText()方法判断有没有值。（2分）
			boolean b = StringUtil.hasText(strings[1]);
			if (b) {
				
				goods.setName(strings[1]);
			}else {
				System.out.println("姓名是空值！！！！");
			}
			goods.setPrice(strings[2]);
			if (!b) {
				System.out.println("价格是空值！！！！");
			}
			goods.setBaifen(strings[3]);
			System.out.println(goods);
			redisTemplate.opsForList().leftPush("productList", goods);
		}
	}
	//测试从list取数据
	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll() {
		List<Goods> range = redisTemplate.opsForList().range("productList", 0, -1);

		System.out.println(range);

	}

	
	
}
