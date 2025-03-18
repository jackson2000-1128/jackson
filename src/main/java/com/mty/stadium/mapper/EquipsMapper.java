package com.mty.stadium.mapper;


import com.mty.stadium.model.Equips;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface EquipsMapper extends MyMapper<Equips> {

    /**
     * 根据参数查询列表
     */
    List<Equips> selectByCondition(Equips equips);

    /**
     * 查询所有
     */
    List<Equips> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(Equips equips);

    /**
     * 根据id更新信息
     */
    int updateById(Equips equips);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    Equips selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<Equips> queryFilter(Map mp);

}
