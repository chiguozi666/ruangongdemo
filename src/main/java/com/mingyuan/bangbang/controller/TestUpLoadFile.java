package com.mingyuan.bangbang.controller;

import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.util.FileUtil;
import com.mingyuan.bangbang.util.ResultUtil;
import io.swagger.annotations.ApiModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@ApiModel(value="和订单有关的操作",description="" )
@RequestMapping(value = "/upload")
public class TestUpLoadFile {
    @Value("${web.upload-path}")
    private String path;

    @Resource
    HttpServletRequest request;
    @PostMapping(value = "/test")
    public ResultVo upload(@RequestParam("file") MultipartFile file){


        String fileName=file.getOriginalFilename();
        //2上传失败提示
        String warning=fileName;
        String newFileName = FileUtil.upload(file, path, fileName);
        System.out.println(warning);
        if(newFileName != null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fileName",fileName);
            return ResultUtil.successWithAll("上传成功",jsonObject);

        }else{
            return ResultUtil.errorWithMsg("上传失败");
        }

    }
}
