package com.dxs.fms.controller.company;

import com.dxs.fms.service.CompanyService;
import com.dxs.fms.util.ResponseBody;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddCompanyVo;
import com.dxs.fms.vo.AddCompanyVo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxs
 * @date 2020/3/27 0027 14:27
 */
@RestController
@RequestMapping("api/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addCompany")
    public ResponseBody<Result1<Integer>> addCompany(@RequestBody AddCompanyVo1 addCompanyVo1){
        AddCompanyVo addCompanyVo = new AddCompanyVo();
        addCompanyVo.setCompanyName(addCompanyVo1.getCompanyName());
        addCompanyVo.setCompanyCode(addCompanyVo1.getCompanyCode());
        addCompanyVo.setCreatorId(addCompanyVo1.getCreatorId());

        Result1<Integer> result = companyService.addCompany(addCompanyVo);
        if(result.getData() == -1){
            return new ResponseBody<>("403",result.getError(),"请求失败，请检查有关的数据是否正确");
        }
        return new ResponseBody<>("200","成功",result);

    }
}
