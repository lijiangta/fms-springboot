package com.dxs.fms.service;

import com.dxs.fms.dto.EmployeeDto;
import com.dxs.fms.dto.FileDto;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddEmployeeVo;
import com.dxs.fms.vo.AddFileVo;
import com.dxs.fms.vo.SelectEmployeeVo;
import com.dxs.fms.vo.SelectFileVo;
import com.dxs.fms.vo.UpdateEmployeeVo;
import com.dxs.fms.vo.UpdateFileVo;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:02
 */
@Service
public interface FileService {
    Result1<Integer> add(AddFileVo addFileVo);

    Result1<Integer> updateDelByRealName(String realName);

    Result1<Integer> updateInfo(UpdateFileVo updateFileVo);

    PageUtils<FileDto> getPageByPageAndLimit(Integer page, Integer limit);

    Result1<FileDto> get(SelectFileVo selectFileVo);

    /**
     * 基于真实姓名查询有关的文件信息
     * @param realName 拥有该文件的人的真实姓名
     * @return 返回结果
     */
    Result1<FileDto> listFileByUserRealName(String realName);
}
