package com.mty.stadium.service;

import com.mty.stadium.mapper.SitesMapper;
import com.mty.stadium.model.Sites;
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
public class SitesService {

    @Autowired
    private SitesMapper sitesMapper;


    /**
     * 查询所有
     */
    public List<Sites> findAll(){
        return sitesMapper.findAll();
    }

    /**
     * 根据参数查询列表
     */
    public List<Sites> selectByCondition(Sites sites) {
        return sitesMapper.selectByCondition(sites);
    }

    /**
     * 根据参数查询列表
     */
    public List<Sites> queryFilter(Map mp) {
        return sitesMapper.queryFilter(mp);
    }

    /**
     * 根据id更新信息
     */
    public int updateById(Sites sites)  {
        return sitesMapper.updateById(sites);
    }


    /**
     * 根据id查询信息
     */
    public Sites selectById(String id) {
        return sitesMapper.selectById(id);
    }


    /**
     * 根据id删除
     */
    public void deleteById(Integer id){
        sitesMapper.deleteById(id);
    }

    /**
     * 增加
     */
    public int addByCondition(Sites sites) {
        int a = sitesMapper.addByCondition(sites);
        return a;
    }


    public List<Sites> queryAvailableSites(String type, String applyDate, String applyTime) {
        Map<String, Object> mp = new HashMap<>();
        mp.put("applyDate", applyDate);
        mp.put("applyTime", applyTime);
        if (type.equals("03")) {
            mp.put("excludeType", "02"); // 排除校内用户已预约的场地
        }
        return sitesMapper.queryAvailableSites(mp);
    }

}
