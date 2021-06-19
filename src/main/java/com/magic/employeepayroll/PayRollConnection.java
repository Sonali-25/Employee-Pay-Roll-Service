package com.magic.employeepayroll;

import java.sql.*;

public class PayRollConnection {
    private String url = "jdbc:mysql://localhost:3306/address_book_db?useSSL=false";
    private String userName = "root";
    private String password = "SonaliJha@256";

    public Connection getDBConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,userName,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
