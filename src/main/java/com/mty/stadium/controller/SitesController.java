package com.mty.stadium.controller;

import com.mty.stadium.model.Sites;
import com.mty.stadium.model.Stadium;
import com.mty.stadium.service.SitesService;
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
@RequestMapping(value = "/sites")
public class SitesController {


    // 依赖注入
    @Autowired
    private SitesService sitesService;
    @Autowired
    private StadiumService stadiumService;

    /**进入列表页面*/
    @GetMapping("/sites")
    public String userIframe(Model model){
        Stadium stadium = new Stadium();
        List<Stadium> stadiums = stadiumService.selectByCondition(stadium);
        model.addAttribute("stadiums",stadiums);
        return "SitesList";
    }

    /**列表数据*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findSites(Sites sites, Integer limit, Integer page){
        PageHelper.startPage(page,limit);
        List<Sites> sitesList = sitesService.selectByCondition(sites);
        PageInfo<Sites> pages = new PageInfo<>(sitesList);
        return JsonData.table(sitesList,pages.getTotal());
    }


    /**编辑详情*/
    @GetMapping("/edit")
    @ResponseBody
    public Sites edit(Model model, String id){
        return sitesService.selectById(id);
    }


    /**编辑*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Sites sites){
        int a = sitesService.updateById(sites);
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
          sitesService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("出现错误");
        }
        return JsonData.success(null,"删除成功");
    }

    /**新增*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Sites sites){
        Date date = new Date();
        sites.setCreateTime(date);
        int num = sitesService.addByCondition(sites);
        if(num > 0){
          return JsonData.success(null,"添加成功");
        }else {
          return JsonData.fail("添加失败");
        }
    }

}
