package com.hexaware.MLP311.factory;

import com.hexaware.MLP311.persistence.EmployeeDAO;
import com.hexaware.MLP311.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP311.model.Employee;

/**
 * EmployeeFactory class used to fetch Employee data from database.
 * @author hexware
 */
public class EmployeeFactory {
    /**
     * Protected constructor.
     */
  protected EmployeeFactory() {

  }

    /**
     * The dao for employee.
     */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

    /**
     * Call the data base connection.
     * @return all employees' details
     */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

    /**
     * @param empID id to get employee details.
     * @return Employee
     */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }
  /**
     * @param empID id to get Manager details.
     * @return Employee
     */
  public static Employee findManagerDetails(final int empID) {
    return dao().findManager(empID);
  }
    /**
  * @param empId to get Employee name.
  * @return Employee
  */
  public static Employee[] listReporting(final int empId) {
    List<Employee> es = dao().listSome(empId);
    return es.toArray(new Employee[es.size()]);
  }

  /**
  * @param empid to get Employee name.
  * @return Employee
  */
  public static Employee findEmployeeName(final int empid) {
    return dao().findEmployee(empid);
  }

  /**
   *@param noOfDays to update leave leave balance.
   *@param empId to update leave balance for that employee.
  */
  public static void updateLeaveBalance(final int empId, final int noOfDays) {
    dao().changeLeaveBalance(empId, noOfDays);
  }
}
