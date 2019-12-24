package com.dario.project23people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient
//@EnableZuulProxy
public class Project23peopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project23peopleApplication.class, args);
	}

	/*@RequestMapping
	public String home(){
		return "hola";
	}
*/
}
