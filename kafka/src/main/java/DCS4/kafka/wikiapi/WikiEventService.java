package DCS4.kafka.wikiapi;

import jakarta.annotation.PostConstruct;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class WikiEventService {

    private final WebClient webClient = WebClient.create("https://stream.wikimedia.org");
    private final KafkaTemplate<String, String> kafkaTemplate;

    public WikiEventService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostConstruct
    public void subscribeWikiEvents() {
        Flux<ServerSentEvent<String>> eventStream = webClient.get()
                .uri("/v2/stream/recentchange")
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<ServerSentEvent<String>>() {});

        eventStream
                .take(Duration.ofSeconds(10))
                .subscribe(
                    content -> kafkaTemplate.send("wiki", content.data()),
                    error -> System.out.println("error = " + error),
                    () -> System.out.println("stream completed")
                );
    }
}
