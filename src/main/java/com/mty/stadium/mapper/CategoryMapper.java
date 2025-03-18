package com.mty.stadium.mapper;


import com.mty.stadium.model.Category;
import com.mty.stadium.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface CategoryMapper extends MyMapper<Category> {

    /**
     * 根据参数查询列表
     */
    List<Category> selectByCondition(Category category);

    /**
     * 查询所有
     */
    List<Category> findAll();

    /**
     * 根据id添加信息
     */
    int addByCondition(Category category);

    /**
     * 根据id更新信息
     */
    int updateById(Category category);

    /**
     * 根据删除信息
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查询
     */
    Category selectById(String id);

    /**
     * 根据参数查询列表
     */
    List<Category> queryFilter(Map mp);

}
