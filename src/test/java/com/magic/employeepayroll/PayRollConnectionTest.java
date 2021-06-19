package com.magic.employeepayroll;

import org.junit.jupiter.api.Test;
import java.sql.Connection;


public class PayRollConnectionTest {
    @Test
    public void getDBConnection(){
        Connection dbConnection = new PayRollConnection().getDBConnection();
        System.out.println(dbConnection);

    }
}
