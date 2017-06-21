package org.light4j.servlet.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.Data;

@Data
public class DbDao {
	private Connection conn;
	private String driver;
	private String url;
	private String username;
	private String pass;

	public DbDao() {
	}

	public DbDao(String driver, String url, String username, String pass) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.pass = pass;
	}

	// 获取数据库连接
	public Connection getConnection() throws Exception {
		if (conn == null) {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(url, username, this.pass);
		}
		return conn;
	}

	// 插入记录
	public boolean insert(String sql, Object... args) throws Exception {
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			pstmt.setObject(i + 1, args[i]);
		}
		if (pstmt.executeUpdate() != 1) {
			return false;
		}
		pstmt.close();
		return true;
	}

	// 执行查询
	public ResultSet query(String sql, Object... args) throws Exception {
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			pstmt.setObject(i + 1, args[i]);
		}
		return pstmt.executeQuery();
	}

	// 执行修改
	public void modify(String sql, Object... args) throws Exception {
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			pstmt.setObject(i + 1, args[i]);
		}
		pstmt.executeUpdate();
		pstmt.close();
	}

	// 关闭数据库连接的方法
	public void closeConn() throws Exception {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
}