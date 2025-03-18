package com.mty.stadium.service;

import com.mty.stadium.mapper.UserMapper;
import com.mty.stadium.model.User;
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
public class UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 查询所有
     */
    public List<User> findAll(){
        return userMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<User> selectByCondition(User user) {
        return userMapper.selectByCondition(user);
    }

    /**
     * 根据参数查询列表
     */
    public List<User> queryFilter(Map mp) {
        return userMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(User user)  {
        return userMapper.updateById(user);
    }


    /**
     * 根据id查询信息
     */
    public User selectById(String id) {
        return userMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        userMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(User user) {
        int a = userMapper.addByCondition(user);
        return a;
    }



}
