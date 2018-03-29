package icsse2018.controller;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import icsse2018.Application;


	public class ServletInitializer extends SpringBootServletInitializer {
		  @Override
		  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		  return application.sources(Application.class);
		  }
		}

