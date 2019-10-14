/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: Goods.java 
 * @Prject: zhangkai-senior2-week2
 * @Package: com.zhangkai.domain 
 * @Description: TODO
 * @author: 张凯   
 * @date: 2019年10月14日 上午8:56:23 
 * @version: V1.0   
 */
package com.zhangkai.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/** 
 * @ClassName: Goods 
 * @Description: TODO
 * @author: 张凯
 * @date: 2019年10月14日 上午8:56:23  
 */
public class Goods implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	
//	1.编写一个Goods商品类，
//	共有ID，
	private String id;
//	商品名称，
	private String name;
//	商品价格，
	private String price;
//	已售百分比，
	private String baifen;
//	共4个属性。其中价格需要为BigDecimal类型。
	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", baifen=" + baifen + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBaifen() {
		return baifen;
	}

	public void setBaifen(String baifen) {
		this.baifen = baifen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
