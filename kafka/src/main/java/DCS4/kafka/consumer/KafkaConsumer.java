package DCS4.kafka.consumer;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
@Data
@Slf4j
public class KafkaConsumer {

    private CountDownLatch latch = new CountDownLatch(10);
    private List<String> payloads = new ArrayList<>();
    private String payload;

    @KafkaListener(topics = "wiki", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        payload = consumerRecord.value();
        if (payload != null) {
            log.info("received payload = {}", payload.toString());
            payloads.add(payload);
        }
        latch.countDown();
    }

    public List<String> getPayloads() {
        return payloads;
    }

    public void resetLatch() {
        latch = new CountDownLatch(1);
    }
}
