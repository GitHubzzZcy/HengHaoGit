package com.henghao.service.impl;

import com.henghao.dao.IUserDao;
import com.henghao.model.User;
import com.henghao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
@Transactional //声明式事物管理
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    public User selectUser(long userId) {
        System.out.println("userId:"+userId);
        return this.userDao.selectUser(userId);
    }

    @Override
    public List<User> queryUserAll() {
        return this.userDao.queryUserAll();
    }

    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    public Object queryObjTest(long id) {
        Object o = this.userDao.queryObjTest(id);
       // User user = (User) o;
        return o;
    }

    @Override
    public void updateUserEntiyty(User user) {
        this.userDao.updateUserEntiyty(user);
    }

    @Override
    public void deleteUserById(long id) {
        this.userDao.deleteUserById(id);
    }

}