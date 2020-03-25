package com.dxs.fms.service;

import com.dxs.fms.dto.PositionDto;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddPositionVo;
import com.dxs.fms.vo.SelectPositionVo;
import com.dxs.fms.vo.UpdatePositionVo;

import org.springframework.stereotype.Service;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:01
 */
public interface PositionService {
    Result1<Integer> add(AddPositionVo addPositionVo);

    Result1<Integer> updateDelByRealName(String realName);

    Result1<Integer> updateInfo(UpdatePositionVo updatePositionVo);

    PageUtils<PositionDto> getPageByPageAndLimit(Integer page, Integer limit);

    Result1<PositionDto> get(SelectPositionVo selectPositionVo);
}
