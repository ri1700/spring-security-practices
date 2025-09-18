package config.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import config.WebConfig;
import jakarta.servlet.Filter;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {SecurityConfigEx01.class, WebConfig.class})
@WebAppConfiguration
public class SecurityConfigEx01Test {

	private static MockMvc mvc;
	
	@BeforeAll
	public static void setup(WebApplicationContext webApplicationContext) {
		
		Filter filter = (Filter)webApplicationContext.getBean("springSecurigyConfig");
		
		mvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext)
				.addFilter(new DelegatingFilterProxy(filter), "/*")
				.build();
	}
	
	
}