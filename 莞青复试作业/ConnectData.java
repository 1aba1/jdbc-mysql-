import org.junit.Test;

import java.sql.*;

public class ConnectData{

    @Test
    public  void testConnect() throws Exception {
        //0.导入驱动包

        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");



        //2.获取连接
        String url="jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
        String user="root";
        String password="123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        //3.定义sql语句
        String sql="select * from student";

        //4.获取sql执行对象
        Statement stmt = conn.createStatement();

        //5.用该对象执行sql语句
        ResultSet rs = stmt.executeQuery(sql);


        //6.数据处理
        System.out.println("表单提取：");
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


        //7.资源关闭
        rs.close();
        stmt.close();
        conn.close();
    }

}
