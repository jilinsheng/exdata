/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mingda.exdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mingda.database.DBconn;

/**
 *
 * @author Administrator
 */
public class ReadData {

	public List<ApplyDTO> getData1(String onno, String ds) {
		List<ApplyDTO> list = new ArrayList<ApplyDTO>();
		DBconn db = new DBconn();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select t.mastername as aname, "
				+ " t.masteridcard as idcard, "
				+ " '身份证' as idtype, "
				+ " to_char(sysdate, 'yyyy-MM-dd') as wt, "
				+ " t.familyid ,"
				+ " t.income1, t.income2, t.income3, "
				+ " t.income4, t.income5, t.income6, "
				+ " t.income7,  t.income8, t.income9, "
				+ " t.income10, t.married, t.sicken, "
				+ " t.deformity,  t.defgrade, t.labor,t.fmsort,t.job "
				+ " from excurrent1 t where t.relmaster = '本人' and t.familyno like ? and t.ds like ?";
		System.out.println(sql);
		try {
			conn = db.getJDBCConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, onno + "%");
			ps.setString(2, "%" + ds + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ApplyDTO e = new ApplyDTO();
				e.setFamilyid(rs.getString("FAMILYID"));
				e.setIdtype(rs.getString("IDTYPE"));
				e.setWt(rs.getString("WT"));
				e.setMasteridcard(rs.getString("IDCARD"));
				e.setMastername(rs.getString("ANAME"));

				e.setIncome1(rs.getString("income1"));
				e.setIncome2(rs.getString("income2"));
				e.setIncome3(rs.getString("income3"));
				e.setIncome4(rs.getString("income4"));
				e.setIncome5(rs.getString("income5"));
				e.setIncome6(rs.getString("income6"));
				e.setIncome7(rs.getString("income7"));
				e.setIncome8(rs.getString("income8"));
				e.setIncome9(rs.getString("income9"));
				e.setIncome10(rs.getString("income10"));

				e.setMarried(rs.getString("married"));
				e.setSicken(rs.getString("sicken"));
				e.setDeformity(rs.getString("deformity"));
				e.setDefgrade(rs.getString("defgrade"));
				e.setLabor(rs.getString("labor"));
				e.setFmsort(rs.getString("fmsort"));
				e.setJob(rs.getString("job"));
				list.add(e);
			}

		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(ReadData.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			db.close(conn, ps, rs);
		}
		return list;
	}

	public List<ApplyDTO> getData3(String onno, String ds) {
		List<ApplyDTO> list = new ArrayList<ApplyDTO>();
		DBconn db = new DBconn();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select t.mastername as aname, "
				+ " t.masteridcard as idcard, "
				+ " '身份证' as idtype, "
				+ " to_char(sysdate, 'yyyy-MM-dd') as wt, "
				+ " t.familyid ,"
				+ " t.income1, t.income2, t.income3, "
				+ " t.income4, t.income5, t.income6, "
				+ " t.income7,  t.income8, t.income9, "
				+ " t.income10, t.married, t.sicken, "
				+ " t.deformity,  t.defgrade, t.labor,t.fmsort,t.job "
				+ " from exaddnew1 t where to_char( t.ctime,'yyyy-MM')=to_char( sysdate,'yyyy-MM') and "
				+ "t.relmaster = '本人' and t.familyno like ? and t.ds like ?";
		System.out.println(sql);
		try {
			conn = db.getJDBCConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, onno + "%");
			ps.setString(2, "%" + ds + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ApplyDTO e = new ApplyDTO();
				e.setFamilyid(rs.getString("FAMILYID"));
				e.setIdtype(rs.getString("IDTYPE"));
				e.setWt(rs.getString("WT"));
				e.setMasteridcard(rs.getString("IDCARD"));
				e.setMastername(rs.getString("ANAME"));
				
				e.setIncome1(rs.getString("income1"));
				e.setIncome2(rs.getString("income2"));
				e.setIncome3(rs.getString("income3"));
				e.setIncome4(rs.getString("income4"));
				e.setIncome5(rs.getString("income5"));
				e.setIncome6(rs.getString("income6"));
				e.setIncome7(rs.getString("income7"));
				e.setIncome8(rs.getString("income8"));
				e.setIncome9(rs.getString("income9"));
				e.setIncome10(rs.getString("income10"));

				e.setMarried(rs.getString("married"));
				e.setSicken(rs.getString("sicken"));
				e.setDeformity(rs.getString("deformity"));
				e.setDefgrade(rs.getString("defgrade"));
				e.setLabor(rs.getString("labor"));
				e.setFmsort(rs.getString("fmsort"));
				e.setJob(rs.getString("job"));
				list.add(e);
			}

		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(ReadData.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			db.close(conn, ps, rs);
		}
		return list;
	}

