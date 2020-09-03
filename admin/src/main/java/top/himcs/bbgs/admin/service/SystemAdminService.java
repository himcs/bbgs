package top.himcs.bbgs.admin.service;

import top.himcs.bbgs.admin.dto.SystemAdminParam;
import top.himcs.bbgs.mbg.model.SystemAdmin;

public interface SystemAdminService {
    /**
     * 注册功能
     */
    SystemAdmin register(SystemAdminParam systemAdminParam);
}
