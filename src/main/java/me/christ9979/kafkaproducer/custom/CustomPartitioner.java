package me.christ9979.kafkaproducer.custom;

import me.christ9979.kafkaproducer.constant.KafkaProperties;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomPartitioner implements Partitioner {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        Integer keyInt = Integer.parseInt(key.toString());
        return keyInt % kafkaProperties.getPartitionCount();
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
