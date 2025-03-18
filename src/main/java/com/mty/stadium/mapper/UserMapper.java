package com.mty.stadium.mapper;


import com.mty.stadium.model.User;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface UserMapper extends MyMapper<User> {

    /**
     * 根据参数查询列表
     */
    List<User> selectByCondition(User user);

    /**
     * 查询所有
     */
    List<User> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(User user);

    /**
     * 根据id更新信息
     */
    int updateById(User user);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    User selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<User> queryFilter(Map mp);

}
