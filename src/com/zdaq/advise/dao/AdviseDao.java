package com.zdaq.advise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.zdaq.utils.DBUtils;

public class AdviseDao {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	public int insert(Map<String,Object> map){
		String advise = (String) map.get("advise");
		int count = 0;
		try {

			if (null == conn || conn.isClosed()) {
				conn = DBUtils.getConnection();
			}
		String sql ="INSERT INTO " +
				"          fast_advise " +
				"             (user_id," +
				"              advise" +
				"       )VALUES(?,?)";
		stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, 12345);
		stmt.setString(2, advise);
		count = stmt.executeUpdate();
		rs= stmt.getGeneratedKeys();
		if (rs != null&&rs.next()) {  
			count=rs.getInt(1);  
		} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(stmt, rs);
		}
		return count;
	}

}
