package cn.jc.service.impl;

import cn.jc.dao.DepartmentDao;
import cn.jc.entity.Classes;
import cn.jc.entity.Department;
import cn.jc.entity.PageBean;
import cn.jc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao mapper;

    @Override
    public PageBean<Department> listDepartment(int currentPage, int limit, String name) {
        PageBean<Department> rolePageBean = new PageBean<Department>();
        List<Department> rs = mapper.listDepartment((currentPage-1)*limit, limit, name);
        rolePageBean.setData(rs);
        rolePageBean.setCount(mapper.getCountTotal(name));
        return rolePageBean;
    }

    @Override
    public List<Classes> deleteDepartment(int id) {
        return mapper.deleteDepartment(id);
    }

    @Override
    public Department loadDepartment(int id) {
        return mapper.findById(id);
    }

    @Override
    public boolean updateDepartment(Department department) {
        return mapper.updateDepartment(department);
    }

    @Override
    public List<Classes> addDepartment(Department department) {
        return mapper.insertDepartment(department);
    }


}
