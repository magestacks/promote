package cn.longtai.promote.rocketmq.spring.boot.starter.producer.simple.mode;

import cn.longtai.promote.rocketmq.core.sample.SendMessageDTO;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import static org.apache.rocketmq.common.message.MessageConst.PROPERTY_KEYS;

/**
 * Sync send message.
 *
 * @author chen.ma
 * @date 2022/5/6 10:17
 */
@Slf4j
@Component
@AllArgsConstructor
public class SyncSendMessage extends AbstractSendMessage {

    protected final RocketMQTemplate rocketMQTemplate;

    @Override
    protected void sendMessage(int maxSendSize, String buildTopicTag) {
        for (int i = 0; i < maxSendSize; i++) {
            SendMessageDTO payload = SendMessageDTO.builder()
                    .receiver("156011xxx91")
                    .uid(atomicInteger.incrementAndGet() + "")
                    .build();
            String keys = UUID.randomUUID().toString();
            Message<?> message = MessageBuilder
                    .withPayload(JSON.toJSONString(payload))
                    .setHeader(PROPERTY_KEYS, keys)
                    .build();
            SendResult sendResult = null;
            long startTime = System.currentTimeMillis();
            try {
                sendResult = rocketMQTemplate.syncSend(buildTopicTag, message);
            } finally {
                log.info("Send status: {}, Keys: {}, Execute time: {}, Send result: {}",
                        Optional.ofNullable(sendResult).map(SendResult::getSendStatus).map(SendStatus::toString).orElse("Fail"),
                        keys,
                        System.currentTimeMillis() - startTime,
                        JSON.toJSONString(sendResult));
            }
        }
    }
}
