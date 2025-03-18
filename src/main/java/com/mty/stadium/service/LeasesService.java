package com.mty.stadium.service;

import com.mty.stadium.mapper.LeasesMapper;
import com.mty.stadium.model.Leases;
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
public class LeasesService {

    @Autowired
    private LeasesMapper leasesMapper;


    /**
     * 查询所有
     */
    public List<Leases> findAll(){
        return leasesMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<Leases> selectByCondition(Leases leases) {
        return leasesMapper.selectByCondition(leases);
    }

    /**
     * 根据参数查询列表
     */
    public List<Leases> queryFilter(Map mp) {
        return leasesMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(Leases leases)  {
        return leasesMapper.updateById(leases);
    }


    /**
     * 根据id查询信息
     */
    public Leases selectById(String id) {
        return leasesMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        leasesMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(Leases leases) {
        int a = leasesMapper.addByCondition(leases);
        return a;
    }



}
