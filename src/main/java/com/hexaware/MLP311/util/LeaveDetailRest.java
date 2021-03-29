package com.hexaware.MLP311.util;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.sql.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import com.hexaware.MLP311.factory.LeaveDetailFactory;
import com.hexaware.MLP311.model.LeaveDetail;

@Path("/employees")
public class LeaveDetailRest {
  @GET
  @Path("/getleavedetails/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetail getleaveappdetails(@PathParam("id") final int id) {
      final LeaveDetail ld = LeaveDetailFactory.getLeaveApplicationDetail(id);
      if (ld == null) {
        throw new NotFoundException("No such Employee ID: " + id);
      }
      return ld;

  }
  @PUT
  @Path("/updateLeaStatus")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final void updateEmpLeaStatus(LeaveDetail dto) {
  LeaveDetailFactory.updateLeaveStatus(dto.getLeaStatus(), dto.getEmpId(), dto.getLeaMgrComment());
    }


    @POST
    @Path("/applyleave")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void applyforleave(LeaveDetail ld) {
        LeaveDetailFactory.addLeaveApplicationDetail(ld.getEmpId(), ld.getLeaNoOfDays(),
         ld.getLeaStartDate().toString(), ld.getLeaEndDate().toString(), ld.getLeaType(),
          ld.getLeaReason(), (Date) ld.getLeaAppliedDate(), ld.getLeaStatus(), ld.getLeaMgrComment());
    }
    }



