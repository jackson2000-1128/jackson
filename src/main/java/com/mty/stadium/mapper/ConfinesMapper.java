package com.mty.stadium.mapper;


import com.mty.stadium.model.Confines;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface ConfinesMapper extends MyMapper<Confines> {

    /**
     * 根据参数查询列表
     */
    List<Confines> selectByCondition(Confines confines);

    /**
     * 查询所有
     */
    List<Confines> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(Confines confines);

    /**
     * 根据id更新信息
     */
    int updateById(Confines confines);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    Confines selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<Confines> queryFilter(Map mp);

}
