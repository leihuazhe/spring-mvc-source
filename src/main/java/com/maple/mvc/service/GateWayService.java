package com.maple.mvc.service;

import com.google.gson.Gson;
import com.maple.mvc.entity.TestBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * desc: GateWayService
 *
 * @author hz.lei
 * @since 2018年08月22日 上午10:26
 */
@Service
public class GateWayService {

    @Resource(name = "tx_h2_dataSource")
    private DataSource dataSource;

    private Gson gson = new Gson();


    public String getTestData() {
        List<TestBean> beans = new ArrayList<>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement("select * from test");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                TestBean testBean = new TestBean(id, name, age);
                beans.add(testBean);
            }
            String json = gson.toJson(beans);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "hello";
    }

    public String insertUser(String name, String age) {
        List<TestBean> beans = new ArrayList<>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement("insert into test set name = ?,age = ?");
            pst.setString(1, name);
            pst.setString(2, age);

            int i = pst.executeUpdate();
            return "执行成功,记录数" + i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "hello";
    }
}
