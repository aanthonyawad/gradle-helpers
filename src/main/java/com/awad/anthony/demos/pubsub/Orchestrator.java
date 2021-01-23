package com.awad.anthony.demos.pubsub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
@Configuration
public class Orchestrator implements Runnable{
	private List<Event> queue;
	private Map<JobType,Subscriber> subscribers ;
	
	private Thread thread;
	private Object synchronizer;
	public  boolean publish(Publisher publisher) {
		synchronized(this.synchronizer) {
			this.queue.add(publisher.getEvent());
			return true;
		}
		
	}

	public  boolean addSubscriber(Subscriber subscriber) {
		synchronized(synchronizer) {
			this.subscribers.put(subscriber.getJobType(), subscriber);
			return true;
		}
		
	}
	public Orchestrator() {
		this.queue = new ArrayList<Event>();
		this.subscribers = new HashMap<JobType, Subscriber>();
		this.synchronizer = new Object();
	}
	
	public void initialize() {
		try {
			 this.thread = new Thread(this);
			thread.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true) {
			synchronized(synchronizer){
				Iterator<Event> iterator = queue.iterator();
				while(iterator.hasNext()) {
				Subscriber sub;
				Event event = iterator.next();
				switch (event.getJobType()) {
				case JOB_ONE:
					sub = this.subscribers.get(JobType.JOB_ONE);
					if(sub == null)
						break;
						//TODO no sub found exception
					if(sub.requiresThread)
						sub.doWorkInThread(event);
					else
						sub.doWork(event);
					iterator.remove();
					break;
				case JOB_TWO:
					sub = this.subscribers.get(JobType.JOB_TWO);
					if(sub == null)
						break;
						//TODO no sub found exception
					if(sub.requiresThread)
						sub.doWorkInThread(event);
					else
						sub.doWork(event);
					iterator.remove();
					break;
				case JOB_THREE:
					sub = this.subscribers.get(JobType.JOB_THREE);
					if(sub == null)
						break;
						//TODO no sub found exception
					if(sub.requiresThread)
						sub.doWorkInThread(event);
					else
						sub.doWork(event);
					iterator.remove();
					break;
				default:
					break;
				}
			}
		}
		
	}
	}
}
