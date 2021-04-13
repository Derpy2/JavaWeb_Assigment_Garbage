package com.javaweb.garbage1.service;


import com.javaweb.garbage1.dto.GarbageDTO;
import com.javaweb.garbage1.dto.OpResultDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface GarbageService {


    /**
     * 获得一个随机垃圾
     */
    GarbageDTO getRandomGarbage()throws Exception;

    /**
     * 根据垃圾ID获得指定垃圾的类别
     */
    OpResultDTO getGarbageSort(@RequestParam("garbageID") Integer garbageID)throws Exception;
}
