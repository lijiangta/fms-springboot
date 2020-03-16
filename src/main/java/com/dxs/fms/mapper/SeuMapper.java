package com.dxs.fms.mapper;
/**
 * @author dxs
 * @date 2020/3/8 0008 18:05
 */

import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.SeuDto;
import com.dxs.fms.sqlprovider.SeuSqlProvider;
import com.dxs.fms.vo.AddSeoVo;
import com.dxs.fms.vo.DeleteSeoVo;
import com.dxs.fms.vo.SelectSeoVo;
import com.dxs.fms.vo.UpdateDepartmentVo;
import com.dxs.fms.vo.UpdateSeoVo;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SeuMapper {
    @InsertProvider(type = SeuSqlProvider.class, method = "addSeu")
    public Integer addSeu(AddSeoVo addSeo);

    @SelectProvider(type = SeuSqlProvider.class, method = "getSeu")
    public SeuDto getSeu(SelectSeoVo selectSeo);

    @UpdateProvider(type = SeuSqlProvider.class, method = "setSeu")
    public Integer setSeu(UpdateSeoVo updateSeo);

    @DeleteProvider(type = SeuSqlProvider.class, method = "delSeu")
    public Integer delSeu(DeleteSeoVo deleteSeo);

    Integer updateDelByRealName(String realName);

    Integer updateInfo(UpdateSeoVo updateSeoVo);

    List<SeuDto> getPageByPageAndLimit(Integer start, Integer end);

    Integer getAll();
}
