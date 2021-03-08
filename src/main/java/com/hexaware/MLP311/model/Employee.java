package com.hexaware.MLP311.model;
import java.util.Date;
import java.util.Objects;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   */
  private int empId;
  private String fullName;
  private String email;
  private String mobile;
  private Date joinDate;
  private String dept;
  private int leaveBal;
  private int mgrId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId);
  }











  /**
   * @param argEmpId to initialize employee id.
   * @param argFullName to initialize employee Name.
   * @param argEmail to initialize employee email.
   * @param argMobile to initialize employee mobile number.
   * @param argJoinDate to initialize employee datejoined.
   * @param argDept to initialize employee department.
   * @param argLeaveBal to initialize employee manager Id.
   * @param argMgrId to initialize employee leave balance.
   * used to get details through constructor.
   */
  public Employee(final int argEmpId, final String argFullName, final String argEmail,
       final String argMobile, final Date argJoinDate,
       final String argDept, final int argLeaveBal, final int argMgrId) {
    this.empId = argEmpId;
    this.fullName = argFullName;
    this.email = argEmail;
    this.mobile = argMobile;
    this.joinDate = argJoinDate;
    this.dept = argDept;
    this.leaveBal = argLeaveBal;
    this.mgrId = argMgrId;
  }

  /**
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   * @return this Employee's Name.
   */
  public final String getFullName() {
    return fullName;
  }
  /**
   * @return this Employee's Email.
   */
  public final String getEmail() {
    return email;
  }
  /**
   * @return this Employee's Mobile Number.
   */
  public final String getMobile() {
    return mobile;
  }
  /**
   * @return this Employee's Joining Date.
   */
  public final Date getJoinDate() {
    return joinDate;
  }
  /**
   * @return this Employee's Department.
   */
  public final String getDept() {
    return dept;
  }
  /**
   * @return this Employee's Leave Balance.
   */
  public final int getLeaveBal() {
    return leaveBal;
  }
  /**
   * @return this Employee's Manager ID.
   */
  public final int getMgrId() {
    return mgrId;
  }

  /**
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @param argFullName to set employee Name.
   */
  public final void setFullName(final String argFullName) {
    this.fullName = argFullName;
  }
  /**
   * @param argEmail to set employee email.
   */
  public final void setEmail(final String argEmail) {
    this.email = argEmail;
  }
  /**
   * @param argMobile to set employee Mobile.
   */
  public final void setMobile(final String argMobile) {
    this.mobile = argMobile;
  }
  /**
   * @param argJoinDate to set employee Joining Date.
   */
  public final void setJoinDate(final Date argJoinDate) {
    this.joinDate = argJoinDate;
  }
  /**
   * @param argDept to set employee department.
   */
  public final void setDept(final String argDept) {
    this.dept = argDept;
  }
  /**
   * @param argLeaveBal to set employee leave balance.
   */
  public final void setLeaveBal(final int argLeaveBal) {
    this.leaveBal = argLeaveBal;
  }
  /**
   * @param argMgrId to set employee manager id.
   */
  public final void setMgrId(final int argMgrId) {
    this.mgrId = argMgrId;
  }

}
