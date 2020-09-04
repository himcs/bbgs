package top.himcs.bbgs.admin.service;

import top.himcs.bbgs.admin.dto.SystemAdminParam;
import top.himcs.bbgs.mbg.model.SystemAdmin;

public interface SystemAdminService {
    /**
     * 注册功能
     */
    SystemAdmin register(SystemAdminParam systemAdminParam);

    /**
     * 登陆返回Token
     */
    String login(String account, String pwd);

    SystemAdmin getAdminByAccount(String account);

    SystemAdmin getAdminByToken(String token);
}
