package cn.longtai.promote.rocketmq.spring.boot.starter.producer.simple;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@Slf4j
@SpringBootApplication
public class RocketmqSpringBootStarterProducerSimpleApplication implements CommandLineRunner {
    
    public static void main(String[] args) {
        SpringApplication.run(RocketmqSpringBootStarterProducerSimpleApplication.class, args);
    }
    
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Thread.sleep(10);
            SendResult sendResult = rocketMQTemplate.syncSend("order-topic", "Hello, World!" + i);
            log.info("Send result :: {}", JSON.toJSONString(sendResult));
        }
    }
}
