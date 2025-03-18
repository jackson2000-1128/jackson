package com.mty.stadium.mapper;


import com.mty.stadium.model.Stadium;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface StadiumMapper extends MyMapper<Stadium> {

    /**
     * 根据参数查询列表
     */
    List<Stadium> selectByCondition(Stadium stadium);

    /**
     * 查询所有
     */
    List<Stadium> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(Stadium stadium);

    /**
     * 根据id更新信息
     */
    int updateById(Stadium stadium);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    Stadium selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<Stadium> queryFilter(Map mp);

}
