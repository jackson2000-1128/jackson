package com.mty.stadium.service;

import com.mty.stadium.mapper.ConfinesMapper;
import com.mty.stadium.model.Confines;
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
public class ConfinesService {

    @Autowired
    private ConfinesMapper confinesMapper;


    /**
     * 查询所有
     */
    public List<Confines> findAll(){
        return confinesMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<Confines> selectByCondition(Confines confines) {
        return confinesMapper.selectByCondition(confines);
    }

    /**
     * 根据参数查询列表
     */
    public List<Confines> queryFilter(Map mp) {
        return confinesMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(Confines confines)  {
        return confinesMapper.updateById(confines);
    }


    /**
     * 根据id查询信息
     */
    public Confines selectById(String id) {
        return confinesMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        confinesMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(Confines confines) {
        int a = confinesMapper.addByCondition(confines);
        return a;
    }



}
