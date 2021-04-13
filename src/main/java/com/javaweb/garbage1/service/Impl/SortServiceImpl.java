package com.javaweb.garbage1.service.Impl;

import com.javaweb.garbage1.dto.GarbageDTO;
import com.javaweb.garbage1.dto.SortDTO;
import com.javaweb.garbage1.dto.TableReqDTO;
import com.javaweb.garbage1.dto.TableRsqDTO;
import com.javaweb.garbage1.entity.GarbageEntity;
import com.javaweb.garbage1.entity.SortEntity;
import com.javaweb.garbage1.mapper.SortMapper;
import com.javaweb.garbage1.service.SortService;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SortServiceImpl implements SortService {

    @Autowired(required = false)
    private SortMapper sortMapper;

    @Override
    public TableRsqDTO list4Table(TableReqDTO tableReqDTO) throws Exception {
        Integer count = sortMapper.count4Table(tableReqDTO.getQueryText());
        List<GarbageDTO> listSortDTOs = sortMapper.list4Table(tableReqDTO.getStart(),
                tableReqDTO.getPageSize(), tableReqDTO.getQueryText());
        return new TableRsqDTO(count, listSortDTOs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer add(GarbageDTO garbageDTO) throws Exception {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        GarbageEntity garbageEntity = mapperFactory.getMapperFacade().map(garbageDTO, GarbageEntity.class);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy kk:mm:ss");
        garbageEntity.setcreateTime(sdf.format(d));
        return sortMapper.add(garbageEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer edit(GarbageDTO garbageDTO) throws Exception {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        GarbageEntity garbageEntity = mapperFactory.getMapperFacade().map(garbageDTO, GarbageEntity.class);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy kk:mm:ss");
        garbageEntity.setcreateTime(sdf.format(d));
//        System.out.println(garbageEntity.toString());
        return sortMapper.edit(garbageEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer remove(Integer garbageID) throws Exception {
        return sortMapper.remove(garbageID);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer upload(String garbageUrl, Integer garbageID) throws Exception {
        return sortMapper.upload(garbageUrl, garbageID);
    }
}