	public List<ApplyDTO> getData2(String onno, String ds) {
		List<ApplyDTO> list = new ArrayList<ApplyDTO>();
		DBconn db = new DBconn();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select t.mastername as mastername,t.masteridcard as idcard, "
				+ " t.membername   as fm_name, "
				+ " t.sex          as fm_sex, "
				+ " t.memberidcard as fm_paperid, "
				+ " t.relmaster    as fm_relmaster, "
				+ " t.familyid     as familyid, "
				+ " t.memberid     as fm_id ,"
				+ " t.income1, t.income2, t.income3, "
				+ " t.income4, t.income5, t.income6, "
				+ " t.income7,  t.income8, t.income9, "
				+ " t.income10, t.married, t.sicken, "
				+ " t.deformity,  t.defgrade, t.labor,t.fmsort,t.job "
				+ " from excurrent1 t "
				+ " where  t.familyno like ? and t.ds like ?";
		System.out.println(sql);
		try {
			conn = db.getJDBCConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, onno + "%");
			ps.setString(2, "%" + ds + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ApplyDTO e = new ApplyDTO();
				e.setMasteridcard(rs.getString("idcard"));
				e.setMembername(rs.getString("fm_name"));
				e.setMemberidcard(rs.getString("fm_paperid"));
				e.setSex(rs.getString("fm_sex"));
				e.setRelmaster(rs.getString("fm_relmaster"));
				e.setFamilyid(rs.getString("familyid"));
				e.setMemberid(rs.getString("fm_id"));
				e.setMastername(rs.getString("mastername"));

				e.setIncome1(rs.getString("income1"));
				e.setIncome2(rs.getString("income2"));
				e.setIncome3(rs.getString("income3"));
				e.setIncome4(rs.getString("income4"));
				e.setIncome5(rs.getString("income5"));
				e.setIncome6(rs.getString("income6"));
				e.setIncome7(rs.getString("income7"));
				e.setIncome8(rs.getString("income8"));
				e.setIncome9(rs.getString("income9"));
				e.setIncome10(rs.getString("income10"));

				e.setMarried(rs.getString("married"));
				e.setSicken(rs.getString("sicken"));
				e.setDeformity(rs.getString("deformity"));
				e.setDefgrade(rs.getString("defgrade"));
				e.setLabor(rs.getString("labor"));
				e.setFmsort(rs.getString("fmsort"));
				e.setJob(rs.getString("job"));
				list.add(e);
			}

		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(ReadData.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			db.close(conn, ps, rs);
		}
		return list;
	}

