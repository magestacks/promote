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

package cn.longtai.promote.rocketmq.spring.boot.starter.producer.simple;

import cn.longtai.promote.rocketmq.core.sample.RocketMQConstants;
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
        int maxSize = 10;
        for (int i = 0; i < maxSize; i++) {
            Thread.sleep(10);
            SendResult sendResult = rocketMQTemplate.syncSend(RocketMQConstants.ORDER_TOPIC, "Hello, World!" + i);
            log.info("Send result :: {}", JSON.toJSONString(sendResult));
        }
    }
}
