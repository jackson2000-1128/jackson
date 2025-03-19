package com.mty.stadium.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mty.stadium.model.Notice;
import com.mty.stadium.model.User;
import com.mty.stadium.service.NoticeService;
import com.mty.stadium.util.JsonData;
import com.mty.stadium.util.PageResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
        @Autowired
        private NoticeService noticeService;

        // 进入列表页面
        @GetMapping("/notice")
        public String userIframe(){
            return "NoticeList";
        }

        //列表数据
        @GetMapping("/list")
        @ResponseBody
        public PageResultVo findNotice(Notice notice, Integer limit, Integer page){
            PageHelper.startPage(page,limit);
            List<Notice> NoticeList = noticeService.selectByCondition(notice);
            PageInfo<Notice> pages = new PageInfo<>(NoticeList);
            return JsonData.table(NoticeList,pages.getTotal());
        }


    /**编辑详情*/
    @GetMapping("/edit")
    @ResponseBody
    public Notice edit(Model model, Integer id){return noticeService.selectById(id);}


    /**编辑*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Notice notice){
//        List<Notice> all = noticeService.findAll();
//        for(int i=0;i<all.size();i++){
//            if(all.get(i).getTitle().equals(notice.getTitle()) && !all.get(i).getId().equals(notice.getId())){
//                return JsonData.fail("标题重复，请重试！");
//            }
//        }
        int a = noticeService.updateById(notice);
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
            noticeService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
            JsonData.fail("出现错误");
        }
        return JsonData.success(null,"删除成功");
    }

    /**新增*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Notice notice){
        Date date = new Date();
        notice.setCreateTime(date);
        int num = noticeService.addByCondition(notice);
        if(num > 0){
            return JsonData.success(null,"添加成功");
        }else {
            return JsonData.fail("添加失败");
        }
    }

}
