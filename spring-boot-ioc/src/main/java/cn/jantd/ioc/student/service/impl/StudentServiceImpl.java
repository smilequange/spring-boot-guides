package cn.jantd.ioc.student.service.impl;

import cn.jantd.ioc.student.service.StudentService;
import cn.jantd.ioc.student.mapper.StudentMapper;
import cn.jantd.ioc.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper ;
    @Override
    public Student getStudent(String name) {
        return studentMapper.getStudentByName(name);
    }
}
