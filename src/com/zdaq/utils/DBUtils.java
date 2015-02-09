package com.zdaq.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DBUtils {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static DataSource ds = new DruidDataSource();
	static{
		Properties ps = new Properties();
			try {
				ps.load(DBUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
				ds = DruidDataSourceFactory.createDataSource(ps);
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public static Connection getConnection(){
		Connection conn = tl.get();
		try {
			if(null == conn || conn.isClosed()){
				conn = ds.getConnection();
				tl.set(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}


	public static void close(Connection conn, PreparedStatement stmt,
			ResultSet rs) {
		try {
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			tl.remove();
		}
	}
	public static void close(PreparedStatement stmt,ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection conn){
		conn = tl.get();
		tl.set(null);
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				tl.remove();
			}
			
		}
		
	}
	public static TransactionManager getTranManager() {
		return new TransactionManager(getConnection());
	}
}