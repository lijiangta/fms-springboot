package com.dxs.fms.mapper;

import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.UserDto;
import com.dxs.fms.sqlprovider.DepartmentSqlProvider;
import com.dxs.fms.vo.AddDepartmentVo;
import com.dxs.fms.vo.DeleteDepartmentVo;
import com.dxs.fms.vo.SelectDepartmentVo;
import com.dxs.fms.vo.UpdateDepartmentVo;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/8 0008 17:20
 */
@Mapper
@Repository
public interface DepartmentMapper {
    /**
     * 添加部门
     * @param departmentVo 前端传给后端的部门对象
     * @return 返回处理结果
     */
    @InsertProvider(type = DepartmentSqlProvider.class, method = "addDepartment")
    @Results(id = "AddDepartmentVo", value = {
            @Result(column = "dept_realname", property = "deptRealName"),
            @Result(column = "dept_nickname", property = "deptNickname"),
            @Result(column = "dept_code", property = "deptCode"),
            @Result(column = "dept_manager_id", property = "deptManagerId")
    })
    Integer addDepartment(AddDepartmentVo departmentVo);

    /**
     * 查询部门
     * @param selectDepartmentVo 前端传给后端的部门对象
     * @return 返回处理结果
     */
    @SelectProvider(type = DepartmentSqlProvider.class, method = "getDepartmentSql")
    @Results(id = "DepartmentDto", value = {
            @Result(column = "dept_realname", property = "deptRealName"),
            @Result(column = "dept_nickname", property = "deptNickname"),
            @Result(column = "dept_manager_name", property = "deptManagerName"),
            @Result(column = "dept_manager_id", property = "deptManagerId")
    })
    DepartmentDto getDepartment(SelectDepartmentVo selectDepartmentVo);


    /**
     * 更新部门信息
     * @param updateDepartmentVo 前端传给后端的部门对象
     * @return 返回处理结果
     */
    @UpdateProvider(type = DepartmentSqlProvider.class, method = "setDepartment")
    @Results(id = "UpdateDepartmentVo", value = {
            @Result(column = "dept_manager_id", property = "deptManagerId")
    })
    Integer setDepartment(UpdateDepartmentVo updateDepartmentVo);

    /**
     * 删除部门
     * @param deleteDepartmentVo 前端传给后端的部门对象
     * @return 返回处理结果
     */
    @DeleteProvider(type = DepartmentSqlProvider.class, method = "delDepartment")
    @Results(id = "DeleteDepartmentVo", value = {
            @Result(column = "dept_id", property = "deptId"),
    })
    Integer delDepartment(DeleteDepartmentVo deleteDepartmentVo);

    @UpdateProvider(type = DepartmentSqlProvider.class, method = "updateDelByRealNameSql")
    Integer updateDelByRealName(String realName);

    @UpdateProvider(type = DepartmentSqlProvider.class, method = "updateInfoSql")
    @Results(id = "UpdateDepartmentVo", value = {
            @Result(column = "dept_name", property = "deptName"),
            @Result(column = "dept_code", property = "deptCode"),
            @Result(column = "dept_nickname", property = "deptNickname"),
            @Result(column = "dept_manager_id", property = "deptManagerId"),
    })
    Integer updateInfo(UpdateDepartmentVo updateDepartmentVo);

    @SelectProvider(type = DepartmentSqlProvider.class, method = "getPageByPageAndLimitSql")
    List<DepartmentDto> getPageByPageAndLimit(Integer start, Integer end);

    @SelectProvider(type = DepartmentSqlProvider.class, method = "getAllSql")
    Integer getAll();
}
