package admin.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AdminConfig implements WebMvcConfigurer{

		

		    @Override
		    public void addCorsMappings(CorsRegistry registry) {
		        registry.addMapping("/**")  // Allow CORS for all endpoints
		                .allowedOrigins("http://localhost:4200")  // Allow your frontend to access the backend
		                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allowed HTTP methods
		                .allowedHeaders("*");  // Allow all headers
		    }



	}


