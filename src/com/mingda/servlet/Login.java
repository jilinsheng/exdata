package com.mingda.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.mingda.database.DBconn;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String userpwd = request.getParameter("password");
		System.out.println(username+">>>>"+userpwd);
		boolean flag = false;
		DBconn db = new DBconn();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			String sql = "select * from exuser t where t.username=? and t.userpwd=?";
			con = db.getJDBCConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, userpwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("USERNAME")+">>>>"+rs.getString("ORGANIZATION_ID"));
				map.put(rs.getString("DS"), rs.getString("DS"));
				map.put("ORGANIZATION_ID", rs.getString("ORGANIZATION_ID"));
				map.put("USERNAME", rs.getString("USERNAME"));
				flag = true;
			}
			System.out.println(sql);
			System.out.println(flag);
			if (flag) {
				response.sendRedirect("page/main.jsp");
				session.setAttribute("map", map);
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(con, ps, rs);
		}

	}

}
