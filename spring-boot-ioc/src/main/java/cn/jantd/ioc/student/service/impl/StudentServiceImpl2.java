package cn.jantd.ioc.student.service.impl;

import cn.jantd.ioc.student.model.Student;
import cn.jantd.ioc.student.service.StudentService;
import cn.jantd.ioc.student.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService2")
public class StudentServiceImpl2 implements StudentService {

    @Autowired
    private StudentMapper studentMapper ;
    @Override
    public Student getStudent(String name) {
        return studentMapper.getStudentByName(name);
    }
}
