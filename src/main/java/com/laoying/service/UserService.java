package com.laoying.service;

import com.laoying.model.User;

public interface UserService {
    User getUser(User user);
    boolean addUser(User user);
}
