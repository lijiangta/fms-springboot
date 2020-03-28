package com.dxs.fms.service.impl;

import com.dxs.fms.mapper.CompanyMapper;
import com.dxs.fms.service.CompanyService;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddCompanyVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dxs
 * @date 2020/3/27 0027 13:57
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Result1<Integer> addCompany(AddCompanyVo addCompanyVo) {
        if(addCompanyVo == null){
            return new Result1<>(false, -1);
        }
        if(addCompanyVo.getCompanyName() == null || addCompanyVo.getCompanyCode() == null){
            return new Result1<>(false, -1 ,new Error("请保证公司名称或公司代号填写正确"));
        }
        if (addCompanyVo.getCreatorId() == null ){
            return new Result1<>(false, -1 ,new Error("请保证该的操作员id存在"));
        }
        addCompanyVo.setDel(0);
        Integer result = companyMapper.addCompany(addCompanyVo);
        return new Result1<>(true, result);
    }
}
