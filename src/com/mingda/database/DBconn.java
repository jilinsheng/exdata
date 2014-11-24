/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mingda.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DBconn {

	private String ds;

	public DBconn(String ds) {
		this.ds = ds;
	}

	public DBconn() {
		this.ds = "";
	}

	public Connection getJDBCConn() throws ClassNotFoundException, SQLException {
		if ("cs".equals(ds)) {
			return this.getJDBCConnCS();
		} else if ("nc".equals(ds)) {
			return this.getJDBCConnNC();
		} else {
			return this.getJDBCConnDS();
		}
	}

	public Connection getJDBCConnDS() throws SQLException,
			ClassNotFoundException {
		Connection con = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.2.1.23:1521:orcl";
			String userName = "datashare";
			String password = "datashare";

			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException | ClassNotFoundException ex) {
			throw ex;
		}
		return con;
	}

	public Connection getJDBCConnCS() throws SQLException,
			ClassNotFoundException {
		Connection con = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.1.0.23:1521:jldb1";
			String userName = "jldbcs";
			String password = "jldbcs";

			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException | ClassNotFoundException ex) {
			throw ex;
		}
		return con;
	}

	public Connection getJDBCConnNC() throws SQLException,
			ClassNotFoundException {
		Connection con = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.1.0.33:1521:ncdb1";
			String userName = "summer";
			String password = "summer";

			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException | ClassNotFoundException ex) {
			throw ex;
		}
		return con;
	}

	public void close(Connection con) {
		try {
			if (null != con) {
				con.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBconn.class.getName())
					.log(Level.SEVERE, null, ex);
		}
	}

	public void close(Connection con, PreparedStatement ps) {
		try {
			if (null != ps) {
				ps.close();
			}
			if (null != con) {
				con.close();
			}

		} catch (SQLException ex) {
			Logger.getLogger(DBconn.class.getName())
					.log(Level.SEVERE, null, ex);
		}
	}

	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (null != rs) {
				rs.close();
			}
			if (null != ps) {
				ps.close();
			}
			if (null != con) {
				con.close();
			}

		} catch (SQLException ex) {
			Logger.getLogger(DBconn.class.getName())
					.log(Level.SEVERE, null, ex);
		}
	}
}
