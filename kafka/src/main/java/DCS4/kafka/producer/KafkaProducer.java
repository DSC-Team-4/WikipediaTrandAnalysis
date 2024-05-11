package DCS4.kafka.producer;

import DCS4.kafka.dto.TestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, TestDTO> kafkaTemplate;

    public void send(String topic, TestDTO payload) {
        log.info("sending payload={} to topic={}", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}
