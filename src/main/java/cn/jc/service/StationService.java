package cn.jc.service;

import cn.jc.entity.Classes;
import cn.jc.entity.PageBean;
import cn.jc.entity.Station;

import java.util.List;

public interface StationService {

    //查询
    public PageBean<Station> listStation(int currentPage, int limit, String name);


    //删除
    public List<Classes> deleteStation(int id);


    //指定查询

    public Station loadStation(int id);

    //修改

    public boolean updateStation(Station station);

    //添加

    public List<Classes> addStation(Station station);
}
