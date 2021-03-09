package com.hexaware.MLP311.util;

import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;

import com.hexaware.MLP311.factory.EmployeeFactory;
import com.hexaware.MLP311.model.Employee;
import com.hexaware.MLP311.factory.LeaveDetailFactory;
import com.hexaware.MLP311.model.LeaveDetail;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply for Leave");
    System.out.println("4. Check Leave Status");
    System.out.println("5. View Manager Details");
    System.out.println("6. Action on Leave Application");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }

  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:

        applyForLeave();
        break;
      case 4:
        checkLeaveStatus();
        break;
      case 5:
        viewManagerDetails();
        break;
      case 6:
        actionOnLeaveApplication();
        break;
      case 7:
        System.exit(1);
      default:
        System.out.println("Choose between 1 to 7");
    }
    mainMenu();
  }

  /**
   *  @param employee to display employee details.
   */
  private void displayEmployeeDetails(final Employee employee) {
    System.out.println("Employee Id :- " + employee.getEmpId());
    System.out.println("Full Name -: " + employee.getFullName());
    System.out.println("Email -: " + employee.getEmail());
    System.out.println("Mobile Number -: " + employee.getMobile());
    System.out.println("Joining Date -: " + employee.getJoinDate());
    System.out.println("Department -: " + employee.getDept());
    System.out.println("Leave Balance -: " + employee.getLeaveBal());
    System.out.println("\n");
  }
  private void actionOnLeaveApplication() {
    System.out.println("Enter your employee ID to see your reporting employess applied for leave");
    int empId = option.nextInt();
    Employee[] employee = EmployeeFactory.listReporting(empId);
    if (employee.length != 0) {
      System.out.println("                          Reporting Employees are");
      System.out.println("      ----------------------------------------------------");
      System.out.println();
      for (Employee em : employee) {
        System.out.println("Employee Id:- " + em.getEmpId()
                          + "     Employee Name:- " + em.getFullName());
      }
      System.out.println("Enter Id of employee you want to see leave application");
      int leaEmpId = option.nextInt();
      LeaveDetail ld = LeaveDetailFactory.getLeaveApplicationDetail(leaEmpId);
      int noOfDays = ld.getLeaNoOfDays();
      System.out.println("Press 1 to approve the application");
      System.out.println("Press 2 to reject the application");
      System.out.println("Press 3 to exit");
      int permission = option.nextInt();
      action(permission, leaEmpId, noOfDays);
    } else {
      System.out.println("No application found");
    }
  }
  private void action(final int permission, final int empId, final int noOfDays) {
    if (permission == 1) {
      String status = "APPROVED";
      String comment = "";
      LeaveDetailFactory.updateLeaveStatus(status, empId, comment);
      EmployeeFactory.updateLeaveBalance(empId, noOfDays);
      System.out.println("Leave approved");
    } else if (permission == 2) {
      String status = "REJECTED";
      option.nextLine();
      System.out.println("Enter your comment for rejection");
      String comment = option.nextLine();
      LeaveDetailFactory.updateLeaveStatus(status, empId, comment);
      System.out.println("Leave Rejected");
    } else if (permission == 3) {
      System.out.println("Exit");
    } else {
      System.out.println("Wrong choice");
    }
  }

  private void checkLeaveStatus() {
    System.out.println("Enter Employee ID - : ");
    int empId = option.nextInt();
    LeaveDetail ld = LeaveDetailFactory.getLeaveApplicationDetail(empId);
    if (ld == null) {
      System.out.println("Sorry No Records found");
    } else {
      System.out.println("Employee ID -:    " + ld.getEmpId() + "  Start Date -: " + ld.getLeaStartDate());
      System.out.println("Employee Name -:  " + ld.getEmpId()  + "  End Date -:   " + ld.getLeaEndDate());
      System.out.println("Leaves Balance -: 25              "  + "  No. Of Days -:" + ld.getLeaNoOfDays());
      System.out.println("Leave Status -:   " + ld.getLeaStatus() + "  Leave Reason -: " + ld.getLeaReason());
      System.out.println("Applied Date   -: " + ld.getLeaAppliedDate() + "  Manager Comment " + ld.getLeaMgrComment());
    }
  }

  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = EmployeeFactory.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      displayEmployeeDetails(employee);
    }
  }

  private void listEmployeesDetails() {
    Employee[] employee = EmployeeFactory.listAll();
    for (Employee e : employee) {
      System.out.println("EmployeeID -: " + e.getEmpId());
      System.out.println("Full Name -: " + e.getFullName());
      System.out.println("Email -: " + e.getEmail());
      System.out.println("Mobile Number -: " + e.getMobile());
      System.out.println("Joining Date -: " + e.getJoinDate());
      System.out.println("Department -: " + e.getDept());
      System.out.println("Leave Balance -: " + e.getLeaveBal());
      System.out.println("\n");
    }
  }
  private void applyForLeave() {
    System.out.println("-----------Leave Application Screen---------------");
    System.out.println("--------------------------------------------------");
    System.out.println("Enter Employeeid-: ");
    int empid = option.nextInt();
    option.nextLine();
    System.out.println("Enter Number of Days: ");
    int days = option.nextInt();
    option.nextLine();
    System.out.println("Enter Start Date: ");
    String stdate = option.nextLine();
    System.out.println("Enter End Date: ");
    String endate = option.nextLine();
    System.out.println("Enter Reason: ");
    String reason = option.nextLine();
    LeaveDetailFactory.addLeaveApplicationDetail(empid, days,
                                                                     stdate, endate, "Earned",
                                                                     reason,
                                                                     Date.valueOf(LocalDate.now()),
                                                                     "PENDING", "");
  }

  private void viewManagerDetails() {
    System.out.println("Enter Employee Id -: ");
    int empid = option.nextInt();
    Employee employee = EmployeeFactory.findManagerDetails(empid);
    if (employee != null) {
      displayEmployeeDetails(employee);
    } else {
      System.out.println("Sorry Employee with id" + empid + " does not exist/");
    }
  }

  /**
   * main method  is the basic entry point for the application.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}

