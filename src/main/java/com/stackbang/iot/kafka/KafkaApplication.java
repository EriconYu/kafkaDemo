package com.stackbang.iot.kafka;

import com.stackbang.iot.kafka.configure.Product;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j

public class KafkaApplication {

    @Autowired
    private Product product;

//    @PostConstruct
    @SneakyThrows
    public void init() {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0;i <10000 ; i++) {
                            product.send("afs" + i);
                            try {
                                Thread.sleep(1000);
                                log.info("{}" , System.currentTimeMillis());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();

    }


    public static void main(String[] args) {

        SpringApplication.run(KafkaApplication.class, args);
    }

}
