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

package cn.longtai.promote.rocketmq.spring.boot.starter.consume.simple;

import cn.longtai.promote.rocketmq.core.sample.RocketMQConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Slf4j
@SpringBootApplication
public class RocketmqSpringBootStarterConsumeSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqSpringBootStarterConsumeSimpleApplication.class, args);
    }

    @Component
    @RocketMQMessageListener(
            topic = RocketMQConstants.MESSAGE_CENTER_TOPIC,
            selectorType = SelectorType.TAG,
            selectorExpression = RocketMQConstants.MESSAGE_CENTER_SEND_MESSAGE_TAG,
            consumerGroup = RocketMQConstants.MESSAGE_CENTER_CUSTOM_GROUP
    )
    static class CustomRocketMQListener implements RocketMQListener {

        @Override
        public void onMessage(Object message) {
            log.info("Message: {}", message);
        }
    }
}
