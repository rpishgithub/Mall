package tech.rpish.mall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class MallApplicationTests {
    @Autowired
    private DataSource defaultDataSource;

    @Test
    public void dataSourceTest() throws SQLException {
        Connection connection = defaultDataSource.getConnection();
        if (connection != null) {
            System.out.println("获取成功");
        }
        connection.close();
    }

    @Test
    void contextLoads() {
    }

}