	public List<ApplyDTO> getData4(String onno, String ds) {
		List<ApplyDTO> list = new ArrayList<ApplyDTO>();
		DBconn db = new DBconn();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select t.mastername as mastername, t.masteridcard as idcard, "
				+ " t.membername   as fm_name, "
				+ " t.sex          as fm_sex, "
				+ " t.memberidcard as fm_paperid, "
				+ " t.relmaster    as fm_relmaster, "
				+ " t.familyid     as familyid, "
				+ " t.memberid     as fm_id ,"
				+ " t.income1, t.income2, t.income3, "
				+ " t.income4, t.income5, t.income6, "
				+ " t.income7,  t.income8, t.income9, "
				+ " t.income10, t.married, t.sicken, "
				+ " t.deformity,  t.defgrade, t.labor,t.fmsort,t.job "
				+ " from exaddnew1 t  "
				+ " where to_char( t.ctime,'yyyy-MM')=to_char( sysdate,'yyyy-MM') and  t.familyno like ? and t.ds like ?";
		System.out.println(sql);
		try {
			conn = db.getJDBCConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, onno + "%");
			ps.setString(2, "%" + ds + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ApplyDTO e = new ApplyDTO();
				e.setMasteridcard(rs.getString("idcard"));
				e.setMembername(rs.getString("fm_name"));
				e.setMemberidcard(rs.getString("fm_paperid"));
				e.setSex(rs.getString("fm_sex"));
				e.setRelmaster(rs.getString("fm_relmaster"));
				e.setFamilyid(rs.getString("familyid"));
				e.setMemberid(rs.getString("fm_id"));
				e.setMastername(rs.getString("mastername"));

				e.setIncome1(rs.getString("income1"));
				e.setIncome2(rs.getString("income2"));
				e.setIncome3(rs.getString("income3"));
				e.setIncome4(rs.getString("income4"));
				e.setIncome5(rs.getString("income5"));
				e.setIncome6(rs.getString("income6"));
				e.setIncome7(rs.getString("income7"));
				e.setIncome8(rs.getString("income8"));
				e.setIncome9(rs.getString("income9"));
				e.setIncome10(rs.getString("income10"));

				e.setMarried(rs.getString("married"));
				e.setSicken(rs.getString("sicken"));
				e.setDeformity(rs.getString("deformity"));
				e.setDefgrade(rs.getString("defgrade"));
				e.setLabor(rs.getString("labor"));
				e.setFmsort(rs.getString("fmsort"));
				e.setJob(rs.getString("job"));
				
				list.add(e);
			}

		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(ReadData.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			db.close(conn, ps, rs);
		}
		return list;
	}

	public List<ApplyDTO> getDataFhs2(String onno, String ds) {
		List<ApplyDTO> list = new ArrayList<ApplyDTO>();
		DBconn db = new DBconn();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select paperid, chanquan, fh_number, laiyuan, fh_buildarea, on_no, ds from ccc_fh where 1<>1 and on_no like ? and ds like ?";
		System.out.println(sql);
		try {
			conn = db.getJDBCConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, onno + "%");
			ps.setString(2, "%" + ds + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ApplyDTO e = new ApplyDTO();
				e.setMasteridcard(rs.getString("paperid"));
				e.setChanquan(rs.getString("chanquan"));
				e.setFhnumber(rs.getString("fh_number"));
				e.setLaiyuan(rs.getString("laiyuan"));
				e.setFhbuildarea(rs.getString("fh_buildarea"));
				list.add(e);
			}

		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(ReadData.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			db.close(conn, ps, rs);
		}
		return list;
	}

	public List<ApplyDTO> getDataFhs1(String onno, String ds) {
		List<ApplyDTO> list = new ArrayList<ApplyDTO>();
		DBconn db = new DBconn();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select paperid, chanquan, fh_number, laiyuan, fh_buildarea, on_no, ds from ccc_fh where on_no like ? and ds like ?";
		System.out.println(sql);
		try {
			conn = db.getJDBCConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, onno + "%");
			ps.setString(2, "%" + ds + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ApplyDTO e = new ApplyDTO();
				e.setMasteridcard(rs.getString("paperid"));
				e.setChanquan(rs.getString("chanquan"));
				e.setFhnumber(rs.getString("fh_number"));
				e.setLaiyuan(rs.getString("laiyuan"));
				e.setFhbuildarea(rs.getString("fh_buildarea"));
				list.add(e);
			}

		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(ReadData.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			db.close(conn, ps, rs);
		}
		return list;
	}
}
