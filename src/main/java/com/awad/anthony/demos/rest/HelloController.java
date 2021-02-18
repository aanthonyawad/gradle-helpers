package com.awad.anthony.demos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.awad.anthony.demos.threadpool.BaseTask;
import com.awad.anthony.demos.threadpool.MyExcecutorService;

@RestController
public class HelloController {
	
	@Autowired
	MyExcecutorService myExcecutorService;
	
	@GetMapping(path = "/")
	public String hello() {
		//return a future
		
		myExcecutorService.addExecutor(myExcecutorService.getExecutor().submit(()->{
			return new BaseTask("1"); 
		}));
		myExcecutorService.addExecutor(myExcecutorService.getExecutor().submit(()->{
			return new BaseTask("anthony"); 
		}));
		myExcecutorService.addExecutor(myExcecutorService.getExecutor().submit(()->{
			return new BaseTask("3"); 
		}));
		myExcecutorService.addExecutor(myExcecutorService.getExecutor().submit(()->{
			return new BaseTask("2");
		}));
		
		
		return "hello NSY_205";
	}
	

	@GetMapping(path = "hello/{name}")
	public String name(@PathVariable(value = "name") String name) {
		return "hello "+ name;
	}
}
