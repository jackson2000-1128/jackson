package com.mty.stadium.service;

import com.mty.stadium.mapper.EquipsMapper;
import com.mty.stadium.model.Equips;
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
public class EquipsService {

    @Autowired
    private EquipsMapper equipsMapper;


    /**
     * 查询所有
     */
    public List<Equips> findAll(){
        return equipsMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<Equips> selectByCondition(Equips equips) {
        return equipsMapper.selectByCondition(equips);
    }

    /**
     * 根据参数查询列表
     */
    public List<Equips> queryFilter(Map mp) {
        return equipsMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(Equips equips)  {
        return equipsMapper.updateById(equips);
    }


    /**
     * 根据id查询信息
     */
    public Equips selectById(String id) {
        return equipsMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        equipsMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(Equips equips) {
        int a = equipsMapper.addByCondition(equips);
        return a;
    }



}
