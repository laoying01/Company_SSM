package com.laoying.dao;

import com.laoying.model.User;

public interface UserDao {
    User getUser(User user);
    boolean addUser(User user);
}
