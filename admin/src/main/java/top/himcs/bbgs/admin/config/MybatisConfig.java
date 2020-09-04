package top.himcs.bbgs.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"top.himcs.bbgs.admin.dao", "top.himcs.bbgs.mbg.mapper"})
public class MybatisConfig {
}

