package cn.jc.dao;

import cn.jc.entity.Classes;
import cn.jc.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {

    //查询
    List<Department> listDepartment(@Param("currentPage") int currentPage, @Param("limit") int limit, @Param("name") String name);


    //查询总条数

    Integer getCountTotal(@Param("name") String name);


    //指定查询
    Department findById(int id);

    //修改

    boolean updateDepartment(Department department);

    //删除
    List<Classes> deleteDepartment(int id);

    //添加

    List<Classes> insertDepartment(Department department);
}
