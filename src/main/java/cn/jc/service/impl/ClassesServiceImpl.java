package cn.jc.service.impl;

import cn.jc.dao.ClassesDao;

import cn.jc.entity.Classes;
import cn.jc.entity.PageBean;
import cn.jc.service.ClassesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesDao mapper;


    @Override
    public PageBean<Classes> listClasses(int currentPage, int limit, String name) {
        PageBean<Classes> rolePageBean = new PageBean<Classes>();
        List<Classes> rs = mapper.listClasses((currentPage - 1) * limit, limit, name);
        rolePageBean.setData(rs);
        rolePageBean.setCount(mapper.getCountTotal(name));
        return rolePageBean;
    }

    @Override
    public List<Classes> deleteClasses(int id) {

            return mapper.deleteClasses(id);

    }

    @Override
    public Classes loadClasses(int id) {
        return mapper.findById(id);
    }

    @Override
    public boolean updateClasses(Classes classes) {
        return mapper.updateClasses(classes);
    }

    @Override
    public List<Classes> addClasses(Classes classes) {
        return mapper.insertClasses(classes);
    }


}
