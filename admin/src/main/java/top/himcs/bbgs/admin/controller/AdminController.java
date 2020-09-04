package top.himcs.bbgs.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.himcs.bbgs.admin.dto.SystemAdminParam;
import top.himcs.bbgs.admin.service.SystemAdminService;
import top.himcs.bbgs.common.api.CommonResult;
import top.himcs.bbgs.mbg.model.SystemAdmin;

@Api(tags = "后台用户管理")
@RestController
public class AdminController {

    @Autowired
    SystemAdminService adminService;

    /**
     * 用户注册
     */
    @ApiOperation("注册")
    @PostMapping("/register")
    public CommonResult<SystemAdmin> register(@Validated @RequestBody SystemAdminParam systemAdminParam) {
        SystemAdmin systemAdmin = adminService.register(systemAdminParam);
        if (systemAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(systemAdmin);
    }

    /**
     * 用户登陆
     */
    @PostMapping("/login")
    public void login() {

    }


    /**
     * 用户退出
     */
    @PostMapping("/logout")
    public void logout() {

    }
}
