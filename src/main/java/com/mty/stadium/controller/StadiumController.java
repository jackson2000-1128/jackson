package com.mty.stadium.controller;

import com.mty.stadium.model.Stadium;
import com.mty.stadium.service.StadiumService;
import com.mty.stadium.util.JsonData;
import com.mty.stadium.util.PageResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * @description: 控制层
 * @author: mty
 */
@Controller
@RequestMapping(value = "/stadium")
public class StadiumController {


    // 依赖注入
    @Autowired
    private StadiumService stadiumService;


    /**进入列表页面*/
    @GetMapping("/stadium")
    public String userIframe(){
        return "StadiumList";
    }

    /**列表数据*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findStadium(Stadium stadium, Integer limit, Integer page){
        PageHelper.startPage(page,limit);
        List<Stadium> stadiumList = stadiumService.selectByCondition(stadium);
        PageInfo<Stadium> pages = new PageInfo<>(stadiumList);
        return JsonData.table(stadiumList,pages.getTotal());
    }


    /**编辑详情*/
    @GetMapping("/edit")
    @ResponseBody
    public Stadium edit(Model model, String id){
        return stadiumService.selectById(id);
    }


    /**编辑*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Stadium stadium){
        int a = stadiumService.updateById(stadium);
        if (a > 0) {
          return JsonData.success(null,"编辑成功！");
        } else {
          return JsonData.fail("编辑失败");
        }
    }


    /**删除*/
    @PostMapping("/del")
    @ResponseBody
    public JsonData del(String id){
        try{
          stadiumService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("出现错误");
        }
        return JsonData.success(null,"删除成功");
    }

    /**新增*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Stadium stadium){
        Date date = new Date();
        stadium.setCreateTime(date);
        int num = stadiumService.addByCondition(stadium);
        if(num > 0){
          return JsonData.success(null,"添加成功");
        }else {
          return JsonData.fail("添加失败");
        }
    }

}
