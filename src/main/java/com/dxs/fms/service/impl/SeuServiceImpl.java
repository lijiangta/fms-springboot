package com.dxs.fms.service.impl;

import com.dxs.fms.dto.FileDto;
import com.dxs.fms.dto.SeuDto;
import com.dxs.fms.mapper.FileMapper;
import com.dxs.fms.mapper.SeuMapper;
import com.dxs.fms.service.SeuService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddFileVo;
import com.dxs.fms.vo.AddSeoVo;
import com.dxs.fms.vo.SelectFileVo;
import com.dxs.fms.vo.SelectSeoVo;
import com.dxs.fms.vo.UpdateFileVo;
import com.dxs.fms.vo.UpdateSeoVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:02
 */
@Service
public class SeuServiceImpl implements SeuService {
    @Autowired
    private SeuMapper seuMapper;

    @Override
    public Result1<Integer> add(AddSeoVo addSeoVo) {
        if(addSeoVo == null){
            return new Result1<Integer>(false,-1);
        }
        Integer  result = seuMapper.addSeu(addSeoVo);
        return new Result1<Integer>(true,result);
    }

    @Override
    public Result1<Integer> updateDelByRealName(String realName) {
        if(realName == null){
            return new Result1<>(false,-1);
        }
        return new Result1<>(true,seuMapper.updateDelByRealName(realName));
    }

    @Override
    public Result1<Integer> updateInfo(UpdateSeoVo updateSeoVo) {
        //if(updateSeoVo == null || updateSeoVo.getEmpRealName() == null) return new Result1<>(false, -1);
        return new Result1<>(true, seuMapper.updateInfo(updateSeoVo));
    }

    @Override
    public PageUtils<SeuDto> getPageByPageAndLimit(Integer page, Integer limit) {
        if(page == null || limit == null) {
            page = 1;
            limit = 5;
        }
        Integer start = PageUtils.calculateStart(page, limit);
        Integer end = PageUtils.calculateEnd(page, limit);
        List<SeuDto> seuDtoList = seuMapper.getPageByPageAndLimit(start, end);
        Integer total = seuMapper.getAll();
        PageUtils<SeuDto> pageUtils = new PageUtils<>();
        pageUtils.setTotal(total);
        pageUtils.setDate(seuDtoList);
        return pageUtils;
    }

    @Override
    public Result1<SeuDto> get(SelectSeoVo selectSeoVo) {
        if(selectSeoVo == null) return new Result1<>(false, new SeuDto());
        return new Result1<>(true, seuMapper.getSeu(selectSeoVo));
    }
}
