package com.mty.stadium.mapper;


import com.mty.stadium.model.Apply;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface ApplyMapper extends MyMapper<Apply> {

    /**
     * 根据参数查询列表
     */
    List<Apply> selectByCondition(Apply apply);

    /**
     * 查询所有
     */
    List<Apply> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(Apply apply);

    /**
     * 根据id更新信息
     */
    int updateById(Apply apply);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    Apply selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<Apply> queryFilter(Map mp);

}
