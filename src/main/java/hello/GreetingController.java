package hello;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	/*
	 * @Autowired RestTemplate restTemplate;
	 */

	@RequestMapping("/get")
	public Greeting greeting(RestTemplate restTemplate) {
		Greeting data = restTemplate.getForObject("http://www.opptty.com:8084/greeting", Greeting.class);
		// Greeting data = restTemplate.getForObject("http://10.129.0.12:8080/greeting",
		// Greeting.class);
		data.setContent("message got:" + data.getContent());
		System.out.print("print info:" + data.getContent());
		return data;
	}

}