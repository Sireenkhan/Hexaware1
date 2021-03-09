package com.hexaware.MLP311.persistence;
import com.hexaware.MLP311.model.LeaveDetail;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import org.skife.jdbi.v2.StatementContext;
import java.sql.SQLException;
/**
 * Mapper class to map from result set to employee object.
 * @author hexware.
 */
public class LeaveDetailMapper implements ResultSetMapper<LeaveDetail> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetail map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    /**
     * @return LeaveDetail
     */
    return new LeaveDetail(rs.getInt("LEA_ID"), rs.getInt("EMP_ID"), rs.getInt("LEA_TOT_DAYS"),
       rs.getDate("LEA_START_DATE"), rs.getDate("LEA_END_DATE"), rs.getString("LEA_TYPE"),
       rs.getString("LEA_REASON"), rs.getDate("LEA_APP_ON"), rs.getString("LEA_STATUS"),
       rs.getString("LEA_MGR_COMMENTS"));
  }
}
