package com.mty.stadium.mapper;

import com.mty.stadium.model.Notice;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;


public interface NoticeMapper extends MyMapper<Notice> {

    /**
     * 根据参数查询列表
     */
    List<Notice> selectByCondition(Notice notice);

    /**
     * 查询所有
     */
    List<Notice> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(Notice notice);

    /**
     * 根据id更新信息
     */
    int updateById(Notice notice);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    Notice selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<Notice> queryFilter(Map mp);
}
