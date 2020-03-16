package com.dxs.fms.mapper;
/**
 * @author dxs
 * @date 2020/3/8 0008 18:02
 */

import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.SfuDto;
import com.dxs.fms.sqlprovider.SfuSqlProvider;
import com.dxs.fms.vo.AddSfuVo;
import com.dxs.fms.vo.DeleteSfuVo;
import com.dxs.fms.vo.SelectSfuVo;
import com.dxs.fms.vo.UpdateDepartmentVo;
import com.dxs.fms.vo.UpdateSfuVo;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SfuMapper {
    @InsertProvider(type = SfuSqlProvider.class, method = "addSfu")
    public Integer addSfu(AddSfuVo addSfu);

    @SelectProvider(type = SfuSqlProvider.class, method = "getSfu")
    public SfuDto getSfu(SelectSfuVo selectSfu);

    @UpdateProvider(type = SfuSqlProvider.class, method = "setSfu")
    public Integer setSfu(UpdateSfuVo updateSfu);

    @DeleteProvider(type = SfuSqlProvider.class, method = "delSfu")
    public Integer delSfu(DeleteSfuVo deleteSfu);

    Integer updateDelByRealName(String realName);

    Integer updateInfo(UpdateSfuVo updateSfuVo);

    List<SfuDto> getPageByPageAndLimit(Integer start, Integer end);

    Integer getAll();
}
