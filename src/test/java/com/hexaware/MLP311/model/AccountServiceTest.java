package com.hexaware.MLP311.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class AccountServiceTest {

    @Test
    public void sum(){
        AccountService service = new AccountService();
        assertEquals(5, service.sum(3, 3));
        //assertEquals(excepted,actual)
     }
}
