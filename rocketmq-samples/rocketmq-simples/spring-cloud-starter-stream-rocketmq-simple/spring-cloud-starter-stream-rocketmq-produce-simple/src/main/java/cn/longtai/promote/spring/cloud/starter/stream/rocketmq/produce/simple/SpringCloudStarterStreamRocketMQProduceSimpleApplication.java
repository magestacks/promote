package cn.longtai.promote.spring.cloud.starter.stream.rocketmq.produce.simple;

import cn.longtai.promote.rocketmq.core.sample.SendMessageDTO;
import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

import static cn.longtai.promote.rocketmq.core.sample.RocketMQConstants.MESSAGE_CENTER_SAVE_MESSAGE_TAG;
import static cn.longtai.promote.rocketmq.core.sample.RocketMQConstants.MESSAGE_CENTER_SEND_MESSAGE_TAG;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
@EnableBinding(Source.class)
public class SpringCloudStarterStreamRocketMQProduceSimpleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStarterStreamRocketMQProduceSimpleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int maxSendSize = 10;
        for (int i = 0; i < maxSendSize; i++) {
            sendMessage(MESSAGE_CENTER_SEND_MESSAGE_TAG);
            sendMessage(MESSAGE_CENTER_SAVE_MESSAGE_TAG);
        }
    }

    private final MessageChannel output;

    private void sendMessage(String tags) {
        String keys = UUID.randomUUID().toString();
        SendMessageDTO payload = SendMessageDTO.builder()
                .receiver("156011xxx91")
                .uid(keys)
                .build();
        Message<?> message = MessageBuilder
                .withPayload(JSON.toJSONString(payload))
                .setHeader(MessageConst.PROPERTY_KEYS, keys)
                .setHeader(MessageConst.PROPERTY_TAGS, tags)
                .build();
        long startTime = System.currentTimeMillis();
        boolean sendResult = false;
        try {
            sendResult = output.send(message, 2000L);
        } finally {
            log.info("Send status: {}, Keys: {}, Execute time: {} ms, Message: {}",
                    sendResult,
                    keys,
                    System.currentTimeMillis() - startTime,
                    JSON.toJSONString(payload));
        }
    }
}
