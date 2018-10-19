package com.laoying.service.impl;

import com.laoying.dao.UserDao;
import com.laoying.model.User;
import com.laoying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User getUser(User user) {
        if (user==null){
            return null;
        }
        User user1 =userDao.getUser(user);
        if (user1!=null){
            return user1;
        }
        return null;
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
}
