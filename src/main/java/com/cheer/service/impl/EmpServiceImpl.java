/*
 * 文件名：EmpServiceImpl.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月28日
 */

package com.cheer.service.impl;


import java.util.List;

import com.cheer.dao.EmpDao;
import com.cheer.domain.Emp;
import com.cheer.service.EmpService;
import com.cheer.util.Page;


public class EmpServiceImpl implements EmpService
{
    private EmpDao empDao;

    public EmpServiceImpl(EmpDao empDao)
    {
        this.empDao = empDao;
    }

    @Override
    public void save(Emp emp)
    {
        this.empDao.save(emp);

    }

    @Override
    public void batchSave(List<Emp> emps)
    {
        this.empDao.batchSave(emps);

    }

    @Override
    public void delete(Emp emp)
    {
        this.empDao.delete(emp);

    }

    @Override
    public void update(Emp emp)
    {
        this.empDao.update(emp);

    }

    @Override
    public Emp find(Integer empno)
    {
        return this.empDao.find(empno);
    }

    @Override
    public List<Emp> getAll()
    {
        return this.empDao.getAll();
    }

    @Override
    public int getTotalCount()
    {

        return this.empDao.getTotalCount();
    }

    @Override
    public List<Emp> getPage(Page page)
    {
        return this.empDao.getPage(page);
    }

}
