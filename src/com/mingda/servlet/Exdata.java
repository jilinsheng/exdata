package com.mingda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mingda.exdata.Gen;
import com.mingda.exdata.ReadData;

/**
 * Servlet implementation class Exdata
 */
@WebServlet("/page/Exdata")
public class Exdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Exdata() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		HashMap map = (HashMap) session.getAttribute("map");
		String s = UUID.randomUUID().toString();
		String o2 = (String) map.get("ORGANIZATION_ID");
		Gen g = new Gen();
		ReadData rd = new ReadData();

		String ds = "";
		String url = "无查询记录!";
		/* c-cs p-cs c-nc p-nc */

		String c_cs = (String) map.get("c-cs");
		String p_cs = (String) map.get("p-cs");
		String c_nc = (String) map.get("c-nc");
		String p_nc = (String) map.get("p-nc");

		if ("c-cs".equals(c_cs) || "p-cs".equals(p_cs)) {
			if ("csadd".equals(type)) {
				ds = "cs";
				g.GenXLS(s, "Z:\\ftproot\\yljz\\exdata", rd.getData3(o2, ds),
						rd.getData4(o2, ds));
				url = "<a href=\"http://" + request.getServerName() + ":"
						+ request.getServerPort() + "/yljz/exdata/" + s
						+ ".zip\" target=\"_blank\">下载文件</a>";
			}
			if ("cszb".equals(type)) {
				ds = "cs";
				g.GenXLS(s, "Z:\\ftproot\\yljz\\exdata", rd.getData1(o2, ds),
						rd.getData2(o2, ds));
				url = "<a href=\"http://" + request.getServerName() + ":"
						+ request.getServerPort() + "/yljz/exdata/" + s
						+ ".zip\" target=\"_blank\">下载文件</a>";
			}
		}

		if ("c-nc".equals(c_nc) || "p-nc".equals(p_nc)) {

			if ("ncadd".equals(type)) {
				ds = "nc";
				g.GenXLS(s, "Z:\\ftproot\\yljz\\exdata", rd.getData3(o2, ds),
						rd.getData4(o2, ds));
				url = "<a href=\"http://" + request.getServerName() + ":"
						+ request.getServerPort() + "/yljz/exdata/" + s
						+ ".zip\" target=\"_blank\">下载文件</a>";
			}
			if ("nczb".equals(type)) {
				ds = "nc";
				g.GenXLS(s, "Z:\\ftproot\\yljz\\exdata", rd.getData1(o2, ds),
						rd.getData2(o2, ds));
				url = "<a href=\"http://" + request.getServerName() + ":"
						+ request.getServerPort() + "/yljz/exdata/" + s
						+ ".zip\" target=\"_blank\">下载文件</a>";
			}
		}
		pw.write("<p align=\"center\">");
		pw.write(url);
		pw.write("</p>");
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("POST");
	}

}
