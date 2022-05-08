package cn.longtai.promote.rocketmq.spring.boot.starter.producer.simple.mode;

import cn.longtai.promote.rocketmq.core.sample.RocketMQConstants;
import lombok.extern.slf4j.Slf4j;

import static cn.longtai.promote.rocketmq.core.sample.RocketMQConstants.MESSAGE_CENTER_SEND_MESSAGE_TAG;

/**
 * Abstract send rocketMQ message.
 *
 * @author chen.ma
 * @date 2022/5/6 10:11
 */
@Slf4j
public abstract class AbstractSendRocketMQMessage {

    /**
     * Send message.
     *
     * @param maxSendSize
     * @param buildTopicTag
     */
    protected abstract void sendMessage(int maxSendSize, String buildTopicTag);

    /**
     * Execute.
     *
     * @param maxSendSize
     */
    public void execute(int maxSendSize) {
        long startTime = System.currentTimeMillis();
        String buildTopicTag = RocketMQConstants.MESSAGE_CENTER_TOPIC + ":" + MESSAGE_CENTER_SEND_MESSAGE_TAG;
        sendMessage(maxSendSize, buildTopicTag);
        log.info("The execution time: {}", System.currentTimeMillis() - startTime);
    }
}
