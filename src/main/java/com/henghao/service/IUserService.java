package com.henghao.service;

import com.henghao.dao.IUserDao;
import com.henghao.model.User;

import java.util.List;

public interface IUserService {

    public User selectUser(long userId);

    public List<User> queryUserAll();

    void addUser(User user);

    Object queryObjTest(long id);

    void updateUserEntiyty(User user);

    void deleteUserById(long id);
}