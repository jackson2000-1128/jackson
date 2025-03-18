package com.mty.stadium.controller;

import com.mty.stadium.model.Equips;
import com.mty.stadium.model.Leases;
import com.mty.stadium.model.User;
import com.mty.stadium.service.EquipsService;
import com.mty.stadium.service.LeasesService;
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
import java.util.List;

/**
 * @description: 控制层
 * @author: mty
 */
@Controller
@RequestMapping(value = "/leases")
public class LeasesController {


    // 依赖注入
    @Autowired
    private LeasesService leasesService;
    @Autowired
    private EquipsService equipsService;

    /**进入列表页面*/
    @GetMapping("/leases")
    public String userIframe(){
        return "LeasesList";
    }

    /**列表数据*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findLeases(Leases leases, Integer limit, Integer page, HttpSession session){
        String type = (String)session.getAttribute("type");
        if(type!=null && !type.equals("01")){
            User user =  (User)session.getAttribute("userInfo");
            leases.setUid(user.getId().toString());
        }
        PageHelper.startPage(page,limit);
        List<Leases> leasesList = leasesService.selectByCondition(leases);
        PageInfo<Leases> pages = new PageInfo<>(leasesList);
        return JsonData.table(leasesList,pages.getTotal());
    }


    /**编辑详情*/
    @GetMapping("/edit")
    @ResponseBody
    public Leases edit(Model model, String id){
        return leasesService.selectById(id);
    }


    /**编辑*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Leases leases){
        int a = leasesService.updateById(leases);
        if (a > 0) {
          return JsonData.success(null,"编辑成功！");
        } else {
          return JsonData.fail("编辑失败");
        }
    }


    /**归还*/
    @PostMapping("/guihuan")
    @ResponseBody
    public JsonData guihuan(Leases leases){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date);
        leases.setReturnDate(time);
        leases.setStatus("02");
        int a = leasesService.updateById(leases);
        if (a > 0) {
            Equips equips = equipsService.selectById(leases.getEid());
            Equips equips1 = new Equips();
            equips1.setId(equips.getId());
            equips1.setNum(equips.getNum()+leases.getGnum());
            equipsService.updateById(equips1);
            return JsonData.success(null,"归还成功！");
        } else {
            return JsonData.fail("归还失败");
        }
    }


    /**删除*/
    @PostMapping("/del")
    @ResponseBody
    public JsonData del(String id){
        try{
          leasesService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("出现错误");
        }
        return JsonData.success(null,"删除成功");
    }

    /**新增*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Leases leases, HttpSession session){
        String type = (String)session.getAttribute("type");
        if(type!=null && !type.equals("01")){
            User user =  (User)session.getAttribute("userInfo");
            leases.setUid(user.getId().toString());
        }
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date);
        leases.setLendDate(time);
        leases.setCreateTime(date);
        leases.setStatus("01");
        int num = leasesService.addByCondition(leases);
        if(num > 0){
            Equips equips = equipsService.selectById(leases.getEid());
            Equips equips1 = new Equips();
            equips1.setId(equips.getId());
            equips1.setNum(equips.getNum()-leases.getNum());
            equipsService.updateById(equips1);
            return JsonData.success(null,"租借成功");
        }else {
          return JsonData.fail("租借失败");
        }
    }

}
