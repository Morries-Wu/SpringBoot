package springbootmapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springbootmapper.model.Student;
import springbootmapper.service.StudentService;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/student/query")
    public String queryStudent(Integer id) {
        Student student = studentService.queryStudent(id);
        return student.toString();
    }
}
