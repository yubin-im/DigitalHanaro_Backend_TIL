package com.study.ex21logger;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LogTest extends Ex21LoggerApplicationTests {
    static int count = 0;

    @Test
    public void TestLogger(){
        Class myClass = LogTest.class;
        //Class 객체 - 클래스에 대한 정보(멤버함수,멤버변수, 생성자)을 담고 있음.

        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.trace("trace 로깅 {}", count++);
        logger.debug("debug 로깅 {}", count++);
        logger.info("info 로깅 {}", count++);
        logger.warn("warn 로깅 {}", count++);
        logger.error("error 로깅 {}", count++);
    }

    @Test
    public void testSlf4j(){
        log.trace("Slf4j trace 로깅 {}", count++);
        log.debug("Slf4j debug 로깅 {}", count++);
        log.info("Slf4j info 로깅 {}", count++);
        log.warn("Slf4j warn 로깅 {}", count++);
        log.error("Slf4j error 로깅 {}", count++);
    }
}