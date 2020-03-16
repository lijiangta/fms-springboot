package com.dxs.fms.mapper;
/**
 * @author dxs
 * @date 2020/3/8 0008 17:47
 */

import com.dxs.fms.dto.PositionDto;
import com.dxs.fms.sqlprovider.PositionSqlProvider;
import com.dxs.fms.vo.AddPositionVo;
import com.dxs.fms.vo.DeletePostionVo;
import com.dxs.fms.vo.SelectPositionVo;
import com.dxs.fms.vo.UpdatePositionVo;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PositionMapper {
    @InsertProvider(type = PositionSqlProvider.class, method = "addPosition")
    public Integer addPosition(AddPositionVo addPositionVo);

    @SelectProvider(type = PositionSqlProvider.class, method = "getPosition")
    public PositionDto getPosition(SelectPositionVo selectPositionVo);

    @UpdateProvider(type = PositionSqlProvider.class, method = "setPosition")
    public Integer setPosition(UpdatePositionVo updatePostionVo);

    @DeleteProvider(type = PositionSqlProvider.class, method = "delPosition")
    public Integer delPosition(DeletePostionVo deletePostionVo);

    Integer updateDelByRealName(String realName);

    Integer updateInfo(UpdatePositionVo updatePostionVo);

    List<PositionDto> getPageByPageAndLimit(Integer start, Integer end);

    Integer getAll();
}
