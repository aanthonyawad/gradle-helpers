package com.awad.anthony.demos.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoProperties {
	
	@Value("${executor.threads}")
	private int executorThreads;

	public int getExecutorThreads() {
		return executorThreads;
	} 
}
