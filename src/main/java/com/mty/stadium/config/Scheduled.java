package com.mty.stadium.config;

import com.mty.stadium.model.Apply;
import com.mty.stadium.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 定时任务
 * @author: mtycode
 * @create: 2023-04-25
 **/
@Configuration
public class Scheduled {

    @Autowired
    private ApplyService applyService;

    /**
     * @Scheduled() 注解开启一个定时任务，当前方法在设定时间自动触发
     * 属性:
     * 1.fixedRate 表示任务执行之间的时间间隔，具体是指两次任务的开始时间间隔，即第二次任务开始时，第一次任务可能还没结束。单位是毫秒
     *2.fixedDelay 表示任务执行之间的时间间隔，具体是指本次任务结束到下次任务开始之间的时间间隔。单位是毫秒
     * 3.initialDelay 表示首次任务启动的延迟时间。单位是毫秒
     * 4.cron 表达式，使用 cron 表达式，可以非常丰富的描述定时任务的时间。
     */
    //每天凌晨一点执行，将当前日期之前所有的预约信息全部置为过期状态0 0 1 * * ?
    @org.springframework.scheduling.annotation.Scheduled(cron = "0 37 11 * * ?")
    public void scheduled(){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Map mp = new HashMap();
        mp.put("dingshi",sf.format(date));
        List<Apply> applies = applyService.queryFilter(mp);
        if(applies.size()>0){
            for(int i=0;i<applies.size();i++){
                //更新预约信息表状态为过期
                Apply apply = new Apply();
                apply.setId(applies.get(i).getId());
                apply.setStatus("03");
                System.out.println("执行时间---"+sf.format(date));
                applyService.updateById(apply);
            }
        }
    }

}
