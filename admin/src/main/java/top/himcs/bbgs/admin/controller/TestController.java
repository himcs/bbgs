package top.himcs.bbgs.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.himcs.bbgs.common.api.CommonResult;
import top.himcs.bbgs.mbg.mapper.SystemAdminMapper;
import top.himcs.bbgs.mbg.model.SystemAdmin;
import top.himcs.bbgs.mbg.model.SystemAdminExample;

import java.util.List;

@RequestMapping("/test")
@RestController
public class TestController {
    @Autowired
    SystemAdminMapper adminMapper;

    @RequestMapping("/admin")
    public CommonResult<SystemAdmin> admin() {
        SystemAdmin systemAdmin = adminMapper.selectByPrimaryKey(1);
        return CommonResult.success(systemAdmin);
    }

    @RequestMapping("/admins")
    public CommonResult<List<SystemAdmin>> two() {
        SystemAdminExample systemAdminExample = new SystemAdminExample();
        byte b = 0;
        systemAdminExample.createCriteria()
                .andIsDelEqualTo(Byte.valueOf(b));
        systemAdminExample.or().andAccountIsNotNull();

        List<SystemAdmin> list = adminMapper.selectByExample(systemAdminExample);
        return CommonResult.success(list);
    }
}
