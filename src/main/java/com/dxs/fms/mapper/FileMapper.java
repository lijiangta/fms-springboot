package com.dxs.fms.mapper;
/**
 * @author dxs
 * @date 2020/3/8 0008 17:54
 */

import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.FileDto;
import com.dxs.fms.sqlprovider.FileSqlProvider;
import com.dxs.fms.vo.AddFileVo;
import com.dxs.fms.vo.DeleteFileVo;
import com.dxs.fms.vo.SelectFileVo;
import com.dxs.fms.vo.UpdateDepartmentVo;
import com.dxs.fms.vo.UpdateFileVo;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FileMapper {
    @InsertProvider(type = FileSqlProvider.class, method = "addFile")
    public Integer addFile(AddFileVo addFile);

    @SelectProvider(type = FileSqlProvider.class, method = "getFile")
    public FileDto getFile(SelectFileVo selectFile);

    @UpdateProvider(type = FileSqlProvider.class, method = "setFile")
    public Integer setFile(UpdateFileVo updateFileVo);

    @DeleteProvider(type = FileSqlProvider.class, method = "delFile")
    public Integer delFile(DeleteFileVo deleteFile);

    Integer updateDelByRealName(String realName);

    Integer updateInfo(UpdateFileVo updateFileVo);

    List<FileDto> getPageByPageAndLimit(Integer start, Integer end);

    Integer getAll();
}
