package com.zmm.sell;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
//        logger.debug("这个是测试logger -- debug");
//        logger.info("这个是测试logger -- info");
//        logger.error("这个是测试logger -- error");
//        logger.warn("这个是测试logger -- warn");

        log.debug("这个是测试logger -- debug");
        log.info("这个是测试logger -- info");
        log.error("这个是测试logger -- error");
        log.warn("这个是测试logger -- warn");

        String name = "Giousa";
        String password = "12121212";

        log.info("name:{},passrod:{}",name,password);

    }
}
