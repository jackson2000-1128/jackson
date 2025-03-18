package com.mty.stadium.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping(value = "/file")
public class FileController {

    @Value("${server.port}")
    private String port;
    @Value("${uploadDir}")
    private String uploadDir;


    /**
     * 文件上传
     * @param dropFile
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/avatar", method = RequestMethod.POST)
    public Map<String, Object> acticleAvatar(MultipartFile dropFile, HttpServletRequest request) throws IOException {
        Map<String, Object> result = new HashMap<>();
        //获取文件后缀
        String fileName = dropFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));
        //文件存放路径
        String fileDirPath = new String(uploadDir);
        File fileDir = new File(fileDirPath);
        //判断文件是否存在
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }
        File file = new File(fileDir.getAbsolutePath()+ File.separator+ UUID.randomUUID() + fileSuffix);
        try {
            dropFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //传到前端
        result.put("fileName", "http://localhost:"+port+"/upload/"+file.getName());
        return result;
    }


    /**
     * 后台内容图片上传
     * @param dropFile
     * @param request
     * @return
     */
    @RequestMapping(value = "/ContentUpload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> hotelContentUpload(MultipartFile dropFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        //获取文件后缀
        String fileName = dropFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));
        //文件存放路径
        String fileDirPath = new String(uploadDir);
        File fileDir = new File(fileDirPath);
        //判断文件是否存在
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }
        File file = new File(fileDir.getAbsolutePath()+ File.separator+ UUID.randomUUID() + fileSuffix);
        try {
            dropFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //传到前端
        result.put("errno",0);
        result.put("data",new String[] {"http://localhost:"+port+"/upload/" + file.getName()});
        return result;
    }


}
