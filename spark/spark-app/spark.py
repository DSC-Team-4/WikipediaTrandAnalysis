from pyspark.sql import SparkSession

# Spark 세션 생성
spark = SparkSession.builder \
    .appName("KafkaSparkIntegration") \
    .master("spark://spark-master:7077") \
    .getOrCreate()

# # 예제 DataFrame 생성 및 액션 실행
# df = spark.createDataFrame([(1, 'foo'), (2, 'bar')], ['id', 'value'])
# df.show()

# # 스트리밍 작업 예제
# df = spark \
#   .readStream \
#   .format("kafka") \
#   .option("kafka.bootstrap.servers", "kafka:9092") \
#   .option("subscribe", "test-topic") \
#   .load()

# # Kafka 메시지 파일에 저장
# query = df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)") \
#   .writeStream \
#   .outputMode("append") \
#   .format("csv") \
#   .option("path", "/opt/spark-app/output") \
#   .option("checkpointLocation", "/opt/spark-app/checkpoint") \
#   .start()

# query.awaitTermination()

# 간단한 DataFrame 생성 및 출력
data = [("Alice", 1), ("Bob", 2), ("Cathy", 3)]
columns = ["Name", "Value"]
df = spark.createDataFrame(data, columns)
df.show()

# 결과를 파일에 저장
df.write.csv('/opt/spark-app/output.csv')

# Spark 애플리케이션 종료
spark.stop()