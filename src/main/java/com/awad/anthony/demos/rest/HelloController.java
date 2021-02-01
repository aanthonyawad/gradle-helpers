package com.awad.anthony.demos.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping(path = "/")
	public String hello() {
		return "hello Dr Pascale & JEAN PAUL BFFFFFFFFFFFF AND FFFFFFFFFFFFF";
	}
}
