package me.christ9979.kafkaproducer.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("kafka.producer")
public class KafkaProperties {

    private String brokers;
    private int partitionCount;
    private int maxMessageCount;
    private String topic;

    public String getBrokers() {
        return brokers;
    }

    public void setBrokers(String brokers) {
        this.brokers = brokers;
    }

    public int getPartitionCount() {
        return partitionCount;
    }

    public void setPartitionCount(int partitionCount) {
        this.partitionCount = partitionCount;
    }

    public int getMaxMessageCount() {
        return maxMessageCount;
    }

    public void setMaxMessageCount(int maxMessageCount) {
        this.maxMessageCount = maxMessageCount;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

