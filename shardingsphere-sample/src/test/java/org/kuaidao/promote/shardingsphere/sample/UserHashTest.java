package org.kuaidao.promote.shardingsphere.sample;

import cn.hutool.core.util.IdUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.kuaidao.promote.shardingsphere.sample.mapper.User;
import org.kuaidao.promote.shardingsphere.sample.mapper.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * 用户 Hash
 *
 * @author chen.ma
 */
@Slf4j
@SpringBootApplication
public class UserHashTest {

    private UserMapper userMapper;

    @Before
    public void before() {
        ConfigurableApplicationContext context = SpringApplication.run(UserHashTest.class);
        userMapper = context.getBean(UserMapper.class);
    }

    @Test
    public void insertAndSelect() {
        List<Long> idList = Lists.newArrayList();
        for (int i = 0; i < 100000; i++) {
            long id = IdUtil.getSnowflakeNextId();
            idList.add(id);
            User user = new User(id, "百万");
            userMapper.insert(user);
        }
        /*List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).in(User::getId, idList));
        log.info(users.toString());*/
    }
}
