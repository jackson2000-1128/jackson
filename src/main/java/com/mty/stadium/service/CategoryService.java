package com.mty.stadium.service;

import com.mty.stadium.mapper.CategoryMapper;
import com.mty.stadium.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Service接口实现类
 * @author: mty
 */
@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 查询所有
     */
    public List<Category> findAll(){
        return categoryMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<Category> selectByCondition(Category category) {
        return categoryMapper.selectByCondition(category);
    }

    /**
     * 根据参数查询列表
     */
    public List<Category> queryFilter(Map mp) {
        return categoryMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(Category category)  {
        return categoryMapper.updateById(category);
    }


    /**
     * 根据id查询信息
     */
    public Category selectById(String id) {
        return categoryMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        categoryMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(Category category) {
        int a = categoryMapper.addByCondition(category);
        return a;
    }



}
