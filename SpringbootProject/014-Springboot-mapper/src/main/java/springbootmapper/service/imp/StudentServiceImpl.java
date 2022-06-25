package springbootmapper.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmapper.dao.StudentDao;
import springbootmapper.model.Student;
import springbootmapper.service.StudentService;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public Student queryStudent(Integer id) {
        return studentDao.selectById(id);
    }
}
