package com.mty.stadium.mapper;


import com.mty.stadium.model.Sites;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface SitesMapper extends MyMapper<Sites> {

    /**
     * 根据参数查询列表
     */
    List<Sites> selectByCondition(Sites sites);

    /**
     * 查询所有
     */
    List<Sites> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(Sites sites);

    /**
     * 根据id更新信息
     */
    int updateById(Sites sites);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    Sites selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<Sites> queryFilter(Map mp);

}
