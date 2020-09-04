package top.himcs.bbgs.admin.controller;

import com.alibaba.druid.sql.PagerUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.himcs.bbgs.common.api.CommonResult;
import top.himcs.bbgs.mbg.mapper.SystemAdminMapper;
import top.himcs.bbgs.mbg.model.SystemAdmin;
import top.himcs.bbgs.mbg.model.SystemAdminExample;

import java.util.List;

@RequestMapping("/test")
@RestController
@Api(tags = "测试")
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    SystemAdminMapper adminMapper;

    @GetMapping("/admin")
    public CommonResult<SystemAdmin> admin() {
        SystemAdmin systemAdmin = adminMapper.selectByPrimaryKey(1);
        return CommonResult.success(systemAdmin);
    }

    @GetMapping("/admins")
    public CommonResult<List<SystemAdmin>> two() {
        SystemAdminExample systemAdminExample = new SystemAdminExample();
        byte b = 0;
        systemAdminExample.createCriteria()
                .andIsDelEqualTo(Byte.valueOf(b));
        systemAdminExample.or().andAccountIsNotNull();
        List<SystemAdmin> list = adminMapper.selectByExample(systemAdminExample);
        return CommonResult.success(list);
    }

    @GetMapping("/admins/page")
    public CommonResult<PageInfo<SystemAdmin>> adminsPage(@RequestParam(defaultValue = "1") int p) {
        SystemAdminExample systemAdminExample = new SystemAdminExample();
        systemAdminExample.createCriteria().andAccountIsNotNull();
        PageHelper.startPage(p, 10);
        List<SystemAdmin> list = adminMapper.selectByExample(systemAdminExample);
        PageInfo<SystemAdmin> pageInfo = new PageInfo<>(list);
        return CommonResult.success(pageInfo);
    }
}
