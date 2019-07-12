package cn.jantd.shiro.sevice.impl;


import cn.jantd.shiro.dao.UserInfoDao;
import cn.jantd.shiro.model.UserInfo;
import cn.jantd.shiro.sevice.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
