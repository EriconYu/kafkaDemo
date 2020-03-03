package com.stackbang.iot.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> getHello(@PathVariable String id) {
        log.info("id is {}", id);
        return ResponseEntity.ok(true);
    }
}
