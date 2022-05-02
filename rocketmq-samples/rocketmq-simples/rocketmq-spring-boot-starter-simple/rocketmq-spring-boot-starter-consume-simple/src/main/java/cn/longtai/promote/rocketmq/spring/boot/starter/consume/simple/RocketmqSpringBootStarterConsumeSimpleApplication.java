package cn.longtai.promote.rocketmq.spring.boot.starter.consume.simple;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Slf4j
@SpringBootApplication
public class RocketmqSpringBootStarterConsumeSimpleApplication implements CommandLineRunner {
    
    public static void main(String[] args) {
        SpringApplication.run(RocketmqSpringBootStarterConsumeSimpleApplication.class, args);
    }
    
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    
    @Override
    public void run(String... args) throws Exception {
        while (true) {
            List<String> messages = rocketMQTemplate.receive(String.class);
            log.info("receive from rocketMQTemplate, size: {}, messages: {}", messages.size(), messages);
        }
    }
}
