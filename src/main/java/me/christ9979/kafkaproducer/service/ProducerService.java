package me.christ9979.kafkaproducer.service;

import me.christ9979.kafkaproducer.component.ProducerCreator;
import me.christ9979.kafkaproducer.constant.KafkaProperties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ProducerService {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Autowired
    private ProducerCreator producerCreator;

    public void runProducer() {

        Producer<Long, String> producer = producerCreator.createProducer();

        for (int index = 0; index < kafkaProperties.getMaxMessageCount(); ++index) {

            ProducerRecord<Long, String> record = new ProducerRecord<>(kafkaProperties.getTopic()
                    , "This is record " + index);

            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
                + " with offset " + metadata.offset());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
