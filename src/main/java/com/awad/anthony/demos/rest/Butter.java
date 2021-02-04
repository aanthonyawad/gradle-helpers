package com.awad.anthony.demos.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Butter {

    @GetMapping(value = "/butter")
    @ResponseBody
    public String butter() {
    	return "<!DOCTYPE html>\r\n"
    			+ "<html>\r\n"
    			+ "<head>\r\n"
    			+ "	<meta charset=\"ISO-8859-1\">\r\n"
    			+ "	<title>Butter</title>\r\n"
    			+ "	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n"
    			+ "</head>\r\n"
    			+ "<body>\r\n"
    			+ "\r\n"
    			+ "<button class=\"btn btn-primary\" onclick=\"alert('hi')\" >click me</button>\r\n"
    			+ "\r\n"
    			+ "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js\" integrity=\"sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf\" crossorigin=\"anonymous\"></script>\r\n"
    			+ "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
    			+ "</body>\r\n"
    			+ "</html>";
    }
}
