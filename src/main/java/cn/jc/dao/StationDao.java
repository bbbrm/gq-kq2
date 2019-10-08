package cn.jc.dao;

import cn.jc.entity.Classes;
import cn.jc.entity.Station;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StationDao {

    //查询
    List<Station> listStation(@Param("currentPage") int currentPage, @Param("limit") int limit, @Param("name") String name);


    //查询总条数

    Integer getCountTotal(@Param("name") String name);


    //指定查询
    Station findById(int id);

    //修改

    boolean updateStation(Station station);

    //删除
    List<Classes> deleteStation(int id);

    //添加

    List<Classes> insertStation(Station station);
}
