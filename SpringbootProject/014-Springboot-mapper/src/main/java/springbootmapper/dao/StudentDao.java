package springbootmapper.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springbootmapper.model.Student;

/**
 * 告诉mybatis这是dao接口,创建此接口的代理对象
 * 位置:在类的上面
 */
public interface StudentDao {
    Student selectById(@Param("stuId") Integer id);
}
