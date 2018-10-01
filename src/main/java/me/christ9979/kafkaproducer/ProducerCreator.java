package me.christ9979.kafkaproducer;

import me.christ9979.kafkaproducer.constant.KafkaProperties;
import me.christ9979.kafkaproducer.custom.CustomPartitioner;
import me.christ9979.kafkaproducer.custom.CustomSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class ProducerCreator {

    @Autowired
    private KafkaProperties kafkaProperties;

    public Producer<Long, String> createProducer() {

        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBrokers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // For custom config
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, CustomSerializer.class.getName());
//        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class.getName());

        return new KafkaProducer<Long, String>(props);
    }
}
