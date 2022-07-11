package tech.rpish.mall.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;
import tech.rpish.mall.dao.UserDao;
import tech.rpish.mall.entity.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MyBatisController {
    @Resource
    UserDao userDao;

    @GetMapping("/mybatis/findAll")
    public List<User> findAll() {
        return userDao.findAllUsers();
    }

    @GetMapping("/mybatis/insert")
    public boolean insert(String name, String password) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return false;
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return userDao.insertUser(user)>0;
    }

    @GetMapping("/mybatis/delete")
    public boolean delete(Integer id) {
        if (id == null || id < 1) {
            return false;
        }
        return userDao.deleteUser(id)>0;
    }

    @GetMapping("/mybatis/update")
    public boolean update(Integer id, String name, String password) {
        if (id == null || id < 1 || StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return false;
        }
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return userDao.updateUser(user)>0;
    }
}
