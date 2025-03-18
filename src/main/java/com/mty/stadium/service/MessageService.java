package com.mty.stadium.service;

import com.mty.stadium.mapper.MessageMapper;
import com.mty.stadium.model.Message;
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
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;


    /**
     * 查询所有
     */
    public List<Message> findAll(){
        return messageMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<Message> selectByCondition(Message message) {
        return messageMapper.selectByCondition(message);
    }

    /**
     * 根据参数查询列表
     */
    public List<Message> queryFilter(Map mp) {
        return messageMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(Message message)  {
        return messageMapper.updateById(message);
    }


    /**
     * 根据id查询信息
     */
    public Message selectById(String id) {
        return messageMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        messageMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(Message message) {
        int a = messageMapper.addByCondition(message);
        return a;
    }



}
