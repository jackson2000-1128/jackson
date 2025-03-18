package com.mty.stadium.service;

import com.mty.stadium.mapper.StadiumMapper;
import com.mty.stadium.model.Stadium;
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
public class StadiumService {

    @Autowired
    private StadiumMapper stadiumMapper;


    /**
     * 查询所有
     */
    public List<Stadium> findAll(){
        return stadiumMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<Stadium> selectByCondition(Stadium stadium) {
        return stadiumMapper.selectByCondition(stadium);
    }

    /**
     * 根据参数查询列表
     */
    public List<Stadium> queryFilter(Map mp) {
        return stadiumMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(Stadium stadium)  {
        return stadiumMapper.updateById(stadium);
    }


    /**
     * 根据id查询信息
     */
    public Stadium selectById(String id) {
        return stadiumMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        stadiumMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(Stadium stadium) {
        int a = stadiumMapper.addByCondition(stadium);
        return a;
    }



}
