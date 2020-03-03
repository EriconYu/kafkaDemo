package com.stackbang.iot.kafka;

import com.stackbang.iot.kafka.configure.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class KafkaApplicationTests {

    @Autowired
    private Product product;

    @Test
    void sendMsg() {
        for (int i = 0; ; i++) {
            product.send("afs" + i);
            try {
                Thread.sleep(1);
                log.info("{}", System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void contextLoads() {
    }

}
