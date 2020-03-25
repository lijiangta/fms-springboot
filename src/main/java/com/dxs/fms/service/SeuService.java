package com.dxs.fms.service;

import com.dxs.fms.dto.FileDto;
import com.dxs.fms.dto.SeuDto;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddFileVo;
import com.dxs.fms.vo.AddSeoVo;
import com.dxs.fms.vo.SelectFileVo;
import com.dxs.fms.vo.SelectSeoVo;
import com.dxs.fms.vo.UpdateFileVo;
import com.dxs.fms.vo.UpdateSeoVo;

import org.springframework.stereotype.Service;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:02
 */
public interface SeuService {
    Result1<Integer> add(AddSeoVo addSeoVo);

    Result1<Integer> updateDelByRealName(String realName);

    Result1<Integer> updateInfo(UpdateSeoVo updateSeoVo);

    PageUtils<SeuDto> getPageByPageAndLimit(Integer page, Integer limit);

    Result1<SeuDto> get(SelectSeoVo selectSeoVo);
}
