package com.hexaware.MLP311.persistence;

import com.hexaware.MLP311.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;


import java.util.List;

/**
 * The DAO class for employee.
 * @author hexware
 */
public interface EmployeeDAO {
  /**
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * @param empId for manager id.
   * @return the employee array for reporting employee
   */
  @SqlQuery("select * from employee e WHERE e.EMP_ID IN"
            + "(SELECT l.EMP_ID from LEAVE_DETAILS l WHERE l.LEA_STATUS = 'PENDING') AND e.EMP_MGR_ID = :empId;")
  @Mapper(EmployeeMapper.class)
  List<Employee> listSome(@Bind("empId") int empId);


  /**
   * @param empID the id of the employee
   * @return the employee object
   */

  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);
/**
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("Select * from employee where emp_id = (select emp_mgr_id from employee where emp_id = :empID)")
  @Mapper(EmployeeMapper.class)
  Employee findManager(@Bind("empID") int empID);

  /**
   * @param empid the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID =:empid")
  @Mapper(EmployeeMapper.class)
  Employee findEmployee(@Bind("empid") int empid);

  /**
  * @param empId for employee id.
  * @param noOfDays for leave days.
  */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_LEAVE_BALANCE = (EMP_LEAVE_BALANCE - :noOfDays) WHERE EMP_ID = :empId")
  void changeLeaveBalance(@Bind("empId")int empId, @Bind("noOfDays")int noOfDays);

  /**
   * close with no args is used to close the connection.
   */
  void close();
}
