package com.mingda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mingda.exdata.ApplyDTO;
import com.mingda.exdata.ReadData;

/**
 * Servlet implementation class QueryData
 */
@WebServlet("/page/QueryData")
public class QueryData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryData() {
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
		List<ApplyDTO> list = null;
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		HashMap map = (HashMap) session.getAttribute("map");
		String o2 = (String) map.get("ORGANIZATION_ID");
		ReadData rd = new ReadData();

		String ds = "";

		/* c-cs p-cs c-nc p-nc */

		String c_cs = (String) map.get("c-cs");
		String p_cs = (String) map.get("p-cs");
		String c_nc = (String) map.get("c-nc");
		String p_nc = (String) map.get("p-nc");

		if ("c-cs".equals(c_cs) || "p-cs".equals(p_cs)) {
			if ("csadd".equals(type)) {
				ds = "cs";
				list = rd.getData4(o2, ds);

			}
			if ("cszb".equals(type)) {
				ds = "cs";
				list = rd.getData2(o2, ds);

			}
		}

		if ("c-nc".equals(c_nc) || "p-nc".equals(p_nc)) {

			if ("ncadd".equals(type)) {
				ds = "nc";

				list = rd.getData4(o2, ds);

			}
			if ("nczb".equals(type)) {
				ds = "nc";
				list = rd.getData2(o2, ds);

			}
		}
		JSONObject json = new JSONObject();
		if (null != list) {
			JSONArray jsArr = JSONArray.fromObject(list);
			json.put("total", list.size());
			json.put("rows", jsArr.toString());
		} else {
			json.put("total", 0);
			json.put("rows", null);
		}
		pw.write(json.toString());
		pw.flush();
		pw.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		List<ApplyDTO> list = null;
		String type = request.getParameter("type");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		Integer p = new Integer(page);
		Integer r = new Integer(rows);

		HttpSession session = request.getSession();
		HashMap map = (HashMap) session.getAttribute("map");
		String o2 = (String) map.get("ORGANIZATION_ID");
		ReadData rd = new ReadData();

		String ds = "";

		/* c-cs p-cs c-nc p-nc */

		String c_cs = (String) map.get("c-cs");
		String p_cs = (String) map.get("p-cs");
		String c_nc = (String) map.get("c-nc");
		String p_nc = (String) map.get("p-nc");

		if ("c-cs".equals(c_cs) || "p-cs".equals(p_cs)) {
			if ("csadd".equals(type)) {
				ds = "cs";
				list = rd.getData4(o2, ds);

			}
			if ("cszb".equals(type)) {
				ds = "cs";
				list = rd.getData2(o2, ds);

			}
		}

		if ("c-nc".equals(c_nc) || "p-nc".equals(p_nc)) {

			if ("ncadd".equals(type)) {
				ds = "nc";

				list = rd.getData4(o2, ds);

			}
			if ("nczb".equals(type)) {
				ds = "nc";
				list = rd.getData2(o2, ds);

			}
		}
		List<ApplyDTO> templist = new ArrayList<ApplyDTO>();
		JSONObject json = new JSONObject();
		if (null != list) {

			for (int i = (p - 1) * r; i < p * r; i++) {
				if (i == list.size()) {
					break;
				}
				templist.add(list.get(i));
			}

			JSONArray jsArr = JSONArray.fromObject(templist);
			json.put("total", list.size());
			json.put("rows", jsArr.toString());
		} else {
			json.put("total", 0);
			json.put("rows", "");
		}
		pw.write(json.toString());
		pw.flush();
		pw.close();
	}

}
