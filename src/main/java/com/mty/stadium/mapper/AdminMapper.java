package com.mty.stadium.mapper;


import com.mty.stadium.model.Admin;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface AdminMapper extends MyMapper<Admin> {

    /**
     * 根据参数查询列表
     */
    List<Admin> selectByCondition(Admin admin);

    /**
     * 查询所有
     */
    List<Admin> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(Admin admin);

    /**
     * 根据id更新信息
     */
    int updateById(Admin admin);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    Admin selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<Admin> queryFilter(Map mp);

}
