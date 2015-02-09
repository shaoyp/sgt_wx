package com.zdaq.group.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.zdaq.group.model.Group;
import com.zdaq.utils.DBUtils;

public class GroupDao {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	public Group getGroup(int id){
		Group group = new Group();
		try {
			if (null == conn || conn.isClosed()) {
				conn = DBUtils.getConnection();
			}
			String sql = "SELECT id,"
					+ "			 name,"
					+ "			 price,"
					+ "			 discount_price,"
					+ "			 people_num,"
					+ "			 num,"
					+ "			 dead_line,"
					+ "          img,"
					+ "			 del_flg"
					+ "     FROM fast_group_info"
					+ "    WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				group.setId(rs.getInt("id"));
				group.setName(rs.getString("name"));
				group.setPrice(rs.getDouble("price"));
				group.setDiscount_private(rs.getDouble("discount_price"));
				group.setPeople_num(rs.getInt("people_num"));
				group.setNum(rs.getInt("num"));
				group.setDead_line(rs.getDate("dead_line"));
				group.setImg(rs.getString("img"));
				group.setDel_flg(rs.getString("del_flg"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(stmt, rs);
		}

		return group;
	}
	public int insert(Map<String,Object> map){
		String openid = (String) map.get("openid");
		int num =  (int) map.get("num");
		double price =  (double) map.get("price");
		int count = 0;
		try {

			if (null == conn || conn.isClosed()) {
				conn = DBUtils.getConnection();
			}
		String sql ="INSERT INTO " +
				"          fast_group_order " +
				"              (user_id," +
				"               num," +
				"               price" +
				"              )VALUES(?,?,?,?)";
		stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, openid);
		stmt.setInt(2, num);
		stmt.setDouble(3, price);
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
