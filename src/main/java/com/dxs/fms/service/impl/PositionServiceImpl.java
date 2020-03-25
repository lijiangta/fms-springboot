package com.dxs.fms.service.impl;

import com.dxs.fms.dto.PositionDto;
import com.dxs.fms.mapper.PositionMapper;
import com.dxs.fms.service.PositionService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddPositionVo;
import com.dxs.fms.vo.SelectPositionVo;
import com.dxs.fms.vo.UpdatePositionVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:01
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;

    @Override
    public Result1<Integer> add(AddPositionVo addPositionVo) {
        if(addPositionVo == null){
            return new Result1<Integer>(false,-1);
        }
        Integer  result = positionMapper.addPosition(addPositionVo);
        return new Result1<Integer>(true,result);
    }

    @Override
    public Result1<Integer> updateDelByRealName(String realName) {
        if(realName == null){
            return new Result1<>(false,-1);
        }
        return new Result1<>(true,positionMapper.updateDelByRealName(realName));
    }

    @Override
    public Result1<Integer> updateInfo(UpdatePositionVo updatePositionVo) {
        if(updatePositionVo == null || updatePositionVo.getPositionRealName() == null) return new Result1<>(false, -1);
        return new Result1<>(true, positionMapper.updateInfo(updatePositionVo));
    }

    @Override
    public PageUtils<PositionDto> getPageByPageAndLimit(Integer page, Integer limit) {
        if(page == null || limit == null) {
            page = 1;
            limit = 5;
        }
        Integer start = PageUtils.calculateStart(page, limit);
        Integer end = PageUtils.calculateEnd(page, limit);
        List<PositionDto> positionDtoList = positionMapper.getPageByPageAndLimit(start, end);
        Integer total = positionMapper.getAll();
        PageUtils<PositionDto> pageUtils = new PageUtils<>();
        pageUtils.setTotal(total);
        pageUtils.setDate(positionDtoList);
        return pageUtils;
    }

    @Override
    public Result1<PositionDto> get(SelectPositionVo selectPositionVo) {
        if(selectPositionVo == null) return new Result1<>(false, new PositionDto());
        return new Result1<>(true, positionMapper.getPosition(selectPositionVo));
    }
}
