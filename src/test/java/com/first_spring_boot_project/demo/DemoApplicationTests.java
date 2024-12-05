package com.first_spring_boot_project.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootTest
class DemoApplicationTests {

	static {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
    }
	@Test
	void contextLoads() {
	}

}
