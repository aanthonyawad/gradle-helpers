package com.awad.anthony.demos.pubsub;

public class SubscriberTest extends Subscriber {

	public SubscriberTest(JobType jobType, boolean requiresThread) {
		super(jobType, requiresThread);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doWork(Event e) {
		IJob job = e.getJob();
		System.out.println(job);
		return false;
	}

	@Override
	public boolean doWorkInThread(Event e) {
		this.thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				SubscriberTest.this.doWork(e);
				
			}
		});
		thread.start();
		return false;
	}

}
