package tech.rpish.mall.service.impl;

import org.springframework.stereotype.Service;
import tech.rpish.mall.dao.AdminUserMapper;
import tech.rpish.mall.entity.AdminUser;
import tech.rpish.mall.service.AdminUserService;
import tech.rpish.mall.utils.MD5Util;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserMapper.login(userName, passwordMd5);
    }

}
