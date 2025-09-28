package com.example.service.tasks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${message:Hello default}")
    private String message;

    @GetMapping("/message")
    public String getmessage() {
        return message;
    }
}
