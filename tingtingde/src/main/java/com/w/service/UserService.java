package com.w.service;

import com.w.model.User;

/**
 * Created by Administrator on 2018/7/25.
 */
public interface UserService {
    User getUserByNamePass(User user);

    boolean updateUser(User user);

    User getUserByName(User user);

    boolean addUser(User user);

    User getUserById(int uid);
}
