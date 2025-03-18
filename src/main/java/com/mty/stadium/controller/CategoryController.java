package com.mty.stadium.controller;

import com.mty.stadium.model.Category;
import com.mty.stadium.service.CategoryService;
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
@RequestMapping(value = "/category")
public class CategoryController {


    // 依赖注入
    @Autowired
    private CategoryService categoryService;


    /**进入列表页面*/
    @GetMapping("/category")
    public String userIframe(){
        return "CategoryList";
    }

    /**列表数据*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findCategory(Category category, Integer limit, Integer page){
        PageHelper.startPage(page,limit);
        List<Category> categoryList = categoryService.selectByCondition(category);
        PageInfo<Category> pages = new PageInfo<>(categoryList);
        return JsonData.table(categoryList,pages.getTotal());
    }


    /**编辑详情*/
    @GetMapping("/edit")
    @ResponseBody
    public Category edit(Model model, String id){
        return categoryService.selectById(id);
    }


    /**编辑*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Category category){
        int a = categoryService.updateById(category);
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
          categoryService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("出现错误");
        }
        return JsonData.success(null,"删除成功");
    }

    /**新增*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Category category){
        Date date = new Date();
        category.setCreateTime(date);
        int num = categoryService.addByCondition(category);
        if(num > 0){
          return JsonData.success(null,"添加成功");
        }else {
          return JsonData.fail("添加失败");
        }
    }

}
