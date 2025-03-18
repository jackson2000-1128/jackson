package com.mty.stadium.controller;

import com.mty.stadium.model.Message;
import com.mty.stadium.model.User;
import com.mty.stadium.service.MessageService;
import com.mty.stadium.util.JsonData;
import com.mty.stadium.util.PageResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @description: 控制层
 * @author: mty
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {


    // 依赖注入
    @Autowired
    private MessageService messageService;


    /**进入列表页面*/
    @GetMapping("/message")
    public String userIframe(){
        return "MessageList";
    }

    /**列表数据*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findMessage(Message message, Integer limit, Integer page, HttpSession session){
        String type = (String)session.getAttribute("type");
        if(type!=null && !type.equals("01")){
            User user =  (User)session.getAttribute("userInfo");
            message.setUid(user.getId().toString());
        }
        PageHelper.startPage(page,limit);
        List<Message> messageList = messageService.selectByCondition(message);
        PageInfo<Message> pages = new PageInfo<>(messageList);
        return JsonData.table(messageList,pages.getTotal());
    }


    /**编辑详情*/
    @GetMapping("/edit")
    @ResponseBody
    public Message edit(Model model, String id){
        return messageService.selectById(id);
    }


    /**编辑*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Message message){
        int a = messageService.updateById(message);
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
          messageService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("出现错误");
        }
        return JsonData.success(null,"删除成功");
    }

    /**新增*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Message message, HttpSession session){
        String type = (String)session.getAttribute("type");
        if(type!=null && !type.equals("01")){
            User user =  (User)session.getAttribute("userInfo");
            message.setUid(user.getId().toString());
        }
        Date date = new Date();
        message.setCreateTime(date);
        int num = messageService.addByCondition(message);
        if(num > 0){
          return JsonData.success(null,"添加成功");
        }else {
          return JsonData.fail("添加失败");
        }
    }

}
