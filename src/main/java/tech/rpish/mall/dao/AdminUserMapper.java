package tech.rpish.mall.dao;

import org.apache.ibatis.annotations.Param;
import tech.rpish.mall.entity.AdminUser;

public interface AdminUserMapper {
    AdminUser login(@Param("userName") String userName,@Param("password")String password);
}
