package com.rays.ors.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.rays.ors.bean.DropdownListBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DatabaseException;
import com.rays.ors.util.DataUtility;
import com.rays.ors.util.JDBCDataSrc;

public abstract class BaseModel implements Serializable, DropdownListBean, Comparable<BaseModel> {
	private static Logger log = Logger.getLogger(BaseModel.class);

	/**
	 * Non Business primary key
	 */
	protected long id;

	/**
	 * User name that creates this record.
	 */
	protected String createdBy;

	/**
	 * User name that modifies this record.
	 */
	protected String modifiedBy;

	/**
	 * Created timestamp of record
	 */
	protected Timestamp createdDatetime;

	/**
	 * Modified timestamp of record
	 */
	protected Timestamp modifiedDatetime;

	/**
	 * accessor methods
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Compares IDs ( Primary Key). If keys are equals then objects are equals.
	 *
	 */
	public int compareTo(BaseModel next) {
		return (int) (id - next.getId());
	}

	/**
	 * created next PK of record
	 *
	 * @throws DatabaseException
	 */

	public long nextPK() throws DatabaseException {
		log.debug("Model nextPK Started");
		Connection conn = null;
		long pk = 0;
		try {
			conn = JDBCDataSrc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM " + getTableName());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new DatabaseException("Exception : Exception in getting PK");
		} finally {
			JDBCDataSrc.closeConnection(conn);
		}
		log.debug("Model nextPK End");
		return pk + 1;
	}

	/**
	 * Gets table name of Model
	 *
	 * @return
	 */
	public abstract String getTableName();

	/**
	 * Updates created by info
	 *
	 * @throws ApplicationException
	 *
	 * @throws Exception
	 */
	public void updateCreatedInfo() throws ApplicationException {

		log.debug("Model update Started..." + createdBy);

		Connection conn = null;

		String sql = "UPDATE " + getTableName() + " SET CREATED_BY=?, CREATED_DATETIME=? WHERE ID=?";
		log.debug(sql);

		try {
			conn = JDBCDataSrc.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, createdBy);
			pstmt.setTimestamp(2, DataUtility.getCurrentTimestamp());
			pstmt.setLong(3, id);

			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (SQLException e) {
			log.error("Database Exception..", e);
			JDBCDataSrc.trnRollback(conn);
			throw new ApplicationException(e.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCDataSrc.closeConnection(conn);
		}
		log.debug("Model update End");
	}

	/**
	 * Updates modified by info
	 *
	 * @param model
	 * @throws Exception
	 */
	public void updateModifiedInfo() throws Exception {

		log.debug("Model update Started");
		Connection conn = null;

		String sql = "UPDATE " + getTableName() + " SET MODIFIED_BY=?, MODIFIED_DATETIME=? WHERE ID=?";

		try {
			conn = JDBCDataSrc.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modifiedBy);
			pstmt.setTimestamp(2, DataUtility.getCurrentTimestamp());
			pstmt.setLong(3, id);
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (SQLException e) {
			log.error("Database Exception..", e);
			JDBCDataSrc.trnRollback(conn);
		} finally {
			JDBCDataSrc.closeConnection(conn);
		}
		log.debug("Model update End");
	}

	/**
	 * Populate Model from ResultSet
	 *
	 * @param model
	 * @param rs
	 * @return
	 */
	protected <T extends BaseModel> T populateModel(T model, ResultSet rs) throws SQLException {
		model.setId(rs.getLong("ID"));
		model.setCreatedBy(rs.getString("CREATED_BY"));
		model.setModifiedBy(rs.getString("MODIFIED_BY"));
		model.setCreatedDatetime(rs.getTimestamp("CREATED_DATETIME"));
		model.setModifiedDatetime(rs.getTimestamp("MODIFIED_DATETIME"));
		return model;
	}
}