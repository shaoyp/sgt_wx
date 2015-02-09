package com.zdaq.utils;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * TransactionManager.java
 * @Description :事务管理
 * @Date : 2014-9-3
 * @Version : 1.0
 * @Author : 邵云鹏
 */
public class TransactionManager {
	private Connection conn;
	public TransactionManager(Connection conn) {
		this.conn = conn;
	}
	//开启事务
	public void beginTransaction(){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//提交事务并关闭连接
	public void commitAndClose(){
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
		}
	}
	//回滚并关闭连接
	public void rollbackAndClose(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
		}
	}
	//关闭连接
	public void Close(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
		}
	}

}
