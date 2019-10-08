package cn.jc.service;

import cn.jc.entity.Classes;
import cn.jc.entity.Department;
import cn.jc.entity.PageBean;

import java.util.List;


public interface DepartmentService {

    //查询
    public PageBean<Department> listDepartment(int currentPage, int limit, String name);


    //删除
    public List<Classes> deleteDepartment(int id);


    //指定查询

    public Department loadDepartment(int id);

    //修改

    public boolean updateDepartment(Department department);

    //添加

    public List<Classes> addDepartment(Department department);
}
