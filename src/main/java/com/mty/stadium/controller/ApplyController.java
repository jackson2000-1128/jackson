package com.mty.stadium.controller;

import com.mty.stadium.model.Apply;
import com.mty.stadium.model.Confines;
import com.mty.stadium.model.User;
import com.mty.stadium.service.ApplyService;
import com.mty.stadium.service.ConfinesService;
import com.mty.stadium.util.JsonData;
import com.mty.stadium.util.PageResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 控制层
 * @author: mty
 */
@Controller
@RequestMapping(value = "/apply")
public class ApplyController {


    // 依赖注入
    @Autowired
    private ApplyService applyService;
    @Autowired
    private ConfinesService confinesService;

    /**进入列表页面*/
    @GetMapping("/apply")
    public String userIframe(){
        return "ApplyList";
    }

    /**列表数据*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findApply(Apply apply, Integer limit, Integer page, HttpSession session){
        String type = (String)session.getAttribute("type");
        if(type!=null && !type.equals("01")){
            User user =  (User)session.getAttribute("userInfo");
            apply.setUid(user.getId().toString());
        }
        PageHelper.startPage(page,limit);
        List<Apply> applyList = applyService.selectByCondition(apply);
        PageInfo<Apply> pages = new PageInfo<>(applyList);
        return JsonData.table(applyList,pages.getTotal());
    }


    /**编辑详情*/
    @GetMapping("/edit")
    @ResponseBody
    public Apply edit(Model model, String id){
        return applyService.selectById(id);
    }


    /**编辑*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Apply apply){
        int a = applyService.updateById(apply);
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
          applyService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("出现错误");
        }
        return JsonData.success(null,"删除成功");
    }

    /**新增*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Apply apply, HttpSession session){
        Date date = new Date();

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(now);

        // 验证预约日期是否为当天以后
        try {
            Date applyDate = sdf.parse(apply.getApplyDate());
            Date todayDate = sdf.parse(today);
            if (!applyDate.after(todayDate)) {
                return JsonData.fail("只能预约当天以后的日期！");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return JsonData.fail("预约日期格式错误！");
        }



        String type = (String)session.getAttribute("type");
        if(type!=null && !type.equals("01")){
            User user =  (User)session.getAttribute("userInfo");
            apply.setUid(user.getId().toString());
        }
        //判端是否在限制校外用户预约情况中
        if(type.equals("03")){
            Map mp = new HashMap();
            mp.put("sid",apply.getSid());
            List<Confines> all = confinesService.queryFilter(mp);
            for(int i=0;i<all.size();i++){
                if(all.get(i).getApplyDate().equals(apply.getApplyDate()) && all.get(i).getApplyTime().equals(apply.getApplyTime())){
                    return JsonData.fail("该场地该时段只能校内用户预约！");
                }
            }
        }

        // 检查校内用户是否已经预约该时段
        if (type.equals("03")) {
            Map<String, Object> mp = new HashMap<>();
            mp.put("sid", apply.getSid());
            mp.put("applyDate", apply.getApplyDate());
            mp.put("applyTime", apply.getApplyTime());
            mp.put("type", "02"); // 只查询校内用户的预约
            List<Apply> applies = applyService.queryFilter(mp);
            if (applies.size() > 0) {
                return JsonData.fail("该时段已被校内用户预约，请选择其他时间段！");
            }
        }

        Map mp = new HashMap();
        mp.put("sid",apply.getSid());
        mp.put("applyDate",apply.getApplyDate());
        mp.put("applyTime", apply.getApplyTime());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date);
        mp.put("time",time);
        mp.put("status","01");
        List<Apply> applies = applyService.queryFilter(mp);
        if(applies.size()>0){
            return JsonData.fail("该时段已预约，请选择其他时间段！");
        }
        apply.setStatus("01");
        apply.setCreateTime(date);
        int num = applyService.addByCondition(apply);
        if(num > 0){
          return JsonData.success(null,"预约成功");
        }else {
          return JsonData.fail("预约失败");
        }
    }

}
