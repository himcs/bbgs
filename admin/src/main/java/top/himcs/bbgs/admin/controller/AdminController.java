package top.himcs.bbgs.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.himcs.bbgs.admin.dto.SystemAdminParam;
import top.himcs.bbgs.admin.dto.TokenParam;
import top.himcs.bbgs.admin.service.SystemAdminService;
import top.himcs.bbgs.common.api.CommonResult;
import top.himcs.bbgs.mbg.model.SystemAdmin;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "后台用户管理")
@RestController
@RequestMapping("/admin")
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
        return CommonResult.success(systemAdmin);
    }

    /**
     * 用户登陆
     */
    @ApiOperation("登陆")
    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody SystemAdminParam systemAdminParam) {
        String token = adminService.login(systemAdminParam.getAccount(), systemAdminParam.getPwd());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return CommonResult.success(tokenMap);
    }


    /**
     * 用户退出
     */
    @PostMapping("/logout")
    public void logout() {

    }

    /**
     * 用户信息
     */
    @PostMapping("/info")
    public CommonResult info(@Validated @RequestBody TokenParam tokenParam) {
        SystemAdmin systemAdmin = adminService.getAdminByToken(tokenParam.getToken());
        return CommonResult.success(systemAdmin);
    }
}
