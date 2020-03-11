package com.example.simpleboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SimpleBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBootApplication.class, args);
	}

	@Value("${spring.application.name}")
	String applicationName;

	@Value("${cf.instance.index:default_from_class}")
	String cfInstanceIndex;


	@Value("${vcap.application.instance.id:default}")
	String vcapApplicationInstanceId;

	@GetMapping("/")
	public String home() throws Exception{

		StringBuilder sb = new StringBuilder();
		sb.append("app: ").append(applicationName).append("<br>")
				.append("cf.instance.index: ").append(cfInstanceIndex).append("<br>")
		        .append("vcap.application.instance.id: ").append(vcapApplicationInstanceId).append("<br>");
		return sb.toString();
	}


}


