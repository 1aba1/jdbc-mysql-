import org.junit.Test;

import java.sql.*;

public class ConnectData{

    @Test
    public  void testConnect() throws Exception {
        //0.����������

        //1.ע������
        Class.forName("com.mysql.jdbc.Driver");



        //2.��ȡ����
        String url="jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
        String user="root";
        String password="123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        //3.����sql���
        String sql="select * from student";

        //4.��ȡsqlִ�ж���
        Statement stmt = conn.createStatement();

        //5.�øö���ִ��sql���
        ResultSet rs = stmt.executeQuery(sql);


        //6.���ݴ���
        System.out.println("����ȡ��");
        System.out.println("age   name   adress   sex   id   ");
        System.out.println("_________________________________");
        while (rs.next()){
            System.out.print(rs.getInt("age")+"   ");
            System.out.print(rs.getString("name")+"   ");
            System.out.print(rs.getString("address")+"   ");
            System.out.print(rs.getString("sex")+"   ");
            System.out.println(rs.getInt("id"));
            System.out.println("_________________________________");
        }


        //7.��Դ�ر�
        rs.close();
        stmt.close();
        conn.close();
    }

}
