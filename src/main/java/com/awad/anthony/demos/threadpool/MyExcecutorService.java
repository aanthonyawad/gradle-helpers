package com.awad.anthony.demos.threadpool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awad.anthony.demos.utils.DemoProperties;

@Service
public class MyExcecutorService {
	@Autowired
	private DemoProperties demoProperties;

	private ExecutorService executor;
	private Set<Future<BaseTask>> setExecutions;
	private Object syncho = new Object();

	@PostConstruct
	void construct() {
		this.executor = Executors.newFixedThreadPool(demoProperties.getExecutorThreads());
		this.setExecutions = new HashSet<Future<BaseTask>>();
		this.startListener();
	}

	public ExecutorService getExecutor() {

		return executor;
	}

	private void startListener() {
		// run the thread that will listen to finished events
		this.executor.execute(() -> {
			while (true) {
				synchronized (syncho) {
					if (this.setExecutions.size() > 0) {
						// get finished events
						Iterator<Future<BaseTask>> it = this.setExecutions.iterator();
						while (it.hasNext()) {
							Future<BaseTask> item = it.next();
							// remove from list
							if (item.isCancelled()) {
								it.remove();
								continue;
							}
							if (item.isDone()) {
//								get result and work
//								TODO factory for all incoming IDs 
								try {
									BaseTask result = item.get();
									System.out.println(result.getTaskId());
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (ExecutionException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								it.remove();
							}
						}
					}
				}
			}
		});
	}

	public void addExecutor(Future<BaseTask> item) {
		synchronized (syncho) {
			this.setExecutions.add(item);
		}
	}

}