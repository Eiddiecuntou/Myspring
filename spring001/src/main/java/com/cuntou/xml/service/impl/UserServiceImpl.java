package com.cuntou.xml.service.impl;

import com.cuntou.entity.User;
import com.cuntou.xml.dao.UserDAO;
import com.cuntou.xml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getById(Integer id) {
        return this.userDAO.getById(id);
    }
}
