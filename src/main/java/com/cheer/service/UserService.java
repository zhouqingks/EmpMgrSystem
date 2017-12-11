/*
 * 文件名：UserService.java 版权：Copyright by www.cheer.com 描述： 修改人：皮皮周 修改时间：2017年12月4日
 */

package com.cheer.service;


import com.cheer.domain.User;


public interface UserService
{
    void save(User user);

    void delete(User user);

    void update(User user);

    User find(String username);
}
