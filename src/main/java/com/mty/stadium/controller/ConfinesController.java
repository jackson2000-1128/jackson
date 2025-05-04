package com.mty.stadium.controller;

import com.mty.stadium.model.Confines;
import com.mty.stadium.model.Sites;
import com.mty.stadium.model.Stadium;
import com.mty.stadium.service.ConfinesService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 控制层
 * @author: mty
 */
@Controller
@RequestMapping(value = "/confines")
public class ConfinesController {


    // 依赖注入
    @Autowired
    private ConfinesService confinesService;
    @Autowired
    private SitesService sitesService;


    /**
     * 进入列表页面
     */
    @GetMapping("/confines")
    public String userIframe(Model model) {
        Sites sites = new Sites();
        List<Sites> sitesList = sitesService.selectByCondition(sites);
        model.addAttribute("sitesList", sitesList);
        return "ConfinesList";
    }

    /**
     * 列表数据
     */
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findConfines(Confines confines, Integer limit, Integer page) {
        PageHelper.startPage(page, limit);
        List<Confines> confinesList = confinesService.selectByCondition(confines);
        PageInfo<Confines> pages = new PageInfo<>(confinesList);
        return JsonData.table(confinesList, pages.getTotal());
    }


    /**
     * 编辑详情
     */
    @GetMapping("/edit")
    @ResponseBody
    public Confines edit(Model model, String id) {
        return confinesService.selectById(id);
    }


    /**
     * 编辑
     */
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Confines confines) {
        if (confines == null || confines.getSid() == null || confines.getApplyDate() == null || confines.getApplyTime() == null) {
            return JsonData.fail("参数不完整，请检查输入！");
        }
        Map mp = new HashMap();
        mp.put("sid", confines.getSid());
        List<Confines> confinesList = confinesService.queryFilter(mp);
        if (confinesList != null && !confinesList.isEmpty()) {
            for (Confines item : confinesList) {
                if (item.getApplyDate() != null && item.getApplyDate().equals(confines.getApplyDate()) && item.getApplyTime().equals(confines.getApplyTime())) {
                    return JsonData.fail("该场地该时间段已添加，请勿重复添加！");
                }
            }
        }
//        for(int i=0;i<confinesList.size();i++){
//            if(confinesList.get(i).getApplyDate().equals(confines.getApplyDate())){
//                return JsonData.fail("该场地该时间段已添加，请勿重复添加！");
//            }
//        }
        int a = confinesService.updateById(confines);
        if (a > 0) {
            return JsonData.success(null, "编辑成功！");
        } else {
            return JsonData.fail("编辑失败");
        }
    }


    /**
     * 删除
     */
    @PostMapping("/del")
    @ResponseBody
    public JsonData del(String id) {
        try {
            confinesService.deleteById(Integer.parseInt(id));
        } catch (Exception ex) {
            JsonData.fail("出现错误");
        }
        return JsonData.success(null, "删除成功");
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Confines confines) {
//        if (confines == null || confines.getSid() == null || confines.getApplyDate() == null || confines.getApplyTime() == null) {
//            return JsonData.fail("参数不完整，请检查输入！");
//        }
        Map mp = new HashMap();
        mp.put("sid", confines.getSid());
        List<Confines> confinesList = confinesService.queryFilter(mp);
        if (confinesList != null && !confinesList.isEmpty()) {
            for (Confines item : confinesList) {
                if (item.getApplyDate() != null && item.getApplyDate().equals(confines.getApplyDate()) && item.getApplyTime().equals(confines.getApplyTime())) {
                    return JsonData.fail("该场地该时间段已添加，请勿重复添加！");
                }
            }
        }
        Date date = new Date();
        confines.setCreateTime(date);
        int num = confinesService.addByCondition(confines);
        if (num > 0) {
            return JsonData.success(null, "添加成功");
        } else {
            return JsonData.fail("添加失败");
        }
    }
}

//    @PostMapping("/add")
//    public String add(@RequestBody Confines confines) {
//        int num = confinesService.addByCondition(confines);
//        if (num > 0) {
//            return "限制规则添加成功";
//        } else {
//            return "限制规则添加失败";
//        }
//    }

