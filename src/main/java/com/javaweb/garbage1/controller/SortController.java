package com.javaweb.garbage1.controller;


import com.javaweb.garbage1.dto.*;
import com.javaweb.garbage1.entity.FileResult;
import com.javaweb.garbage1.service.SortService;
import com.javaweb.garbage1.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/sort")
public class SortController {

    @Resource
    private SortService sortService;
    private final Logger logger = LoggerFactory.getLogger(SortController.class);

    //获取垃圾数据表的数据
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public TableRsqDTO list4Table(TableReqDTO tableReqDTO) {
        TableRsqDTO tableRsqDTO = new TableRsqDTO();
        try {
            tableRsqDTO = sortService.list4Table(tableReqDTO);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return tableRsqDTO;
    }

    /**
     * @Description: 添加记录
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public OpResultDTO add(GarbageDTO garbageDTO) {
        OpResultDTO opResult = new OpResultDTO();
        try {
            opResult.setIntResult(sortService.add(garbageDTO));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return opResult;
    }

    /**
     * @Description: 编辑记录
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public OpResultDTO update(GarbageDTO garbageDTO) {
        OpResultDTO opResult = new OpResultDTO();
        try {
            opResult.setIntResult(sortService.edit(garbageDTO));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return opResult;
    }

    /**
     * @Description: 删除记录
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public OpResultDTO remove(Integer garbageID) {
        OpResultDTO opResult = new OpResultDTO();
        try {
            opResult.setIntResult(sortService.remove(garbageID));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return opResult;
    }

    /*
     * 上传图片
     * */
    /*@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public FileResult upload(@RequestParam("picture") MultipartFile picture, @RequestParam Integer garbageID) {
        logger.info("garbageID = " + garbageID.toString());
        logger.info("您已进入图片上传服务");
        //获取文件在服务器的储存位置
        String path = "E://JavaProject//garbage1//target//classes//static//GarbagePicture";
        File filePath = new File(path);
        logger.info("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            logger.info("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        logger.info("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        logger.info("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        String fileName = UUIDUtils.getUUID32() + name + "." + type;
        logger.info("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        logger.info("图片地址：" + path + "/" + fileName);
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            logger.info("上传成功");
            //将文件在服务器的存储路径返回
            try {
                sortService.upload("../GarbagePicture/"+fileName, garbageID);
            } catch (Exception e) {
                logger.info(e.toString());
            }
            return new FileResult(true, fileName, path + "/" + fileName);
        } catch (IOException e) {
            logger.info("上传失败");
            e.printStackTrace();
            return new FileResult(false, "上传失败", "");
        }
    }*/
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public FileResult upload(@RequestParam("picture") MultipartFile picture, @RequestParam Integer garbageID) {
        logger.info("garbageID = " + garbageID.toString());
        logger.info("您已进入图片上传服务");
        //获取文件在服务器的储存位置
        //获取jar包所在目录
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        //在jar包所在目录下生成一个upload文件夹用来存储上传的图片
        String path = jarF.getParentFile().toString()+"/GarbagePicture/";
        System.out.println(path);

        File filePath = new File(path);
        logger.info("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            logger.info("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        logger.info("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        logger.info("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        String fileName = UUIDUtils.getUUID32() + name + "." + type;
        logger.info("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        logger.info("图片地址：" + path + "/" + fileName);
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            logger.info("上传成功");
            //将文件在服务器的存储路径返回
            try {
                sortService.upload("../GarbagePicture/"+fileName, garbageID);
            } catch (Exception e) {
                logger.info(e.toString());
            }
            return new FileResult(true, fileName, path + "/" + fileName);
        } catch (IOException e) {
            logger.info("上传失败");
            e.printStackTrace();
            return new FileResult(false, "上传失败", "");
        }
    }
}

