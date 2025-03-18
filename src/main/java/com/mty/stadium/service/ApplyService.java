package com.mty.stadium.service;

import com.mty.stadium.mapper.ApplyMapper;
import com.mty.stadium.model.Apply;
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
public class ApplyService {

    @Autowired
    private ApplyMapper applyMapper;


    /**
     * 查询所有
     */
    public List<Apply> findAll(){
        return applyMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<Apply> selectByCondition(Apply apply) {
        return applyMapper.selectByCondition(apply);
    }

    /**
     * 根据参数查询列表
     */
    public List<Apply> queryFilter(Map mp) {
        return applyMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(Apply apply)  {
        return applyMapper.updateById(apply);
    }


    /**
     * 根据id查询信息
     */
    public Apply selectById(String id) {
        return applyMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        applyMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(Apply apply) {
        int a = applyMapper.addByCondition(apply);
        return a;
    }



}
