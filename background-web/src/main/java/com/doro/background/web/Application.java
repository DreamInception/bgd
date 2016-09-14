package com.doro.background.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.doro.background.web.config.Config;

@EnableAutoConfiguration
@ComponentScan
public class Application extends SpringBootServletInitializer {

	public void run(Class<?> assemblyClass, String[] args) {
		new Application().configure(new SpringApplicationBuilder(Application.class, assemblyClass))
				.profiles("prod", "localResource").run(args);
	}

	public static void main(String[] args) {
		new Application().run(Config.class, args);
	}

}
