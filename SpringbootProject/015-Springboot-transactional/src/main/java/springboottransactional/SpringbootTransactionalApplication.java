package springboottransactional;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @EnableTransactionManagement:启用事务管理器
 */

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "springboottransactional.mapper")
public class SpringbootTransactionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTransactionalApplication.class, args);
    }

}
