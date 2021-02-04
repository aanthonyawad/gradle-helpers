package com.awad.anthony.demos.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping(path = "/")
	public String hello() {
		return "hello NSY_205";
	}
	

	@GetMapping(path = "/{name}")
	public String name(@PathVariable(value = "name") String name) {
		return "hello "+ name;
	}
}
