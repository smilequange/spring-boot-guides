package cn.jantd.mybatis.mapper;

import cn.jantd.mybatis.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

public class UserMapperTest {
    @Autowired
    private  UserMapper userMapper ;

    @Before
    public void setUp() throws Exception {
        int[] ages = {10,15,20,25,30};
        String[] userNames={"张三","李四","王五","老大","老二"};
        User user ;
        for (int i = 0; i < ages.length; i++) {
            //插入基础数据
             user = new User();
            user.setAge(ages[i]);
            user.setUserName(userNames[i]);


        }


    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}
