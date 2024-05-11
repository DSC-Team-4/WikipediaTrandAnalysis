package DCS4.kafka;

import DCS4.kafka.wikiapi.WikiEventService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);
//		WikiEventService service = context.getBean(WikiEventService.class);
//		service.subscribeWikiEvents();
	}
}