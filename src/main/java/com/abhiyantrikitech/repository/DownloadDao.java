package com.abhiyantrikitech.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abhiyantrikitech.dto.DownloadRequest;
import com.abhiyantrikitech.util.JdbcConnection;

@Repository
public class DownloadDao {

	@Autowired
	JdbcConnection con;

	public DownloadRequest saveDonwloadRequest(DownloadRequest downloadRequest) throws Exception {
		try (Connection connection = con.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into tbl_downloads(userId,projectId,reason,status,"
								+ "createdBy,createdDt,lastUpdatedDt,lastUpdatedBy)" + "VALUES(?,?,?,?,?,?,?,?")) {

			preparedStatement.setLong(1, downloadRequest.getUserId());
			preparedStatement.setLong(2, downloadRequest.getProjectId());
			preparedStatement.setString(3, downloadRequest.getReason());
			preparedStatement.setString(4, downloadRequest.getStatus());
			preparedStatement.setString(5, downloadRequest.getCreatedBy());
			preparedStatement.setString(6, downloadRequest.getCreatedDt());
			preparedStatement.setString(7, downloadRequest.getLastUpdatedDt());
			preparedStatement.setString(8, downloadRequest.getLastUpdatedBy());

			int records = preparedStatement.executeUpdate();
			if (records != 0)
				downloadRequest.setRecordUpdate("true");
			else
				downloadRequest.setRecordUpdate("false");

		} catch (Exception e) {
			System.out.println("Exception occured " + e.getMessage());
		}
		return downloadRequest;
	}

	public DownloadRequest getDonwloadRequest(Long id) throws Exception {

		DownloadRequest downloadRequest = new DownloadRequest();
		try (Connection connection = con.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from tbl_downloads where id = ?")) {

			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				downloadRequest.setId(rs.getLong("id"));
				downloadRequest.setUserId(rs.getLong("userId"));
				downloadRequest.setProjectId(rs.getLong("projectId"));
				downloadRequest.setReason(rs.getString("reason"));
				downloadRequest.setStatus(rs.getString("reason"));
				downloadRequest.setCreatedDt(rs.getDate("createdDt").toString());
				downloadRequest.setCreatedBy(rs.getString("createdBy"));
				downloadRequest.setLastUpdatedBy(rs.getString("lastUpdatedBy"));
				downloadRequest.setLastUpdatedDt(rs.getDate("lastUpdatedDt").toString());
			}
			return downloadRequest;
		} catch (Exception e) {
			System.out.println("Exception occured " + e.getMessage());
		}
		return downloadRequest;
	}

	public List<DownloadRequest> getAllDonwloadRequest() throws Exception {

		DownloadRequest downloadRequest = null;
		List<DownloadRequest> downloads = new ArrayList<>();
		try (Connection connection = con.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_downloads")) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				downloadRequest = new DownloadRequest();
				downloadRequest.setId(rs.getLong("id"));
				downloadRequest.setUserId(rs.getLong("userId"));
				downloadRequest.setProjectId(rs.getLong("projectId"));
				downloadRequest.setReason(rs.getString("reason"));
				downloadRequest.setStatus(rs.getString("reason"));
				downloadRequest.setCreatedDt(rs.getDate("createdDt").toString());
				downloadRequest.setCreatedBy(rs.getString("createdBy"));
				downloadRequest.setLastUpdatedBy(rs.getString("lastUpdatedBy"));
				downloadRequest.setLastUpdatedDt(rs.getDate("lastUpdatedDt").toString());
				downloads.add(downloadRequest);
			}
			return downloads;
		} catch (Exception e) {
			System.out.println("Exception occured " + e.getMessage());
		}
		return new ArrayList<>();
	}

	public DownloadRequest updateDownloadRequestById(DownloadRequest downloadRequest, Long id) throws Exception {
		DownloadRequest updateDownloadRequestd = new DownloadRequest();
		if (isUpdateDownloadRequestById(updateDownloadRequestd, id))
			return getDonwloadRequest(id);

		return new DownloadRequest();
	}

	public boolean isUpdateDownloadRequestById(DownloadRequest downloadRequest, Long id) {
		String query = "update tbl_downloads set userId=?,projectId=?,reason=?,status=?,lastUpdatedBy=?,lastUpdatedDt= now() where id = ?";
		try (Connection connection = con.getConnection(); PreparedStatement st = connection.prepareStatement(query)) {
			st.setLong(1, downloadRequest.getUserId());
			st.setLong(2, downloadRequest.getProjectId());
			st.setString(3, downloadRequest.getReason());
			st.setString(4, downloadRequest.getStatus());
			st.setString(5, downloadRequest.getLastUpdatedBy());
			st.setString(6, downloadRequest.getLastUpdatedDt());
			int rs = st.executeUpdate();
			return rs != 0;
		} catch (Exception e) {
			System.out.println("Error came " + e.getMessage());
		}
		return false;
	}
}