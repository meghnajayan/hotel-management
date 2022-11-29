package Hotel.Management.System;
import java.sql.*;

public class Conn {
    Connection connection;
    Statement statement;

    Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagmentsystem","root","12345");
            statement = connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}