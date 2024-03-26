package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MessageProducer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "172.17.0.2:9092");
        properties.setProperty("linger.ms", "1");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create KafkaProducer
        Producer<String, String> producer = new KafkaProducer<>(properties);

        // Create Record
        for (int i=1; i<=5; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("message", "number", Integer.toString(i));
            producer.send(record);
        }

        producer.close();

    }
}
