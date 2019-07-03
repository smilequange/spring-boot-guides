package cn.jantd.ioc.student.mapper;

import cn.jantd.ioc.student.model.Student;
import org.springframework.stereotype.Component;


/**
 * @Description
 * @Author  圈哥
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/7/3
 */
//@Repository
@Component("studentMapper")
public class StudentMapper {
    /**
     * 根据名称获取学生信息
     * @param name
     * @return
     */
    public Student getStudentByName(String name){
        Student student = new Student();
        student.setName(name);
        student.setAge(20);
        return student;
    }

}
