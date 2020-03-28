package com.dxs.fms.service;

import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddCompanyVo;

/**
 * @author dxs
 * @date 2020/3/27 0027 13:52
 */
public interface CompanyService {
    Result1<Integer> addCompany(AddCompanyVo addCompanyVo);
}
