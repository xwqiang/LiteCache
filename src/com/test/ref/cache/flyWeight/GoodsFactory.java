package com.test.ref.cache.flyWeight;

import java.util.Hashtable;

import com.test.ref.cache.liteCache.Goods;

public class GoodsFactory {
	private Hashtable<String,Goods> flyweights = new Hashtable<String,Goods>();
	public Goods getGoods(String code){
		Goods goods = flyweights.get(code);
		if(goods == null){
			Goods g = new Goods(code);
			flyweights.put(code, g);
			return g;
		}
		return goods;
	}
	public int getSize(){
		return flyweights.size();
	}
}
