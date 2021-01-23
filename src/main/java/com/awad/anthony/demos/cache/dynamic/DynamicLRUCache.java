package com.awad.anthony.demos.cache.dynamic;

import org.springframework.context.annotation.Configuration;

import com.awad.anthony.demos.cache.Constants;
import com.awad.anthony.demos.cache.ICache;
import com.awad.anthony.demos.cache.LRUCache;

@Configuration
public class DynamicLRUCache implements ICache {
	public LRUCache lruCache;
	
	public DynamicLRUCache() {
		this.lruCache = new LRUCache(Constants.DYNAMIC_CACHE_SIZE);
	}

	@Override
	public LRUCache getCache() {
		return this.lruCache;
	}

	@Override
	public void setCache(LRUCache lruCache) {
		if(this.lruCache != null)
			return;
		this.lruCache = new LRUCache(Constants.DYNAMIC_CACHE_SIZE);
		
	}
	

}
