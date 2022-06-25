package springbootmapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @MapperScan:找到Dao接口和Mapper文件
 * basePackges:Dao接口所在包名
 */
@SpringBootApplication
@MapperScan(basePackages = "springbootmapper.dao")
public class SpringbootMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMapperApplication.class, args);
    }

}
