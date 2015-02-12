package com.zdaq.priOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.zdaq.utils.DBUtils;

public class PriOrderDao {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	public int insert(Map<String,Object> map){
		String openid = (String) map.get("openid");
		String priContent = (String) map.get("priContent");
		int count = 0;
		try {

			if (null == conn || conn.isClosed()) {
				conn = DBUtils.getConnection();
			}
		String sql ="INSERT INTO " +
				"          fast_private_order " +
				"             (user_id," +
				"              odrder" +
				"       )VALUES(?,?)";
		stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, openid);
		stmt.setString(2, priContent);
		count = stmt.executeUpdate();
		rs= stmt.getGeneratedKeys();
		if (rs != null&&rs.next()) {  
			count=rs.getInt(1);  
		} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,stmt, rs);
		}
		return count;
	}
}
