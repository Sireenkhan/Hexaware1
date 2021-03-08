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
}
