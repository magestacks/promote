package cn.longtai.promote.spring.cloud.starter.stream.rocketmq.consume.simple;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

/**
 * My sink.
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
