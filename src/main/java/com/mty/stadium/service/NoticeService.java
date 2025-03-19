package com.mty.stadium.service;

import com.mty.stadium.mapper.NoticeMapper;
import com.mty.stadium.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;


    /**
     * 查询所有
     */
    public List<Notice> findAll(){
        return noticeMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<Notice> selectByCondition(Notice notice) {
        return noticeMapper.selectByCondition(notice);
    }

    /**
     * 根据参数查询列表
     */
    public List<Notice> queryFilter(Map mp) {
        return noticeMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(Notice notice)  {
        return noticeMapper.updateById(notice);
    }


    /**
     * 根据id查询信息
     */
    public Notice selectById(String id) {
        return noticeMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        noticeMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(Notice notice) {
        int a = noticeMapper.addByCondition(notice);
        return a;
    }
}
