package com.dxs.fms.mapper;

import com.dxs.fms.dto.SelectCompanyDto;
import com.dxs.fms.sqlprovider.CompanySqlProvider;
import com.dxs.fms.vo.AddCompanyVo;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

/**
 * @author dxs
 * @date 2020/3/27 0027 13:58
 */
@Mapper
@Repository
public interface CompanyMapper {
    @InsertProvider(type = CompanySqlProvider.class, method = "addCompanySql")
    @Results(id = "AddCompanyVo", value = {
            @Result(column = "company_name", property = "companyName"),
            @Result(column = "company_code", property = "companyCode"),
            @Result(column = "creator_id", property = "creatorId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "del", property = "del"),
    })
    Integer addCompany(AddCompanyVo addCompanyVo);

    @SelectProvider(type = CompanySqlProvider.class, method = "getCompanyIdSql")
    @Results(id = "SelectCompanyDto", value = {
            @Result(column = "company_id", property = "companyId"),
    })
    SelectCompanyDto getCompanyId(String companyName);
}
