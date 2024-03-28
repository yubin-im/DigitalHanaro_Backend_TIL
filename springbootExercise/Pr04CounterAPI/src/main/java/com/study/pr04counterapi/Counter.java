package com.study.pr04counterapi;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void plus() {
        this.count++;
    }

    public void minus() {
        this.count--;
    }
}