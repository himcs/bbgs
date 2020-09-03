package top.himcs.bbgs.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动入口 需要扫描其他包的注解要配置  scanBasePackages
 */
@SpringBootApplication(scanBasePackages = "top.himcs.bbgs")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
