package top.himcs.bbgs.admin.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.himcs.bbgs.admin.dto.SystemAdminParam;
import top.himcs.bbgs.admin.service.SystemAdminService;
import top.himcs.bbgs.common.exception.CommonException;
import top.himcs.bbgs.mbg.mapper.SystemAdminMapper;
import top.himcs.bbgs.mbg.model.SystemAdmin;
import top.himcs.bbgs.mbg.model.SystemAdminExample;

@Service
public class SystemAdminServiceImpl implements SystemAdminService {
    @Autowired
    SystemAdminMapper systemAdminMapper;

    @Override
    public SystemAdmin register(SystemAdminParam systemAdminParam) {
        if (checkHasAccount(systemAdminParam.getAccount())) {
            throw new CommonException("用户已存在");
        }
        SystemAdmin systemAdmin = new SystemAdmin();
        BeanUtils.copyProperties(systemAdminParam, systemAdmin);
        systemAdmin.setStatus(true);
        systemAdmin.setIsDel(Byte.parseByte("0"));
        systemAdminMapper.insert(systemAdmin);
        return systemAdmin;
    }

    /**
     * 检测账号重复
     *
     * @param account
     * @return
     */
    private boolean checkHasAccount(String account) {
        SystemAdminExample systemAdminExample = new SystemAdminExample();
        systemAdminExample.createCriteria().andAccountEqualTo(account);
        long count = systemAdminMapper.countByExample(systemAdminExample);
        System.out.println(count);
        return count > 0;
    }
}
