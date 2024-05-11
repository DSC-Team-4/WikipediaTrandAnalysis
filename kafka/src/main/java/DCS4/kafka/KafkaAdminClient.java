package DCS4.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.config.ConfigResource;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

@Slf4j
public class KafkaAdminClient {

    public static void main(String[] args) {

        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        try (AdminClient admin = AdminClient.create(configs)) {
            // 토픽 삭제
            DeleteTopicsResult result = admin.deleteTopics(Collections.singletonList("wiki"));
            result.all().get();
            System.out.println("Topic deleted successfully");

            /* 조회1 */
//        log.info("== Get broker information");
//        for (Node node : admin.describeCluster().nodes().get()) {
//            log.info("node : {}", node);
//
//            ConfigResource cr = new ConfigResource(ConfigResource.Type.BROKER, node.idString());
//
//            DescribeConfigsResult describeConfigs = admin.describeConfigs(Collections.singleton(cr));
//            describeConfigs.all().get().forEach((broker, config) -> {
//                config.entries().forEach(configEntry -> log.info(configEntry.name() + "= " + configEntry.value()));
//            });
//        }

            /* 조회2 */
//        log.info("== Get default num.partitions");
//        for (Node node : admin.describeCluster().nodes().get()) {
//            ConfigResource cr = new ConfigResource(ConfigResource.Type.BROKER, node.idString());
//            DescribeConfigsResult describeConfigs = admin.describeConfigs(Collections.singleton(cr));
//            Config config = describeConfigs.all().get().get(cr);
//            Optional<ConfigEntry> optionalConfigEntry = config.entries().stream().filter(v -> v.name().equals("num.partitions")).findFirst();
//            ConfigEntry numPartitionConfig = optionalConfigEntry.orElseThrow(Exception::new);
//            log.info("{}", numPartitionConfig.value());
//        }

            /* 조회3 */
//        log.info("== Topic list");
//        for (TopicListing topicListing : admin.listTopics().listings().get()) {
//            log.info("{}", topicListing.toString());
//        }

            /* 조회4 */
//        log.info("== test topic information");
//        Map<String, TopicDescription> topicInformation = admin.describeTopics(Collections.singletonList("test")).all().get();
//        log.info("{}", topicInformation);

            /* 조회5 */
//        log.info("== Consumer group list");
//        ListConsumerGroupsResult listConsumerGroups = admin.listConsumerGroups();
//        listConsumerGroups.all().get().forEach(v -> {
//            log.info("{}", v);
//        });

            /* close */
            // 어드민 API 는 사용하고 나면 명시적으로 종료 메서드를 호출하여 리소스가 낭비되지 않도록 한다.
            // AdminClient 클래스의 close() 메서드를 사용하면 명시적으로 종료할 수 있다.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}