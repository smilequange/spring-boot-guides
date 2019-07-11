package cn.jantd.mybatis.mapper;

import cn.jantd.mybatis.model.User;
import cn.jantd.mybatis.model.UserCriteria;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserMapperTest {
    @Autowired
    private  UserMapper userMapper ;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 插入一条测试数据
     */
    private  User  insertUserDate(){
        User user = new User();
        user.setUserName("quange");
        user.setAge(18);
        userMapper.insert(user);
        return  user;
    }

    @Test
    public void countByExample() {
        User user = new User();
        user.setUserName("quange");
        user.setAge(18);
        int resultCode =  userMapper.insert(user);
        Assert.assertEquals(1,resultCode);
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.createCriteria().andUserNameEqualTo("quange");
        long count = userMapper.countByExample(userCriteria);
        Assert.assertEquals(1,count);
    }

    @Test
    public void deleteByExample() {
        insertUserDate();
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.createCriteria().andUserNameEqualTo("quange");
        int resultCode =  userMapper.deleteByExample(userCriteria);
        Assert.assertEquals(1,resultCode);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUserName("quange");
        user.setAge(18);
        int resultCode =  userMapper.insert(user);
        Assert.assertEquals(1,resultCode);
    }

    @Test
    public void deleteByPrimaryKey() {
        insertUserDate();
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.createCriteria().andUserNameEqualTo("quange");
        List<User> users = userMapper.selectByExample(userCriteria);
        Assert.assertEquals(1,userMapper.deleteByPrimaryKey(users.get(0).getUserId()));
    }



    @Test
    public void insertSelective() {
        User user = new User();
        user.setUserName("quange");
        int resultCode =  userMapper.insertSelective(user);
        Assert.assertEquals(1,resultCode);
    }

    @Test
    public void selectByExample() {
        insertUserDate();
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.createCriteria().andUserNameEqualTo("quange");
        List<User> users = userMapper.selectByExample(userCriteria);
        Assert.assertEquals("quange", users.get(0).getUserName());
        Assert.assertEquals(18, users.get(0).getAge().intValue());
    }

    @Test
    public void selectByPrimaryKey() {
        User user = insertUserDate();
        User actualUser = userMapper.selectByPrimaryKey(user.getUserId());
        Assert.assertEquals(user.getUserId(),actualUser.getUserId());
    }

}
