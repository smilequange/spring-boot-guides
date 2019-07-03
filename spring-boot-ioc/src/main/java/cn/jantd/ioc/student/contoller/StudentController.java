package cn.jantd.ioc.student.contoller;

import cn.jantd.ioc.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @Description
 * @Author  圈哥
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/7/3
 */
@Controller("studentController")
public class StudentController {
//    @Resource(name = "studentService")
    @Autowired
    @Qualifier("studentService")// 解决一对多问题
    private StudentService studentService ;

    /**
     * 获取年龄
     * @param name
     * @return
     */
    public int  getAge(String name){
        return  studentService.getStudent(name).getAge();
    }
}
