/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.longtai.promote.rocketmq.spring.boot.starter.producer.simple.mode;

import cn.longtai.promote.rocketmq.core.sample.RocketMQConstants;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

import static cn.longtai.promote.rocketmq.core.sample.RocketMQConstants.MESSAGE_CENTER_SEND_MESSAGE_TAG;

/**
 * Abstract send message.
 *
 * @author chen.ma
 * @date 2022/5/6 19:11
 */
@Slf4j
public abstract class AbstractSendMessage {

    protected final AtomicInteger atomicInteger = new AtomicInteger();

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
