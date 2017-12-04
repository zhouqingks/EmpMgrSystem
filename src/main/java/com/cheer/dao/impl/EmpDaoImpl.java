/*
 * 文件名：EmpDaoImpl.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月28日
 */

package com.cheer.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.dao.EmpDao;
import com.cheer.domain.Emp;
import com.cheer.util.DBHelper;
import com.cheer.util.Page;


public class EmpDaoImpl implements EmpDao
{
    private static final Logger LOGGER = LogManager.getLogger(EmpDaoImpl.class);

    public EmpDaoImpl()
    {

    }

    @Override
    public void save(Emp emp)
    {
        Connection conn = DBHelper.getInstance().getConnection();
        String sql = "insert into emp1 values(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        int result = 0;
        try
        {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, emp.getEmpno());
            ps.setString(2, emp.getEname());
            ps.setString(3, emp.getJob());
            ps.setInt(4, emp.getMgr());
            ps.setDate(5,(java.sql.Date)emp.getHiredate());
            ps.setDouble(6, emp.getSal());
            ps.setDouble(7, emp.getComm());
            ps.setInt(8, emp.getDeptno());
            
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
    public void batchSave(List<Emp> emps)
    {

    }

    @Override
    public void delete(Emp emp)
    {
        Connection conn = DBHelper.getInstance().getConnection();

        String sql = "DELETE FROM emp1 WHERE empno = ?";

        PreparedStatement ps = null;

        int result = 0;
        try
        {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, emp.getEmpno());

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
    public void update(Emp emp)
    {
        Connection conn = DBHelper.getInstance().getConnection();
        String sql = "update emp1 set ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ? WHERE empno = ?";
        PreparedStatement ps = null;
        int result = 0;
        try
        {
            ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getEname());
            ps.setString(2, emp.getJob());
            ps.setInt(3, emp.getMgr());
            ps.setDate(4,(java.sql.Date)emp.getHiredate());
            ps.setDouble(5, emp.getSal());
            ps.setDouble(6, emp.getComm());
            ps.setInt(7, emp.getDeptno());
            ps.setInt(8, emp.getEmpno());
            result = ps.executeUpdate();

            LOGGER.debug(sql);
            LOGGER.debug("修改{}条记录", result);
            
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
    public Emp find(Integer empno)
    {
        return null;
    }

    @Override
    public List<Emp> getAll()
    {
        List<Emp> empList = new ArrayList<>();
        Connection conn = DBHelper.getInstance().getConnection();

        // String sql = "SELECT * FROM emp1 e LEFT OUT JOIN tbl_dept d ON(e.deptno = d.deptno)
        // ORDER BY empno";

        String sql = "SELECT * FROM emp1 ORDER BY empno";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            Emp emp = null;
            while (rs.next())
            {
                emp = new Emp();

                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getDouble("sal"));
                emp.setComm(rs.getDouble("comm"));
                emp.setDeptno(rs.getInt("deptno"));
                empList.add(emp);
            }
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

        return empList;
    }

    @Override
    public int getTotalCount()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Emp> getPage(Page page)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
