package me.christ9979.kafkaproducer.component;

import me.christ9979.kafkaproducer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitRunner implements CommandLineRunner {

    @Autowired
    private ProducerService producerService;

    @Override
    public void run(String... args) throws Exception {

        producerService.runProducer();
    }
}
