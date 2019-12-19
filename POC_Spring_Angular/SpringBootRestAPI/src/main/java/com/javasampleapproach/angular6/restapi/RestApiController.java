package com.javasampleapproach.angular6.restapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RestApiController {

	@RequestMapping("/api/hi")
	public Map<String, String> hi() {

		Map<String, String> result = new HashMap<String, String>();
		String message = "Hello world! Java Sample";

		result.put("message", message);
		return result;

	}
}