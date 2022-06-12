package example;

//平台数据的增删改查

import org.junit.Test;
import pojo.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BrandTest{

    /**
     * 查询所有
     * 1.sql：select *from xxx;
     * 2.参数
     * 3.结果：list
     */


    @Test
    public void testSelectAll() throws SQLException {
        //1.获取连接的conne对象
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, username, password);

        //2定义sql
        String sql = "select * from tb_brand";

        //3获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //5执行sql
        ResultSet rs = pstmt.executeQuery();

        //6处理结果
        Brand brand = null;
        List<Brand> brands = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String brand_name = rs.getString("brand_name");
            String company_name = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            //封装
            brand = new Brand(id, brand_name, company_name, ordered, description, status);
            brands.add(brand);

            //装载集合
        }
        Iterator<Brand> iterator = brands.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //7释放资源
        rs.close();
        pstmt.close();
        conn.close();


    }

}
