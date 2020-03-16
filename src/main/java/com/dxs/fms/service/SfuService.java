package com.dxs.fms.service;

import com.dxs.fms.dto.FileDto;
import com.dxs.fms.dto.SfuDto;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddFileVo;
import com.dxs.fms.vo.AddSfuVo;
import com.dxs.fms.vo.SelectFileVo;
import com.dxs.fms.vo.SelectSfuVo;
import com.dxs.fms.vo.UpdateFileVo;
import com.dxs.fms.vo.UpdateSfuVo;

import org.springframework.stereotype.Service;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:02
 */
@Service
public interface SfuService {
    Result1<Integer> add(AddSfuVo addSfuVo);

    Result1<Integer> updateDelByRealName(String realName);

    Result1<Integer> updateInfo(UpdateSfuVo updateSfuVo);

    PageUtils<SfuDto> getPageByPageAndLimit(Integer page, Integer limit);

    Result1<SfuDto> get(SelectSfuVo selectSfuVo);
}
