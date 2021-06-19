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
    @Test
    public void toRetrieve_details_OfEmployee_inParticular_dateRange() throws SQLException{
        Connection dbConnection = new PayRollConnection().getDBConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from employee_pay_roll where Start_Date BETWEEN '2020-10-11' AND '2021-06-19'");
        while(resultSet.next()){
            System.out.println(resultSet.getString("Name"));
        }
    }
    @Test
    public void findSum() throws SQLException{
        Connection dbConnection = new PayRollConnection().getDBConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("select SUM(Basic_Pay) from employee_pay_roll where Gender = 'F' ");
        resultSet.next();
        System.out.println("Sum of Female Salary " + resultSet.getString(1));
        ResultSet resultSet1 = statement.executeQuery("select SUM(Basic_Pay) from employee_pay_roll where Gender = 'M' ");
        resultSet1.next();
        System.out.println("Sum of Male Salary " + resultSet1.getString(1));
    }
    @Test
    public void findCount() throws SQLException{
        Connection dbConnection = new PayRollConnection().getDBConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("select Count(Basic_Pay) from employee_pay_roll where Gender = 'F' ");
        resultSet.next();
        System.out.println("Count of Female " + resultSet.getString(1));
        ResultSet resultSet1 = statement.executeQuery("select Count(Basic_Pay) from employee_pay_roll where Gender = 'M' ");
        resultSet1.next();
        System.out.println("Count of Male " + resultSet1.getString(1));
    }
    @Test
    public void findAverage() throws SQLException{
        Connection dbConnection = new PayRollConnection().getDBConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("select AVG(Basic_Pay) from employee_pay_roll where Gender = 'F' ");
        resultSet.next();
        System.out.println("Average Salary of Female " + resultSet.getString(1));
        ResultSet resultSet1 = statement.executeQuery("select AVG(Basic_Pay) from employee_pay_roll where Gender = 'M' ");
        resultSet1.next();
        System.out.println("Average Salary of Male " + resultSet1.getString(1));
    }
    @Test
    public void findMinimum() throws SQLException{
        Connection dbConnection = new PayRollConnection().getDBConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("select min(Basic_Pay) from employee_pay_roll where Gender = 'F' ");
        resultSet.next();
        System.out.println("Minimum Salary of Female " + resultSet.getString(1));
        ResultSet resultSet1 = statement.executeQuery("select min(Basic_Pay) from employee_pay_roll where Gender = 'M' ");
        resultSet1.next();
        System.out.println("Minimum Salary of Male " + resultSet1.getString(1));
    }
    @Test
    public void findMaximum() throws SQLException{
        Connection dbConnection = new PayRollConnection().getDBConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("select MAX(Basic_Pay) from employee_pay_roll where Gender = 'F' ");
        resultSet.next();
        System.out.println("Maximum Salary of Female " + resultSet.getString(1));
        ResultSet resultSet1 = statement.executeQuery("select MAX(Basic_Pay) from employee_pay_roll where Gender = 'M' ");
        resultSet1.next();
        System.out.println("Maximum Salary of Male " + resultSet1.getString(1));
    }

}
