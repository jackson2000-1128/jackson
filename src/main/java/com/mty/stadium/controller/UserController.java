package com.mty.stadium.controller;

import com.mty.stadium.model.User;
import com.mty.stadium.service.UserService;
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
@RequestMapping(value = "/user")
public class UserController {


    // 依赖注入
    @Autowired
    private UserService userService;


    /**进入列表页面*/
    @GetMapping("/user")
    public String userIframe(){
        return "UserList";
    }

    /**列表数据*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findUser(User user, Integer limit, Integer page){
        PageHelper.startPage(page,limit);
        List<User> userList = userService.selectByCondition(user);
        PageInfo<User> pages = new PageInfo<>(userList);
        return JsonData.table(userList,pages.getTotal());
    }


    /**编辑详情*/
    @GetMapping("/edit")
    @ResponseBody
    public User edit(Model model, String id){
        return userService.selectById(id);
    }


    /**编辑*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(User user){
        List<User> all = userService.findAll();
        for(int i=0;i<all.size();i++){
            if(all.get(i).getUsername().equals(user.getUsername()) && !all.get(i).getId().equals(user.getId())){
                return JsonData.fail("用户名重复，请重试！");
            }
        }
        int a = userService.updateById(user);
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
          userService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("出现错误");
        }
        return JsonData.success(null,"删除成功");
    }

    /**新增*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(User user){
        List<User> all = userService.findAll();
        for(int i=0;i<all.size();i++){
            if(all.get(i).getUsername().equals(user.getUsername())){
                return JsonData.fail("用户名重复，请重试！");
            }
        }
        Date date = new Date();
        user.setCreateTime(date);
        int num = userService.addByCondition(user);
        if(num > 0){
          return JsonData.success(null,"添加成功");
        }else {
          return JsonData.fail("添加失败");
        }
    }

}
