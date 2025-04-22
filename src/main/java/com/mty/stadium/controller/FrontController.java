package com.mty.stadium.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mty.stadium.model.Equips;
import com.mty.stadium.model.Notice;
import com.mty.stadium.model.Sites;
import com.mty.stadium.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/front")
public class FrontController {

    @Autowired
    private SitesService sitesService;
    @Autowired
    private UserService userService;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private EquipsService equipsService;
    @Autowired
    private NoticeService noticeService;

    //首页
    @GetMapping("/")
    public String userIframe(Model model){
        Map mp = new HashMap<>();
        mp.put("limit","1");
        List<Sites> sitesList = sitesService.queryFilter(mp);
        List<Equips> equipsList = equipsService.queryFilter(mp);
        List<Notice> noticeList = noticeService.queryFilter(mp);
        model.addAttribute("sitesList",sitesList);
        model.addAttribute("equipsList",equipsList);
        model.addAttribute("noticeList",noticeList);
        return "show";
    }


    //通知公告
    @GetMapping("/notice")
    public String notice(Model model, String searchName, Integer pageNum, Integer pageSize){
        Map mp = new HashMap<>();
        mp.put("name",searchName);
        //mp.put("status","01");
        if(pageNum==null){
            pageNum =1;
        }
        if(pageSize==null){
            pageSize =8;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Notice> noticeList = noticeService.queryFilter(mp);
        PageInfo<Notice> notice = new PageInfo<>(noticeList);
        model.addAttribute("notice",notice);
        model.addAttribute("searchName",searchName);
        return "notice";
    }

    //通知公告详情
    @GetMapping("/noticeDetail")
    public String noticeDetail(String id, Model model){
        Notice notice = noticeService.selectById(id);
        model.addAttribute("id",id);
        model.addAttribute("notice",notice);
        return "noticeDetail";
    }



    //场地
    @GetMapping("/site")
    public String site(Model model, String searchName, Integer pageNum, Integer pageSize){
        Map mp = new HashMap<>();
        mp.put("name",searchName);
        //mp.put("status","01");
        if(pageNum==null){
            pageNum =1;
        }
        if(pageSize==null){
            pageSize =8;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Sites> sitesList = sitesService.queryFilter(mp);
        PageInfo<Sites> sites = new PageInfo<>(sitesList);
        model.addAttribute("sites",sites);
        model.addAttribute("searchName",searchName);
        return "site";
    }

    //场地详情
    @GetMapping("/siteDetail")
    public String studyDetail(String id, Model model){
        Sites sites = sitesService.selectById(id);
        model.addAttribute("id",id);
        model.addAttribute("site",sites);
        return "siteDetail";
    }

    //器材
    @GetMapping("/equip")
    public String equip(Model model, String searchName, Integer pageNum, Integer pageSize){
        Map mp = new HashMap<>();
        mp.put("name",searchName);
        mp.put("status","01");
        if(pageNum==null){
            pageNum =1;
        }
        if(pageSize==null){
            pageSize =8;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Equips> equipsList = equipsService.queryFilter(mp);
        PageInfo<Equips> equips = new PageInfo<>(equipsList);
        model.addAttribute("equips",equips);
        model.addAttribute("searchName",searchName);
        return "equip";
    }


    //器材详情
    @GetMapping("/equipDetail")
    public String equipDetail(String id, Model model){
        Equips equips = equipsService.selectById(id);
        model.addAttribute("id",id);
        model.addAttribute("equips",equips);
        return "equipDetail";
    }



    /**
     * 提取富文本中纯文本
     */
    public static String getText(String richText) {
        String regx = "(<.+?>)|(</.+?>)";
        Matcher matcher = Pattern.compile(regx).matcher(richText);
        while (matcher.find()) {
            // 替换图片
            richText = matcher.replaceAll("").replace(" ", "");
        }
        return richText;
    }


    //实现日期加一天的方法
    public static String addDay(String s, int n) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(s));
            cd.add(Calendar.DATE, n);//增加一天
            //cd.add(Calendar.MONTH, n);//增加一个月
            return sdf.format(cd.getTime());
        } catch (Exception e) {
            return null;
        }
    }
}
