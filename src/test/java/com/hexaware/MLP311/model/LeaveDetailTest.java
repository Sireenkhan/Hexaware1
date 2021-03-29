
package com.hexaware.MLP311.model;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import com.hexaware.MLP311.model.LeaveDetail;
import com.hexaware.MLP311.factory.LeaveDetailFactory;
import com.hexaware.MLP311.persistence.LeaveDetailDAO;


import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

public class LeaveDetailTest {

    @Test
    public void getLeaveApplicationDetailsTest(@Mocked final LeaveDetailDAO dao) {
        final LeaveDetail d1 = new LeaveDetail(200, 1001, 2, Date.valueOf("2021-03-19"), Date.valueOf("2021-03-20"),
        "Earned", "Marraige", Date.valueOf("2021-03-15"),"Pending","");

        new Expectations() {
          {
            dao.findLeaveApplicationDetail(1001);
            result = d1;
            dao.findLeaveApplicationDetail(1009);
            result = null;

          }
        };
        new MockUp<LeaveDetailFactory>() {
          @Mock
          LeaveDetailDAO dao() {
            return dao;
          }
        };
        assertEquals(d1, LeaveDetailFactory.getLeaveApplicationDetail(1001));
        assertEquals(null, LeaveDetailFactory.getLeaveApplicationDetail(1009));
  }

    @Test
    public void addLeaveApplicationDetailTest(){
        final LeaveDetail li = new LeaveDetail(201, 1002, 3, Date.valueOf("2021-03-16"), Date.valueOf("2021-03-18"),
        "Earned","Marraige", Date.valueOf("2021-03-15"),"Pending","");

            LeaveDetailFactory.addLeaveApplicationDetail(1002,3,"2021-03-16","2021-03-18",
            "Earned","Marraige",Date.valueOf("2021-03-15"),"Pending","");
            assertEquals(li, LeaveDetailFactory.getLeaveApplicationDetail(1002));

        }
        @Test
        public void updateLeaveStatusTest(){
            final LeaveDetail d1 = new LeaveDetail(200, 1001, 3, Date.valueOf("2021-03-19"), Date.valueOf("2021-03-20"),
            "Earned",  "Marraige", Date.valueOf("2021-03-15"),"Pending","");
             LeaveDetailFactory.updateLeaveStatus("Pending", 1001, "Done");
             assertEquals(d1, LeaveDetailFactory.getLeaveApplicationDetail(1001));


        }
}

