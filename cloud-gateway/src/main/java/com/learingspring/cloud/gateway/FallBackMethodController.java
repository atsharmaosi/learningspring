package com.learingspring.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class FallBackMethodController {
	@HystrixCommand
	@GetMapping("userServiceFallBack")
	public String userServiceFallBackMethod()
	{
		return "User Service is taking longer than Expected."
				+ "Please try again later";
	}
	@HystrixCommand
	@GetMapping("departmentServiceFallBack")
	public String departmentServiceFallBackMethod()
	{
		return "Department Service is taking longer than Expected."
				+ "Please try again later";
	}


}
