package cn.jc.service.impl;


import cn.jc.dao.EmployeesDao;
import cn.jc.entity.Classes;
import cn.jc.entity.Employees;
import cn.jc.entity.PageBean;
import cn.jc.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesDao mapper;
    @Override
    public PageBean<Employees> listEmployees(int currentPage, int limit, String name) {
        PageBean<Employees> rolePageBean = new PageBean<Employees>();
        List<Employees> rs = mapper.listEmployees((currentPage-1)*limit, limit, name);
        rolePageBean.setData(rs);
        rolePageBean.setCount(mapper.getCountTotal(name));
        return rolePageBean;

    }

    @Override
    public List<Classes> deleteEmployees(int id) {
        return mapper.deleteEmployees(id);
    }

    @Override
    public Employees loadEmployees(int id) {
        return mapper.findById(id);
    }

    @Override
    public boolean updateEmployees(Employees employees) {
        return mapper.updateEmployees(employees);
    }

    @Override
    public List<Classes> addEmployeest(Employees employees) {
        return mapper.insertEmployees(employees);
    }


}
