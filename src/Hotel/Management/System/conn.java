package Hotel.Management.System;
import java.sql.*;

public class conn {
    Connection c;

    conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c= DriverManager.getConnection("jdbc:mysql://localhost:3306/");
    }catch(Exception e){
            e.printStackTrace();
        }
}