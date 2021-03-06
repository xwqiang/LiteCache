package com.test.ref.cache.liteCache;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
class LiteCache<T> {
	private Map<String, CacheRef<T>> refs;// 用于Chche内容的存储
	private String key;
	private ReferenceQueue<T> queue;// 垃圾Reference的队列
	public LiteCache(){
		this.refs = new HashMap<String,CacheRef<T>>();
		this.queue = new ReferenceQueue<T>();
	}
	public int size(){
		return refs.size();
	}
	
	public void setKey(String key){
		this.key = key;
	}
	public void put(T t){
		cleanCache();
		CacheRef<T> cacheRef = new CacheRef<T>(t,queue,key);
		refs.put(cacheRef.getKey(), cacheRef);
	}
	public T get(String key){
		T result = null;
		if(refs.containsKey(key)){
			result = refs.get(key).get();
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	private void cleanCache(){
		CacheRef<T> obj = null;
		while ((obj = (CacheRef<T>) queue.poll()) != null) {
			refs.remove(obj.getKey());
		}
	}
	
	public void clearCache() {
		cleanCache();
		refs.clear();
		System.gc();
		System.runFinalization();
	}
}
