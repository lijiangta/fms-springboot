package com.dxs.fms.service;

import com.dxs.fms.dto.AddSeuDto;
import com.dxs.fms.dto.SeuDto;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddSeuVo;
import com.dxs.fms.vo.SelectSeoVo;
import com.dxs.fms.vo.UpdateSeoVo;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:02
 */
public interface SeuService {
    Result1<Integer> add(AddSeuVo addSeuVo);

    Result1<Integer> updateDelByRealName(String realName);

    Result1<Integer> updateInfo(UpdateSeoVo updateSeoVo);

    PageUtils<SeuDto> getPageByPageAndLimit(Integer page, Integer limit);

    Result1<SeuDto> get(SelectSeoVo selectSeoVo);
}
