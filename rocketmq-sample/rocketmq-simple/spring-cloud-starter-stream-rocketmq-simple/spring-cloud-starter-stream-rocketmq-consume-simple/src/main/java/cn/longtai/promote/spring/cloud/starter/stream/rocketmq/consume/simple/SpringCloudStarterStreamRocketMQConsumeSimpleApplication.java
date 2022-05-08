package cn.longtai.promote.spring.cloud.starter.stream.rocketmq.consume.simple;

import cn.longtai.promote.rocketmq.core.sample.SendMessageDTO;
import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
@EnableBinding(MySink.class)
public class SpringCloudStarterStreamRocketMQConsumeSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStarterStreamRocketMQConsumeSimpleApplication.class, args);
    }

    @StreamListener(MySink.INPUT)
    public void consumeMessage(@Payload SendMessageDTO message, @Headers Map headers) {
        long startTime = System.currentTimeMillis();
        try {
            // ignore
        } finally {
            log.info("Keys: {}, Msg id: {}, Execute time: {} ms, Message: {}", headers.get("rocketmq_KEYS"), headers.get("rocketmq_MESSAGE_ID"), System.currentTimeMillis() - startTime, JSON.toJSONString(message));
        }
        log.info("Input current thread name: {}", Thread.currentThread().getName());
    }

    @StreamListener(MySink.INPUT2)
    public void consumeSaveMessage(@Payload SendMessageDTO message, @Headers Map headers) {
        long startTime = System.currentTimeMillis();
        try {
            // ignore
        } finally {
            log.info("Keys: {}, Msg id: {}, Execute time: {} ms, Message: {}", headers.get("rocketmq_KEYS"), headers.get("rocketmq_MESSAGE_ID"), System.currentTimeMillis() - startTime, JSON.toJSONString(message));
        }
        log.info("Input2 current thread name: {}", Thread.currentThread().getName());
    }
}
