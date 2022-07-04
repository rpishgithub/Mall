package tech.rpish.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/insert")
    public String insert(String type, String name) {
        if (StringUtils.isEmpty(type) || StringUtils.isEmpty(name)) {
            return "参数异常";
        }
//        jdbcTemplate.execute("insert into jdbc_test(`ds_type`,`ds_name`) value (\"" + type + "\",\"" + name + "\")");
        jdbcTemplate.execute("insert into jdbc_test(`ds_type`,`ds_name`) value (\"v1\",\"v2\")".replace("v1",type).replace("v2",name));
        return "插入成功";
    }

    @GetMapping("/delete")
    public String delete(int id) {
        if (id < 0) {
            return "参数异常";
        }
        List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from jdbc_test where ds_id = \"" + id + "\"");
        if (CollectionUtils.isEmpty(result)) {
            return "不存在记录,删除失败";
        }
        jdbcTemplate.execute("delete from jdbc_test where ds_id=\"" + id + "\"");
        return "删除成功";
    }

    @GetMapping("/update")
    public String update(int id, String type, String name) {
        if (id < 0 || StringUtils.isEmpty(type) || StringUtils.isEmpty(name)) {
            return "参数异常";
        }
        List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from jdbc_test where ds_id=\"" + id + "\"");
        if (CollectionUtils.isEmpty(result)) {
            return "不存在记录,修改失败";
        }
        jdbcTemplate.execute("update jdbc_test set ds_type=\"" + type + "\", ds_name= \"" + name + "\" where ds_id=\"" + id + "\"");
        return "修改成功";
    }

    @GetMapping("queryAll")
    public List<Map<String, Object>> queryAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from jdbc_test");
        return list;
    }
}
