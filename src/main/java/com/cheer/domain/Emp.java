/*
 * 文件名：Emp.java 版权：Copyright by www.cheer.com 描述： 修改人：皮皮周 修改时间：2017年11月28日
 */

package com.cheer.domain;


import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class Emp
{
    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    private Date hiredate;

    private Double sal;

    private Double comm;

    private Integer deptno;

    public Emp()
    {}

    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Double sal,
               Double comm, Integer deptno)
    {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public Integer getEmpno()
    {
        return empno;
    }

    public void setEmpno(Integer empno)
    {
        this.empno = empno;
    }

    public String getEname()
    {
        return ename;
    }

    public void setEname(String ename)
    {
        this.ename = ename;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

    public Integer getMgr()
    {
        return mgr;
    }

    public void setMgr(Integer mgr)
    {
        this.mgr = mgr;
    }

    public Date getHiredate()
    {
        return hiredate;
    }

    public void setHiredate(Date hiredate)
    {
        this.hiredate = hiredate;
    }

    public Double getSal()
    {
        return sal;
    }

    public void setSal(Double sal)
    {
        this.sal = sal;
    }

    public Double getComm()
    {
        return comm;
    }

    public void setComm(Double comm)
    {
        this.comm = comm;
    }

    public Integer getDeptno()
    {
        return deptno;
    }

    public void setDeptno(Integer deptno)
    {
        this.deptno = deptno;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
    
    

}
