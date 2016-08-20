package com.chenxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.chenxun.solr" })
public class ChenxunSolrApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ChenxunSolrApplication.class, args);
	}
}
