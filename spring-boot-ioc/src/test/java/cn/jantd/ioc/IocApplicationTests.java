package cn.jantd.ioc;

import cn.jantd.ioc.student.service.StudentService;
import cn.jantd.ioc.student.contoller.StudentController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IocApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;
    @Test
    public void studentControllerByTypeTest() {
        //测试获取StudentController
        StudentController studentController = applicationContext.getBean(StudentController.class);
        Assert.assertEquals("年龄不相等",20,studentController.getAge("张三"));
    }

    @Test
    public void studentControllerByNameTest() {
        //测试获取StudentController
        StudentController studentController = (StudentController)applicationContext.getBean("studentController");
        Assert.assertEquals("年龄不相等",20,studentController.getAge("张三"));
    }

    @Test
    public void studentServiceTest() {
        // 测试获取studentService
        StudentService studentService = applicationContext.getBean(StudentService.class,"studentService");
        Assert.assertEquals(20,studentService.getStudent("李四").getAge());
    }



}
