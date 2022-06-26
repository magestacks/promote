package org.kuaidao.promote.shardingsphere.sample.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户
 *
 * @author chen.ma
 */
@Data
@AllArgsConstructor
@TableName("user")
public class User {

    private Long id;

    private String name;
}
