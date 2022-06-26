package org.kuaidao.promote.shardingsphere.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.kuaidao.promote.shardingsphere.sample.mapper")
public class ShardingsphereSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereSampleApplication.class, args);
    }

}
