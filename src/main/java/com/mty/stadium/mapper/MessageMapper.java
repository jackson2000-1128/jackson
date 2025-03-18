package com.mty.stadium.mapper;


import com.mty.stadium.model.Message;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface MessageMapper extends MyMapper<Message> {

    /**
     * 根据参数查询列表
     */
    List<Message> selectByCondition(Message message);

    /**
     * 查询所有
     */
    List<Message> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(Message message);

    /**
     * 根据id更新信息
     */
    int updateById(Message message);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    Message selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<Message> queryFilter(Map mp);

}
