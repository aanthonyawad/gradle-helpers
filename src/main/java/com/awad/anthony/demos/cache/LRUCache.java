package com.awad.anthony.demos.cache;

import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import com.awad.anthony.demos.cache.callbacks.OnTimeOutListener;
import com.awad.anthony.demos.cache.exceptions.CacheTimeOutException;


public class LRUCache implements OnTimeOutListener {
	int capacity;
	HashMap<String, Node> map = new HashMap<String, Node>();
	Node head = null;
	Node end = null;
	private boolean added;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public ICacheable get(String key) throws CacheTimeOutException {
		long now = System.currentTimeMillis();
		while (this.caclculateWaitTime(now) && !added) {
			if (map.containsKey(key)) {
				Node n = map.get(key);
				delete(n);
				setHead(n);
				return n.value;
			}

		}
		
		if (!added) {
			this.onTimeOut(key);
		}
		return null;
	}

	/* This method will delete node */
	public void delete(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			end = node.prev;
		}

	}

	/* This method will make passed node as head */
	public void setHead(Node node) {
		node.next = head;
		node.prev = null;

		if (head != null)
			head.prev = node;

		head = node;

		if (end == null)
			end = head;
	}

	public void set(String key, ICacheable value) {
		if (map.containsKey(key)) {
			// update the old value
			Node old = map.get(key);
			old.value = value;
			delete(old);
			setHead(old);

		} else {
			Node newNode = new Node(key, value);
			if (map.size() >= capacity) {

				map.remove(end.key);
				// remove last node
				delete(end);
				setHead(newNode);

			} else {
				setHead(newNode);
			}

			map.put(key, newNode);
		}

	}

	private boolean caclculateWaitTime(long waitStart) {
		long now = System.currentTimeMillis();
		double nowDouble = (double)now;
		double waitStartDouble = (double)waitStart;
		if( (waitStartDouble * Constants.CACHE_TIMEOUT_MILLISECONDS)  > nowDouble )
			return false;
		
		return true;
	}

	@Override
	public void onTimeOut(String key) throws CacheTimeOutException {
		throw new CacheTimeOutException("Could not add get cache item with key " + key );
	}
}
