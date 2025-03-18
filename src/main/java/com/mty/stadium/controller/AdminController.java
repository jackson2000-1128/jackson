package com.mty.stadium.controller;

import com.mty.stadium.model.Admin;
import com.mty.stadium.service.AdminService;
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
@RequestMapping(value = "/admin")
public class AdminController {


    // 依赖注入
    @Autowired
    private AdminService adminService;


    /**进入列表页面*/
    @GetMapping("/admin")
    public String userIframe(){
        return "AdminList";
    }

    /**列表数据*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findAdmin(Admin admin, Integer limit, Integer page){
        PageHelper.startPage(page,limit);
        List<Admin> adminList = adminService.selectByCondition(admin);
        PageInfo<Admin> pages = new PageInfo<>(adminList);
        return JsonData.table(adminList,pages.getTotal());
    }


    /**编辑详情*/
    @GetMapping("/edit")
    @ResponseBody
    public Admin edit(Model model, String id){
        return adminService.selectById(id);
    }


    /**编辑*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Admin admin){
        int a = adminService.updateById(admin);
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
          adminService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("出现错误");
        }
        return JsonData.success(null,"删除成功");
    }

    /**新增*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Admin admin){
        Date date = new Date();
        admin.setCreateTime(date);
        int num = adminService.addByCondition(admin);
        if(num > 0){
          return JsonData.success(null,"添加成功");
        }else {
          return JsonData.fail("添加失败");
        }
    }

}
