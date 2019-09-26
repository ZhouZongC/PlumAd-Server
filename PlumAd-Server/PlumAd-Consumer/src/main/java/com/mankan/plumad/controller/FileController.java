package com.mankan.plumad.controller;

import com.mankan.plumad.consumer.PicInfoConsumer;
import com.mankan.plumad.model.PicInfo;
import com.mankan.plumad.util.StringRandom;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.util.JsonResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author: youtiao
 * @create: 2018-12-07 13:34
 * @description:
 **/
@Controller
@RequestMapping("/file")
@Api(tags="文件上传管理",description="文件上传管理")
public class FileController {


    @Value("${plumad.fileUpload.path}")
    private String storePath;

    @Value("${plumad.fileUpload.url}")
    private String storeUrl;

    @Autowired
    private PicInfoConsumer consumer;

    @RequestMapping(value="/",method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="文件上传管理", notes="文件上传管理")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            //存放我们上传的文件路径
            String filestorePath  = storePath;
            String fileName = StringRandom.getRandom(6, StringRandom.TYPE.LETTER_CAPITAL_NUMBER)+"-"+file.getOriginalFilename();
            File filepath = new File(filestorePath, fileName);
            if (!filepath.getParentFile().exists()) {
                //如果目录不存在，创建目录
                filepath.getParentFile().mkdirs();
            }
            try {
                //把文件写入目标文件地址
//                file.transferTo(new File(filestorePath+File.separator+fileName));
//                COSCredentials cred = new BasicCOSCredentials("AKIDztb7ScMS8ZlpihLi19BgI94hEJVvoYff", "CMl4mM0UzOIEEORNHdv6RqF4LFzZyC7s");
//                ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));
//                COSClient cosClient = new COSClient(cred, clientConfig);
//                String bucketName = "isv-1257704269";

//                String key = fileName;
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                String localpath = filestorePath+File.separator+fileName;
                File localFile = new File(localpath);
                file.transferTo(localFile);
                String fileUrl = storeUrl+fileName;
                PicInfo entity = new PicInfo();
                entity.setId(uuid);
                entity.setPicPath(localpath);
                entity.setPicUrl(fileUrl);
                boolean flag = consumer.savePicInfo(entity);
                if(flag) {
//                    PutObjectRequest putObjectRequest = null;
//                    putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
//                    PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
//                    cosClient.shutdown();
                    return JsonResultUtil.toJson(ReturnCode.SUCCESS, entity);
                }else{
                    return JsonResultUtil.toJson(ReturnCode.ERROR, "上传保存失败");
                }
            } catch (Exception e) {
               return JsonResultUtil.toJson(ReturnCode.ERROR, e.toString());
            }
        }else {
            return JsonResultUtil.toJson(ReturnCode.ERROR, "上次文件不存在");
        }

    }
}
