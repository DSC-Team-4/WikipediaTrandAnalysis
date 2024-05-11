package DCS4.kafka.consumer;

import DCS4.kafka.dto.TestDTO;
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
    private List<TestDTO> payloads = new ArrayList<>();
    private TestDTO payload;

    @KafkaListener(topics = "baeldung", containerFactory = "filterListenerContainerFactory")
    public void receive(ConsumerRecord<String, TestDTO> consumerRecord) {
        payload = consumerRecord.value();
        log.info("received payload = {}", payload.toString());
        payloads.add(payload);
        latch.countDown();
    }

    public List<TestDTO> getPayloads() {
        return payloads;
    }

    public void resetLatch() {
        latch = new CountDownLatch(1);
    }
}
