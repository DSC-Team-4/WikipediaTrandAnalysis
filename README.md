# WikipediaTrandAnalysis


## Kafka 실행 방법

- scripts 경로로 이동
- ./kafka-up.sh 실행
- docker exec -it <컨테이너id> bash (윈도우는 앞에 winpty 붙일 것)
- 아래 명령어 실행
    - /opt/bitnami/kafka/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1 --config retention.ms=60000 --topic wiki
- wiki 토픽 생성 확인
    - /opt/bitnami/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
- producer 실행
    - kafka 디렉토리 이동
    - ./gradlew build
    - 다시 scripts 디렉토리로 이동하여 ./producer-up.sh 실행
    - (현재 10초동안만 실행됨)

- consumer 테스트
    - kafka 컨테이너 실행(exec)
    - /opt/bitnami/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic wiki —group wiki_collectors --from-beginning
