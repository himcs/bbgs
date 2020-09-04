package top.himcs.bbgs.admin.service;

import top.himcs.bbgs.mbg.model.SystemAdmin;

/**
 * 后台用户缓存
 */
public interface SystemAdminCacheService {
    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(SystemAdmin admin);

    /**
     * 从缓存中获取后台用户信息
     *
     * @param account
     * @return
     */
    SystemAdmin getAdmin(String account);
}
