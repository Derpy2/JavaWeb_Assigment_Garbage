package com.javaweb.garbage1.service.Impl;

import com.javaweb.garbage1.dto.GarbageDTO;
import com.javaweb.garbage1.dto.OpResultDTO;
import com.javaweb.garbage1.entity.Garbage;
import com.javaweb.garbage1.mapper.GarbageMapper;
import com.javaweb.garbage1.service.GarbageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class GarbageServiceImpl implements GarbageService {

    @Autowired(required = false)
    private GarbageMapper garbageMapper;

    @Override
    public GarbageDTO getRandomGarbage()throws Exception{
        GarbageDTO garbage = new GarbageDTO();
        Integer totNumber = (Integer) garbageMapper.getTotalCountGarbage();
        Integer id = (int) (Math.random() * totNumber);
        Garbage tmpgarbage = garbageMapper.getAGarbage(id);
        garbage.setGarbageID(tmpgarbage.getGarbageID());
        garbage.setGarbageName(tmpgarbage.getGarbageName());
        garbage.setImageUrl(tmpgarbage.getImageUrl());
        garbage.setSortID(tmpgarbage.getSortID());
        return garbage;
    }

    @Override
    public OpResultDTO getGarbageSort(@RequestParam("garbageID") Integer garbageID)throws Exception{
        OpResultDTO result = new OpResultDTO();
        Garbage tmpgarbage = garbageMapper.getAGarbage(garbageID);
        result.setIntResult(tmpgarbage.getSortID());
        return result;
    }
}
