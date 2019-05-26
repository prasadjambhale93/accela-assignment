package prasad.accela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import prasad.accela.controller.PersonController;
import prasad.accela.model.Person;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

}
