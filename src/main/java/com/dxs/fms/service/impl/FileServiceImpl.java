package com.dxs.fms.service.impl;

import com.dxs.fms.dto.EmployeeDto;
import com.dxs.fms.dto.FileDto;
import com.dxs.fms.mapper.EmployeeMapper;
import com.dxs.fms.mapper.FileMapper;
import com.dxs.fms.service.FileService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddEmployeeVo;
import com.dxs.fms.vo.AddFileVo;
import com.dxs.fms.vo.SelectEmployeeVo;
import com.dxs.fms.vo.SelectFileVo;
import com.dxs.fms.vo.UpdateEmployeeVo;
import com.dxs.fms.vo.UpdateFileVo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:02
 */
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public Result1<Integer> add(AddFileVo addFileVo) {
        if(addFileVo == null){
            return new Result1<Integer>(false,-1);
        }
        Integer  result = fileMapper.addFile(addFileVo);
        return new Result1<Integer>(true,result);
    }

    @Override
    public Result1<Integer> updateDelByRealName(String realName) {
        if(realName == null){
            return new Result1<>(false,-1);
        }
        return new Result1<>(true,fileMapper.updateDelByRealName(realName));
    }

    @Override
    public Result1<Integer> updateInfo(UpdateFileVo updateFileVo) {
        if(updateFileVo == null || updateFileVo.getFilename() == null) return new Result1<>(false, -1);
        return new Result1<>(true, fileMapper.updateInfo(updateFileVo));
    }

    @Override
    public PageUtils<FileDto> getPageByPageAndLimit(Integer page, Integer limit) {
        if(page == null || limit == null) {
            page = 1;
            limit = 5;
        }
        Integer start = PageUtils.calculateStart(page, limit);
        Integer end = PageUtils.calculateEnd(page, limit);
        List<FileDto> fileDtoList = fileMapper.getPageByPageAndLimit(start, end);
        Integer total = fileMapper.getAll();
        PageUtils<FileDto> pageUtils = new PageUtils<>();
        pageUtils.setTotal(total);
        pageUtils.setDate(fileDtoList);
        return pageUtils;
    }

    @Override
    public Result1<FileDto> get(SelectFileVo selectFileVo) {
        if(selectFileVo == null) return new Result1<>(false, new FileDto());
        return new Result1<>(true, fileMapper.getFile(selectFileVo));
    }
}
