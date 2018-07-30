package com.w.dao;

import com.w.model.User;

/**
 * Created by Administrator on 2018/7/25.
 */
public interface UserMapper {
    User getUserByNamePass(User user);

    boolean updateUser(User user);

    User getUserByName(User user);

    boolean addUser(User user);

    User getUserById(int uid);
}
