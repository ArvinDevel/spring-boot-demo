package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class JdbcTemplateTest {
    @Resource
    private JdbcTemplate template;

    @Test
    public void queryStudent() {
        String sql = "SELECT * FROM student";
        List<Map<String, Object>> list = template.queryForList(sql);

        for (Map<String, Object> stringObjectMap : list) {

            System.out.println(stringObjectMap);
        }
    }

    @Test
    public void addOneStudent() {
        String sql = "insert into student(name,age) values(?,?)";
        int count = template.update(sql, "郭靖", 10);
        System.out.println(count);
    }

    @Test
    public void queryAndAddOneYear() {
        String sql = "select * from student where name = ?";
        Map<String, Object> map = template.queryForMap(sql, "郭靖");
        int oldAge = (Integer) map.get("age");
        System.out.println("old age: " + oldAge);
        String updateSql = "update student set age = ? where name = ?";
        int count = template.update(updateSql, oldAge + 1, "郭靖");
        System.out.println(count);
    }


    @Test
    public void queryStudentWithName() {
        String sql = "select * from student where name = ?";
        Map<String, Object> map = template.queryForMap(sql, "郭靖");
        System.out.println(map);
        System.out.println(map.get("id"));
    }
}
