package com.dxs.fms.service.impl;

import com.dxs.fms.dto.FileDto;
import com.dxs.fms.dto.SfuDto;
import com.dxs.fms.mapper.FileMapper;
import com.dxs.fms.mapper.SfuMapper;
import com.dxs.fms.service.SfuService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddFileVo;
import com.dxs.fms.vo.AddSfuVo;
import com.dxs.fms.vo.SelectFileVo;
import com.dxs.fms.vo.SelectSfuVo;
import com.dxs.fms.vo.UpdateFileVo;
import com.dxs.fms.vo.UpdateSfuVo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:03
 */
public class SfuServiceImpl implements SfuService {
    @Autowired
    private SfuMapper sfuMapper;

    @Override
    public Result1<Integer> add(AddSfuVo addSfuVo) {
        if(addSfuVo == null){
            return new Result1<Integer>(false,-1);
        }
        Integer  result = sfuMapper.addSfu(addSfuVo);
        return new Result1<Integer>(true,result);
    }

    @Override
    public Result1<Integer> updateDelByRealName(String realName) {
        if(realName == null){
            return new Result1<>(false,-1);
        }
        return new Result1<>(true,sfuMapper.updateDelByRealName(realName));
    }

    @Override
    public Result1<Integer> updateInfo(UpdateSfuVo updateSfuVo) {
        if(updateSfuVo == null || updateSfuVo.getEmpRealName() == null) return new Result1<>(false, -1);
        return new Result1<>(true, sfuMapper.updateInfo(updateSfuVo));
    }

    @Override
    public PageUtils<SfuDto> getPageByPageAndLimit(Integer page, Integer limit) {
        if(page == null || limit == null) {
            page = 1;
            limit = 5;
        }
        Integer start = PageUtils.calculateStart(page, limit);
        Integer end = PageUtils.calculateEnd(page, limit);
        List<SfuDto> sfuDtoList = sfuMapper.getPageByPageAndLimit(start, end);
        Integer total = sfuMapper.getAll();
        PageUtils<SfuDto> pageUtils = new PageUtils<>();
        pageUtils.setTotal(total);
        pageUtils.setDate(sfuDtoList);
        return pageUtils;
    }

    @Override
    public Result1<SfuDto> get(SelectSfuVo selectSfuVo) {
        if(selectSfuVo == null) return new Result1<>(false, new SfuDto());
        return new Result1<>(true, sfuMapper.getSfu(selectSfuVo));
    }
}
