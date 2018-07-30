package com.w.service.impl;

import com.w.dao.UserMapper;
import com.w.model.User;
import com.w.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByNamePass(User user) {
        return userMapper.getUserByNamePass( user );
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser( user );
    }

    @Override
    public User getUserByName(User user) {
        return userMapper.getUserByName( user );
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser( user );
    }

    @Override
    public User getUserById(int uid) {
        return userMapper.getUserById( uid );
    }
}
