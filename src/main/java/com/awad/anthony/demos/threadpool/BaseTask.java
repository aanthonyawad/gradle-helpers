package com.awad.anthony.demos.threadpool;

public class BaseTask {
	protected String taskId;

	public BaseTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseTask(String taskId) {
		super();
		this.taskId = taskId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

}
