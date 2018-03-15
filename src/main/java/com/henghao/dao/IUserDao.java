package com.henghao.dao;


import com.henghao.model.User;

import java.util.List;

public interface IUserDao {

    public User selectUser(long id);

    public List<User> queryUserAll();

    void addUser(User user);
    public  Object queryObjTest(long id);

    void updateUserEntiyty(User user);

    void deleteUserById(long id);
}