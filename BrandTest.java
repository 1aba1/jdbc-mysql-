package example;

//ƽ̨���ݵ���ɾ�Ĳ�

import org.junit.Test;
import pojo.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BrandTest{

    /**
     * ��ѯ����
     * 1.sql��select *from xxx;
     * 2.����
     * 3.�����list
     */


    @Test
    public void testSelectAll() throws SQLException {
        //1.��ȡ���ӵ�conne����
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, username, password);

        //2����sql
        String sql = "select * from tb_brand";

        //3��ȡpstmt����
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //5ִ��sql
        ResultSet rs = pstmt.executeQuery();

        //6������
        Brand brand = null;
        List<Brand> brands = new ArrayList<>();
        while (rs.next()) {
            //��ȡ����
            int id = rs.getInt("id");
            String brand_name = rs.getString("brand_name");
            String company_name = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            //��װ
            brand = new Brand(id, brand_name, company_name, ordered, description, status);
            brands.add(brand);

            //װ�ؼ���
        }
        Iterator<Brand> iterator = brands.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //7�ͷ���Դ
        rs.close();
        pstmt.close();
        conn.close();


    }

}
