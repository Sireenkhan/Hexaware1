package com.hexaware.MLP311.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.Date;
import com.hexaware.MLP311.model.LeaveDetail;

/**
 * The DAO class for Leavedetail.
 * @author hexware
 */
public interface LeaveDetailDAO {
/**
 * @param empid the id of the employee
   @return leavedetails
 */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID =:empid")
  @Mapper(LeaveDetailMapper.class)
  LeaveDetail findLeaveApplicationDetail(@Bind("empid")int empid);
/**
 * @param empid the id of the employee
 * @param leaNoOfDays the id of the leave
 * @param startDate the id of the leave
 * @param endDate the id of the leave
 * @param leaType the id of the leave
 * @param leaReason the id of the leave
 * @param appliedDate the id of the leave
 * @param leaStatus the id of the leave
 * @param leaMgrComment the id of the leave
 */

  @SqlUpdate("INSERT INTO LEAVE_DETAILS VALUES(NULL,:empid,:leaNoOfDays,"
      + ":startDate,:endDate,:leaType,:leaReason,"
      + ":appliedDate,:leaStatus,:leaMgrComment)")
  void insertLeaveApplicationDetail(@Bind("empid")int empid,
      @Bind("leaNoOfDays")int leaNoOfDays,
      @Bind("startDate")Date startDate, @Bind("endDate")Date endDate,
      @Bind("leaType")String leaType, @Bind("leaReason")String leaReason,
      @Bind("appliedDate")Date appliedDate, @Bind("leaStatus")String leaStatus,
      @Bind("leaMgrComment")String leaMgrComment);

/**
  * @param status for updating status.
  * @param empId for employee id.
  * @param comment for manager comment.
  */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEA_STATUS = :status, LEA_MGR_COMMENTS = :comment WHERE EMP_ID = :empId")
  void changeLeaveStatus(@Bind("status")String status, @Bind("empId")int empId, @Bind("comment")String comment);


}
