# WikipediaTrandAnalysis


## Zookeeper/Kafka 실행 방법

- scripts 경로로 이동
- ./kafka-up.sh 실행
  > 안에 정의된 docker-compose 파일로 한번에 실행됩니다.
- docker exec -it <컨테이너id> bash (윈도우는 앞에 winpty 붙일 것)
- 아래 명령어 실행
    - /opt/bitnami/kafka/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1 --config retention.ms=60000 --topic wiki
    > --create : 새로운 토픽을 생성할 때 사용
    > 
    > --bootstrap-server localhost:9092 : 카프카 클러스터의 부트스트랩 서버 지정
    > 
    > --partitions 3 : 생성할 토픽의 파티션 수
    > 
    > --replication-factor 1 : 복제 계수, 1인 경우 복제본이 없음
    > 
    > --config retention.ms=60000 : 메세지 보존 기간 설정(60초)
    > 
    > --topic wiki : 생성할 토픽 이름 지정
- wiki 토픽 생성 확인
    - /opt/bitnami/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list

<br>

## Producer 실행 방법

- producer 실행
    - scripts 디렉토리로 이동하여 ./producer-up.sh 실행
    - 테스트 끝났으면 ./producer-down.sh 실행
 
    > 웬만하면 테스트 안할때는 끄기, docker ps 로 확인

- consumer 테스트
    - kafka 컨테이너 실행(exec)
    - /opt/bitnami/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic wiki --group wiki_collectors --from-beginning
