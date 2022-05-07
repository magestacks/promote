package cn.longtai.promote.spring.cloud.starter.stream.rocketmq.consume.simple;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

/**
 * My sink.
 *
 * @author chen.ma
 * @date 2022/5/7 19:08
 */
public interface MySink extends Sink {

    /**
     * Input channel name.
     */
    String INPUT2 = "input2";

    /**
     * @return input channel.
     */
    @Input(MySink.INPUT2)
    SubscribableChannel input2();
}
