package com.javaweb.garbage1.controller;

import com.javaweb.garbage1.dto.GarbageDTO;
import com.javaweb.garbage1.dto.OpResultDTO;

import com.javaweb.garbage1.service.GarbageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


@RestController
@RequestMapping("garbage")
public class GarbageController {

    @Resource
    private GarbageService garbageService;
    private final Logger logger = LoggerFactory.getLogger(GarbageController.class);


    /**
     * 获得一个随机垃圾
     */
    @RequestMapping("getRandomGarbage")
    public GarbageDTO getRandomGarbage(){
        GarbageDTO garbage = new GarbageDTO();
        try{
            garbage = garbageService.getRandomGarbage();
        }catch (Exception e){
            logger.error(e.toString());
        }
        return garbage;
    }

    /**
     * 根据垃圾ID获得指定垃圾的类别
     * @param garbageID 垃圾ID
     * @return
     */
    @RequestMapping("getGarbageSort")
    public OpResultDTO getGarbageSort(@RequestParam("garbageID") Integer garbageID){
        OpResultDTO result = null;
        try{
            result = garbageService.getGarbageSort(garbageID);
        }catch (Exception e){
            logger.error(e.toString());
        }
        return result;
    }
}
