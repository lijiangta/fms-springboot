package com.dxs.fms.sqlprovider;

import com.dxs.fms.vo.AddCompanyVo;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author dxs
 * @date 2020/3/27 0027 14:02
 */
public class CompanySqlProvider {
    public String addCompanySql(AddCompanyVo addCompanyVo){
        return new SQL(){
            {
                INSERT_INTO("dxs_company");
                INTO_COLUMNS("company_name", "company_code", "creator_id", "create_time,del");
                INTO_VALUES("#{companyName}", "#{companyCode}","#{creatorId}","#{createTime}","#{del}");
            }
        }.toString();
    }

    public String getCompanyIdSql(String companyName){
        return new SQL(){
            {
                SELECT("company_id");
                FROM("dxs_company");
                WHERE("company_name = #{companyName}");
            }
        }.toString();
    }
}
