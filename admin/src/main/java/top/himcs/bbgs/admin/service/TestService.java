package top.himcs.bbgs.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.himcs.bbgs.mbg.mapper.SystemAdminMapper;

@Service
public class TestService {
    @Autowired
    SystemAdminMapper systemAdminMapper;
}
