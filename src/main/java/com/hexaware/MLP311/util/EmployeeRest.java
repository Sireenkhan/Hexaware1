package com.hexaware.MLP311.util;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP311.factory.EmployeeFactory;
import com.hexaware.MLP311.model.Employee;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/employee")
public class EmployeeRest {

  /**
   * Returns a list of all the employees.
   * @return a list of all the employees
   */
  @GET
  @Path("/getall")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee[] employeesList() {
    System.out.println("Employees List");
    final Employee[] employees = EmployeeFactory.listAll();
    return employees;
  }

  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/listall/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee employeeListById(@PathParam("id") final int id) {
    final Employee empl = EmployeeFactory.listById(id);
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    }
    return empl;
  }
  /**
   * Returns managers id
   */
  @GET
  @Path("/manager/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee employeefindManagerDetails(@PathParam("id") final int id) {
    final Employee emp = EmployeeFactory.findManagerDetails(id);
    if (emp == null) {
      throw new NotFoundException("No such Employee ID: " + id);

    }
    return emp;
  }
  /**
   * Update leavebalance.
   */

  @PUT
  @Path("/updateleavedetail/{id}/{noofdays}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final void updateleavedetail(@PathParam ("id") final int id, @PathParam ("noofdays") final int noofdays) {
      EmployeeFactory.updateLeaveBalance(id,noofdays);
  }

}
