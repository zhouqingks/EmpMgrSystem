/*
 * 文件名：UserDaoImpl.java 版权：Copyright by www.cheer.com 描述： 修改人：皮皮周 修改时间：2017年12月4日
 */

package com.cheer.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.dao.UserDao;
import com.cheer.domain.User;
import com.cheer.util.DBHelper;


public class UserDaoImpl implements UserDao
{
    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);

    @Override
    public void save(User user)
    {
        Connection conn = DBHelper.getInstance().getConnection();
        String sql = "insert into tbl_user values(?, ?)";
        PreparedStatement ps = null;
        int result = 0;
        try
        {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            result = ps.executeUpdate();

            LOGGER.debug(sql);
            LOGGER.debug("增加{}条记录", result);

        }
        catch (SQLException e)
        {
            LOGGER.catching(e);
        }
        finally
        {
            DBHelper.closeStatement(ps);
            DBHelper.closeConnection(conn);
        }

    }

    @Override
    public void delete(User user)
    {
        Connection conn = DBHelper.getInstance().getConnection();

        String sql = "DELETE FROM tbl_user WHERE username = ?";

        PreparedStatement ps = null;

        int result = 0;
        try
        {
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());

            result = ps.executeUpdate();

            LOGGER.debug(sql);
            LOGGER.debug("删除{}条记录", result);
        }
        catch (SQLException e)
        {
            LOGGER.catching(e);
        }
        finally
        {
            DBHelper.closeStatement(ps);
            DBHelper.closeConnection(conn);
        }

    }

    @Override
    public void update(User user)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public User find(String username)
    {
        Connection conn = DBHelper.getInstance().getConnection();
        String sql = "SELECT * FROM tbl_user WHERE username = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try
        {
            ps = conn.prepareStatement(sql);

            ps.setString(1,username);

            rs = ps.executeQuery();
            
            if (rs.next())
            {
                user = new User();
                LOGGER.info("找到账户");
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
            }
            LOGGER.debug(sql);
        }
        catch (SQLException e)
        {
            LOGGER.catching(e);
        }
        finally
        {
            DBHelper.closeResultSet(rs);
            DBHelper.closeStatement(ps);
            DBHelper.closeConnection(conn);
        }
        
        
        return user;
    }

}
