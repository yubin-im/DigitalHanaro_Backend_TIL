package com.study.pr04counterapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private Counter counter;

    @Autowired
    public ApiController(Counter counter) {
        this.counter = counter;
    }

    @PostMapping("/plus")
    public String plus() {
        counter.plus();
        return "{\"count\": " + counter.getCount() + "}";
    }

    @PostMapping("/minus")
    public String minus() {
        counter.minus();
        return "{\"count\": " + counter.getCount() + "}";
    }

    @PostMapping("/count")
    public String getCount() {
        return "{\"count\": " + counter.getCount() + "}";
    }
}
