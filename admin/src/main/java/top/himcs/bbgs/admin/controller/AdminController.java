package top.himcs.bbgs.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.himcs.bbgs.admin.service.SystemAdminService;
import top.himcs.bbgs.common.CommonResult;
import top.himcs.bbgs.mbg.model.SystemAdmin;

@Api(tags = "AdminController", description = "商品品牌管理")
@RestController
public class AdminController {

    @Autowired
    SystemAdminService adminService;

    /**
     * 用户注册
     */
    @ApiOperation("注册")
    @PostMapping("/register")
    public CommonResult<SystemAdmin> register() {
        SystemAdmin systemAdmin = new SystemAdmin();
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
