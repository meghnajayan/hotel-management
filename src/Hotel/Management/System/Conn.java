package Hotel.Management.System;
import java.sql.*;
import java.sql.Connection;

public class Conn {
    Connection connection;
    Statement statement;

    Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagmentsystem","root","0987654321vgt@#");
            statement = connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}

