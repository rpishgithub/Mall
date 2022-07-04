package tech.rpish.mall.dao;

import tech.rpish.mall.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAllUsers();

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);
}
