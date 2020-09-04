package top.himcs.bbgs.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.himcs.bbgs.admin.service.SystemAdminCacheService;
import top.himcs.bbgs.common.service.RedisService;
import top.himcs.bbgs.mbg.model.SystemAdmin;

@Service
public class SystemAdminCacheServiceImpl implements SystemAdminCacheService {
    @Autowired
    RedisService redisService;

    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;

    @Override
    public void setAdmin(SystemAdmin admin) {
        String key = getKey(admin.getAccount());
        redisService.set(key, admin);
    }

    @Override
    public SystemAdmin getAdmin(String account) {
        String key = getKey(account);
        return (SystemAdmin) redisService.get(key);
    }

    private String getKey(String account) {
        return REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + account;
    }
}
