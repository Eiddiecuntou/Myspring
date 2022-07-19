package com.cuntou.xml.dao.impl;

import com.cuntou.entity.User;
import com.cuntou.xml.dao.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//@Component
@Repository
public class UserDAOImpl implements UserDAO {

    private static Map<Integer,User> userMap;

    static {
        userMap = new HashMap<>();
        userMap.put(1, new User(1, "张三", 20));
        userMap.put(2, new User(2, "李四", 21));
        userMap.put(3, new User(3, "王五", 22));
    }

    @Override
    public User getById(Integer id) {
        return userMap.get(id);
    }
}
