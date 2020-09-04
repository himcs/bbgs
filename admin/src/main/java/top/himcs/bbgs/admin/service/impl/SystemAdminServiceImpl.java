package top.himcs.bbgs.admin.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.himcs.bbgs.admin.dto.SystemAdminParam;
import top.himcs.bbgs.admin.service.SystemAdminCacheService;
import top.himcs.bbgs.admin.service.SystemAdminService;
import top.himcs.bbgs.admin.util.JwtTokenUtil;
import top.himcs.bbgs.common.exception.CommonException;
import top.himcs.bbgs.mbg.mapper.SystemAdminMapper;
import top.himcs.bbgs.mbg.model.SystemAdmin;
import top.himcs.bbgs.mbg.model.SystemAdminExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemAdminServiceImpl implements SystemAdminService {
    @Autowired
    SystemAdminMapper systemAdminMapper;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    SystemAdminCacheService systemAdminCacheService;

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

    @Override
    public String login(String account, String pwd) {
        // 验证用户名和密码是否正确
        SystemAdmin systemAdmin = getAdminByAccount(account);
        if (systemAdmin == null) {
            throw new CommonException("用户名或密码错误");
        }
        Map<String, String> map = new HashMap<>();
        map.put("sub", account);
        String token = jwtTokenUtil.generateToken(map);
        return token;
    }

    @Override
    public SystemAdmin getAdminByAccount(String account) {
        SystemAdmin admin = systemAdminCacheService.getAdmin(account);
        if (admin != null) return admin;
        SystemAdminExample example = new SystemAdminExample();
        example.createCriteria().andAccountEqualTo(account);
        List<SystemAdmin> systemAdminList = systemAdminMapper.selectByExample(example);
        if (systemAdminList != null && systemAdminList.size() > 0) {
            SystemAdmin systemAdmin = systemAdminList.get(0);
            systemAdminCacheService.setAdmin(systemAdmin);
            return systemAdmin;
        }
        return null;
    }

    @Override
    public SystemAdmin getAdminByToken(String token) {
        String account = jwtTokenUtil.getSubjectFromToken(token);
        if (StringUtils.isEmpty(account)) {
            return null;
        }
        return getAdminByAccount(account);
    }
}
