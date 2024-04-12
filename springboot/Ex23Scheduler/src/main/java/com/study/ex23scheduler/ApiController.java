package com.study.ex23scheduler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/api/batch-job")
    public String batchJson() {
        // 실제 작업
        return "batch-job response";
    }
}
