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
public class GenData {

    public void GenData1(List<String> onnos) {
        for (String onno : onnos) {
            Gen g = new Gen();
           // g.GenXLS(onno,null, "Z:\\exdata");
        }
    }

    public List<String> getlist() {
        List<String> list = new ArrayList<String>();
        DBconn db = new DBconn(null);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select on_no from organno o where o.on_level='2'";
        System.out.println(sql);
        try {
            conn = db.getJDBCConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String e = rs.getString(1);
                list.add(e);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ReadData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.close(conn, ps, rs);
        }
        return list;
    }
}
