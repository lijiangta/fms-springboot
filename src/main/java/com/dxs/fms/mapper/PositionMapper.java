package com.dxs.fms.mapper;
/**
 * @author dxs
 * @date 2020/3/8 0008 17:47
 */

import com.dxs.fms.dto.AddPositionDto;
import com.dxs.fms.dto.PositionDto;
import com.dxs.fms.dto.SelectPositionDto;
import com.dxs.fms.sqlprovider.DepartmentSqlProvider;
import com.dxs.fms.sqlprovider.PositionSqlProvider;
import com.dxs.fms.vo.AddPositionVo;
import com.dxs.fms.vo.DeletePostionVo;
import com.dxs.fms.vo.SelectPositionVo;
import com.dxs.fms.vo.UpdatePositionVo;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PositionMapper {
    @InsertProvider(type = PositionSqlProvider.class, method = "addPositionSql")
    @Results(id = "AddPositionDto", value = {
            @Result(column = "company_id", property = "companyId"),
            @Result(column = "position_realname", property = "positionRealName"),
            @Result(column = "position_nickname", property = "positionNickname"),
            @Result(column = "position_code", property = "positionCode"),
            @Result(column = "creator_id", property = "creatorId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "del", property = "del"),
    })
    Integer addPosition(AddPositionDto addPositionDto);

    @SelectProvider(type = PositionSqlProvider.class, method = "getPosition")
    PositionDto getPosition(SelectPositionVo selectPositionVo);

    @UpdateProvider(type = PositionSqlProvider.class, method = "setPosition")
    Integer setPosition(UpdatePositionVo updatePostionVo);

    @DeleteProvider(type = PositionSqlProvider.class, method = "delPosition")
    Integer delPosition(DeletePostionVo deletePostionVo);

    Integer updateDelByRealName(String realName);

    Integer updateInfo(UpdatePositionVo updatePostionVo);

    List<PositionDto> getPageByPageAndLimit(Integer start, Integer end);

    Integer getAll();

    @SelectProvider(type = DepartmentSqlProvider.class, method = "getPositionIdSql")
    @Results(id = "SelectPositionDto", value = {
            @Result(column = "position_id",property = "positionId"),
    })
    SelectPositionDto getPositionId(Integer companyId, String positionName);
}
