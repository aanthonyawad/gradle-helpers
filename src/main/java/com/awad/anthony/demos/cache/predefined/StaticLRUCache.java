package com.awad.anthony.demos.cache.predefined;

import org.springframework.context.annotation.Configuration;

import com.awad.anthony.demos.cache.Constants;
import com.awad.anthony.demos.cache.ICache;
import com.awad.anthony.demos.cache.LRUCache;

@Configuration
public class StaticLRUCache implements ICache{
	public LRUCache lruCache;
	
	public StaticLRUCache() {
		this.lruCache = new LRUCache(Constants.STATIC_CACHE_SIZE);
	}

	@Override
	public LRUCache getCache() {
		return this.lruCache;
	}

	@Override
	public void setCache(LRUCache lruCache) {
		if(this.lruCache != null)
			return;
		this.lruCache = new LRUCache(Constants.STATIC_CACHE_SIZE);
		
	}

}
