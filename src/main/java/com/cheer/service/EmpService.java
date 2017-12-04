/*
 * 文件名：EmpService.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月28日
 */

package com.cheer.service;


import java.util.List;

import com.cheer.domain.Emp;
import com.cheer.util.Page;


public interface EmpService
{
    void save(Emp emp);

    void batchSave(List<Emp> emps);

    void delete(Emp emp);

    void update(Emp emp);

    Emp find(Integer empno);

    List<Emp> getAll();

    int getTotalCount();

    List<Emp> getPage(Page page);
}
