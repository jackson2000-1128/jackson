package com.mty.stadium.mapper;


import com.mty.stadium.model.Leases;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface LeasesMapper extends MyMapper<Leases> {

    /**
     * 根据参数查询列表
     */
    List<Leases> selectByCondition(Leases leases);

    /**
     * 查询所有
     */
    List<Leases> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(Leases leases);

    /**
     * 根据id更新信息
     */
    int updateById(Leases leases);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    Leases selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<Leases> queryFilter(Map mp);

}
