package com.awad.anthony.demos.pubsub;


public abstract class Subscriber{
	protected Thread thread;
	private final JobType jobType;
	protected final boolean requiresThread;
	
	public Subscriber(JobType jobType,boolean requiresThread) {
		this.jobType = jobType;
		this.requiresThread = requiresThread;
		
	}
	
	public JobType getJobType() {
		return jobType;
	}
	
	public boolean isRequiresThread() {
		return requiresThread;
	}
	
	public abstract boolean doWork(Event e);
	public abstract boolean doWorkInThread(Event e);

}
