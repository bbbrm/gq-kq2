package cn.jc.service;

import cn.jc.entity.Classes;
import cn.jc.entity.Employees;
import cn.jc.entity.PageBean;

import java.util.List;


public interface EmployeesService {

    //查询
    public PageBean<Employees> listEmployees(int currentPage, int limit, String name);


    //删除
    public List<Classes> deleteEmployees(int id);


    //指定查询

    public Employees loadEmployees(int id);

    //修改

    public boolean updateEmployees(Employees employees);

    //添加

    public List<Classes> addEmployeest(Employees employees);

}
