package com.test.ref.cache.liteCache;

import com.test.ref.cache.flyWeight.GoodsFactory;

public class Goods {
	private String code;
	private int price;
	private String name;
	private String brand;
	private static GoodsFactory gf;
	public Goods(String code){
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
