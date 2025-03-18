package com.mty.stadium.service;

import com.mty.stadium.mapper.AdminMapper;
import com.mty.stadium.model.Admin;
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
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;


    /**
     * 查询所有
     */
    public List<Admin> findAll(){
        return adminMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<Admin> selectByCondition(Admin admin) {
        return adminMapper.selectByCondition(admin);
    }

    /**
     * 根据参数查询列表
     */
    public List<Admin> queryFilter(Map mp) {
        return adminMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(Admin admin)  {
        return adminMapper.updateById(admin);
    }


    /**
     * 根据id查询信息
     */
    public Admin selectById(String id) {
        return adminMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        adminMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(Admin admin) {
        int a = adminMapper.addByCondition(admin);
        return a;
    }



}
