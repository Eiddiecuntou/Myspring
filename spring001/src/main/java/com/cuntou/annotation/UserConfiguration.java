package com.cuntou.annotation;

import com.cuntou.entity.User;
import org.springframework.context.annotation.Bean;

//@Configuration
public class UserConfiguration {

    //提供返回对象的方法
    @Bean
    public User user(){
        return new User(1,"张三",22);
    }

}
