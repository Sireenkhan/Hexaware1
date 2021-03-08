package com.hexaware.MLP311.model;
import java.util.Objects;
import java.util.Date;



/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class LeaveDetail {



  /**
   * empId to store employee id.
   */
  private int leaId, empId, leaNoOfDays;
  private String leaType, leaStatus, leaReason, leaMgrComment;
  private Date appliedDate, startDate, endDate;



  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetail leave = (LeaveDetail) obj;
    if (Objects.equals(leaId, leave.leaId)) {
      return true;
    }
    return false;
  }



  @Override
  public final int hashCode() {
    return Objects.hash(leaId);
  }
  /**
   * used to get details through constructor.
   * @param argLeaId  to initialize leave id.
   * @param argEmpId to initialize employee id.
   * @param argLeaNoOfDays to initialize Leave no of days.
   * @param argLeaStartDate to initialize leave start date.
   * @param argLeaEndDate to initialize leave end date.
   * @param argLeaType to initialize leave type.
   * @param argLeaStatus to initialize eleave status.
   * @param argLeaReason to initialize eleave reason.
   * @param argLeaAppliedDate to initialize leave applied date.
   * @param argLeaMgrComment to initialize manager comment.
   */
  public LeaveDetail(final int argLeaId, final int argEmpId,
        final int argLeaNoOfDays, final Date argLeaStartDate,
        final Date argLeaEndDate, final String argLeaType,
        final String argLeaReason, final Date argLeaAppliedDate,
        final String argLeaStatus, final String argLeaMgrComment) {
    this.leaId = argLeaId;
    this.empId = argEmpId;
    this.leaNoOfDays = argLeaNoOfDays;
    this.startDate = argLeaStartDate;
    this.endDate = argLeaEndDate;
    this.appliedDate = argLeaAppliedDate;
    this.leaType = argLeaType;
    this.leaReason = argLeaReason;
    this.leaStatus = argLeaStatus;
    this.leaMgrComment = argLeaMgrComment;
  }



  /**
   * @return this Leave Id.
   */
  public final int getLeaId() {
    return leaId;
  }
  /**
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   * @return this Leave no of days.
   */
  public final int getLeaNoOfDays() {
    return leaNoOfDays;
  }
  /**
   * @return this leave start date.
   */
  public final Date getLeaStartDate() {
    return startDate;
  }
  /**
   * @return this Leave end date.
   */
  public final Date getLeaEndDate() {
    return endDate;
  }
  /**
   * @return this Leave type.
   */
  public final String getLeaType() {
    return leaType;
  }
  /**
   * @return this Leave Status.
   */
  public final String getLeaStatus() {
    return leaStatus;
  }
  /**
   * @return this Leave Reason.
   */
  public final String getLeaReason() {
    return leaReason;
  }
  /**
   * @return this Leave Applied Date.
   */
  public final Date getLeaAppliedDate() {
    return appliedDate;
  }
  /**
   * @return this Leave Manager Comment.
   */
  public final String getLeaMgrComment() {
    return leaMgrComment;
  }




  /**
   * @param argLeaId  to set leave id.
   */
  public final void setLeaId(final int argLeaId) {
    this.leaId = argLeaId;
  }
    /**
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @param argLeaNoOfDays to set leave no of days.
   */
  public final void setLeaNoOfDays(final int argLeaNoOfDays) {
    this.leaNoOfDays = argLeaNoOfDays;
  }
  /**
   * @param argLeaStartDate to set Leave start date.
   */
  public final void setLeaStartDate(final Date argLeaStartDate) {
    this.startDate = argLeaStartDate;
  }
  /**
   * @param argLeaEndDate to set leave end date.
   */
  public final void setLeaEndDate(final Date argLeaEndDate) {
    this.endDate = argLeaEndDate;
  }
  /**
   * @param argLeaType to set leave type.
   */
  public final void setLeaType(final String argLeaType) {
    this.leaType = argLeaType;
  }
  /**
   * @param argLeaStatus to set Leave status.
   */
  public final void setLeaStatus(final String argLeaStatus) {
    this.leaStatus = argLeaStatus;
  }
  /**
   * @param argLeaReason to set Leave Reason.
   */
  public final void setLeaReason(final String argLeaReason) {
    this.leaReason = argLeaReason;
  }
  /**
   * @param argLeaAppliedDate to set Leave Applied Date.
   */
  public final void setLeaAppliedDate(final Date argLeaAppliedDate) {
    this.appliedDate = argLeaAppliedDate;
  }
  /**
   * @param argLeaMgrComment to set Manager Comment.
   */
  public final void setLeaMgrComment(final String argLeaMgrComment) {
    this.leaMgrComment = argLeaMgrComment;
  }
}
