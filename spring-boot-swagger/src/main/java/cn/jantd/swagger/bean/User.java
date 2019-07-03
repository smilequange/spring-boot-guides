package cn.jantd.swagger.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Description
 * @Author  圈哥
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/7/3
 */
@ApiModel(value = "用户类",description = "用户实体类")
public class User {
    @ApiModelProperty(value = "用户ID",dataType = "int")
    private int id;
    @ApiModelProperty(value = "用户名称",dataType = "String")
    private String username;
    @ApiModelProperty(value = "年龄",dataType = "int")
    private int age;
    @ApiModelProperty(value = "生日",dataType ="Date")
    private Date birthday;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
