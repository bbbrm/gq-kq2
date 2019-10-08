package cn.jc.service;

import cn.jc.entity.Classes;
import cn.jc.entity.PageBean;

import java.util.List;

public interface ClassesService {

    //查询
    public PageBean<Classes> listClasses(int currentPage, int limit, String name);


    //删除
    public List<Classes> deleteClasses(int id);


    //指定查询

    public Classes loadClasses(int id);

    //修改

    public boolean updateClasses(Classes classes);

    //添加

    public List<Classes> addClasses(Classes classes);
}
