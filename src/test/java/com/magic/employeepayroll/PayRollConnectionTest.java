package com.magic.employeepayroll;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PayRollConnectionTest {
    @Test
    public void getDBConnection(){
        Connection dbConnection = new PayRollConnection().getDBConnection();
        System.out.println(dbConnection);

    }
    @Test
    public void getDetails() throws SQLException {
        Connection dbConnection = new PayRollConnection().getDBConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee_pay_roll");
        while(resultSet.next()){
            System.out.println(resultSet.getString(1) + " " +
                    resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4) + " " +
                    resultSet.getString(5) + " " +
                    resultSet.getString(6) + " " +
                    resultSet.getString(7) + " " +
                    resultSet.getString(8) + " " +
                    resultSet.getString(9) + " " +
                    resultSet.getString(10) + " " +
                    resultSet.getString(11) + " " +
                    resultSet.getString(12));
        }
    }
}
