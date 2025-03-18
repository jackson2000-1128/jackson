package com.mty.stadium.controller;

import com.mty.stadium.model.Category;
import com.mty.stadium.model.Equips;
import com.mty.stadium.model.Sites;
import com.mty.stadium.service.CategoryService;
import com.mty.stadium.service.EquipsService;
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
@RequestMapping(value = "/equips")
public class EquipsController {


    // 依赖注入
    @Autowired
    private EquipsService equipsService;
    @Autowired
    private CategoryService categoryService;


    /**进入列表页面*/
    @GetMapping("/equips")
    public String userIframe(Model model){
        Category category = new Category();
        List<Category> categories = categoryService.selectByCondition(category);
        model.addAttribute("categories",categories);
        return "EquipsList";
    }

    /**列表数据*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findEquips(Equips equips, Integer limit, Integer page){
        PageHelper.startPage(page,limit);
        List<Equips> equipsList = equipsService.selectByCondition(equips);
        PageInfo<Equips> pages = new PageInfo<>(equipsList);
        return JsonData.table(equipsList,pages.getTotal());
    }


    /**编辑详情*/
    @GetMapping("/edit")
    @ResponseBody
    public Equips edit(Model model, String id){
        return equipsService.selectById(id);
    }


    /**编辑*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Equips equips){
        int a = equipsService.updateById(equips);
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
          equipsService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("出现错误");
        }
        return JsonData.success(null,"删除成功");
    }

    /**新增*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Equips equips){
        Date date = new Date();
        equips.setCreateTime(date);
        int num = equipsService.addByCondition(equips);
        if(num > 0){
          return JsonData.success(null,"添加成功");
        }else {
          return JsonData.fail("添加失败");
        }
    }

}
