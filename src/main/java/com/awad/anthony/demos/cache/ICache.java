package com.awad.anthony.demos.cache;

public interface ICache {
	LRUCache getCache();
	void setCache(LRUCache lruCache);
}
