/*
 * 文件名：UserServiceImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：皮皮周
 * 修改时间：2017年12月4日
 */

package com.cheer.service.impl;

import com.cheer.dao.UserDao;
import com.cheer.domain.User;
import com.cheer.service.UserService;

public class UserServiceImpl implements UserService
{
    private UserDao userDao;
    
    public UserServiceImpl(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public void save(User user)
    {
        this.userDao.save(user);

    }

    @Override
    public void delete(User user)
    {
        this.userDao.delete(user);

    }

    @Override
    public void update(User user)
    {
        this.userDao.update(user);

    }

    @Override
    public User find(String username)
    {
        return this.userDao.find(username);
    }

}
