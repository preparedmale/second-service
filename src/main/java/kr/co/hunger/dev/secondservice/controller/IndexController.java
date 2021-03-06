package kr.co.hunger.dev.secondservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
@Slf4j
public class IndexController {
    Environment env;

    @Autowired
    public IndexController(Environment env) { this.env = env;}

    @GetMapping("/hello")
    public String hello() {
        return "second-service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("second-request") String header) {
        log.info(header);
        return "Hello World in Second Service.";
    }

    @GetMapping("/check")
    public String check() {
        return String.format("Hi, there. This is a message from First Service on PORT %s"
                , env.getProperty("local.server.port"));
    };
}
