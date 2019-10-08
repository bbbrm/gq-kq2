package cn.jc.service.impl;

import cn.jc.dao.StationDao;

import cn.jc.entity.Classes;
import cn.jc.entity.PageBean;
import cn.jc.entity.Station;
import cn.jc.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationDao mapper;


    @Override
    public PageBean<Station> listStation(int currentPage, int limit, String name) {
        PageBean<Station> rolePageBean = new PageBean<Station>();
        List<Station> rs = mapper.listStation((currentPage-1)*limit, limit, name);
        rolePageBean.setData(rs);
        rolePageBean.setCount(mapper.getCountTotal(name));
        return rolePageBean;
    }

    @Override
    public List<Classes> deleteStation(int id) {
        return mapper.deleteStation(id);
    }

    @Override
    public Station loadStation(int id) {
        return mapper.findById(id);
    }

    @Override
    public boolean updateStation(Station station) {
        return mapper.updateStation(station);
    }

    @Override
    public List<Classes> addStation(Station station) {
        return mapper.insertStation(station);
    }
}
