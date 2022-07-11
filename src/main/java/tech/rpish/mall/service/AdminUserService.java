package tech.rpish.mall.service;

import org.springframework.stereotype.Service;
import tech.rpish.mall.entity.AdminUser;

public interface AdminUserService {
    AdminUser login(String userName, String password);
}
