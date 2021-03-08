package com.hexaware.MLP311.factory;
import com.hexaware.MLP311.persistence.LeaveDetailDAO;
import com.hexaware.MLP311.persistence.DbConnection;
import com.hexaware.MLP311.model.LeaveDetail;
import java.sql.Date;


/**
 * LeaveDetailFactory class used to fetch Employee data from database.
 * @author hexware
 */
public class LeaveDetailFactory {
    /**
     * Protected constructor.
     */
  protected LeaveDetailFactory() {

  }

    /**
     * The dao for leave.
     */
  private static LeaveDetailDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailDAO.class);
  }


  /**
     * @param empID id to get  leave application details.
     * @return Application
     */
  public static LeaveDetail getLeaveApplicationDetail(final int empID) {
    return dao().findLeaveApplicationDetail(empID);
  }
  /**
     * @param empID id to get  leave application details.
     * @param totalNoDays to get  leave application details.
     * @param startDate to get  leave application details.
     * @param endDate to get  leave application details.
     * @param leaveType to get  leave application details.
     * @param leaveReason to get  leave application details.
     * @param leaveAppOn to get  leave application details.
     * @param leaveStatus to get  leave application details.
     * @param mgrComments to get  leave application details.
     */
  public static void addLeaveApplicationDetail(final int empID,
      final int totalNoDays, final String startDate, final String endDate,
      final String leaveType, final String leaveReason, final Date leaveAppOn,
      final String leaveStatus, final String mgrComments) {
    dao().insertLeaveApplicationDetail(empID, totalNoDays, Date.valueOf(startDate),
            Date.valueOf(endDate), leaveType, leaveReason, leaveAppOn, leaveStatus,
            mgrComments);
  }
    /**
   *@param status to update leave status.
   *@param empID to update status for that employee.
   *@param comment to update manager comment on rejection of application.
  */
  public static void updateLeaveStatus(final String status, final int empID, final String comment) {
    dao().changeLeaveStatus(status, empID, comment);
  }
}
