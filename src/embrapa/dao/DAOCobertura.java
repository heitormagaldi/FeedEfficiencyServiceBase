/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.dao;

import embrapa.to.TOBase;
import embrapa.to.TOCobertura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author Heitor
 */
public class DAOCobertura extends DAOBase {

    public DAOCobertura() {
    }

    @Override
    public JSONArray list(Connection c) throws Exception {
        String sql = "SELECT \"CODIGO\",\"PAI\",\"MAE\",\"RECEPTORA\",\"DATA\""
                + ",\"TIPO\" FROM public.\"Cobertura\" order by \"CODIGO\"";
        ResultSet rs = null;
        JSONArray ja = new JSONArray();

        try {
            rs = Data.executeQuery(c, sql);
            while (rs.next()) {
                TOCobertura t = new TOCobertura(rs);
                ja.put(t.getJson());

            }

        } finally {
            rs.close();
        }
        return ja;
    }

    @Override
    public TOBase get(Connection c, TOBase t) throws Exception {
        String sql = "SELECT \"CODIGO\",\"PAI\",\"MAE\",\"RECEPTORA\",\"DATA\""
                + ",\"TIPO\" FROM public.\"Cobertura\" WHERE \"CODIGO\" = ? ";
                
        ResultSet rs = null;

        try {
            TOCobertura to = (TOCobertura) t;
            rs = Data.executeQuery(c, sql, to.getCodigo());

            if (rs.next()) {
                return new TOCobertura(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }

    @Override
    public void delete(Connection c, TOBase t) throws Exception {
        String sql = "DELETE FROM public.\"Cobertura\" WHERE \"CODIGO\" = ?";

        TOCobertura to = (TOCobertura) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getCodigo());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void update(Connection c, TOBase t) throws Exception {
        String sql = "UPDATE public.\"Cobertura\" SET \"PAI\" = ?,"
                + " \"MAE\" = ? ,\"RECEPTORA\" = ? ,\"DATA\" = ?"
                + ",\"TIPO\" = ? WHERE \"CODIGO\" = ?";

        TOCobertura to = (TOCobertura) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getPai());
        p.add(to.getMae());
        p.add(to.getReceptora());
        p.add(to.getData());
        p.add(to.getTipo());
        p.add(to.getCodigo());
        
        

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void insert(Connection c, TOBase t) throws Exception {

        String sql = "INSERT INTO public.\"Cobertura\""
                + "(\"CODIGO\",\"PAI\",\"MAE\",\"RECEPTORA\",\"DATA\",\"TIPO\")"
                + "VALUES"
                + "(?,?,?,?,?,?)";

        TOCobertura to = (TOCobertura) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getCodigo());
        p.add(to.getPai());
        p.add(to.getMae());
        p.add(to.getReceptora());
        p.add(to.getData());
        p.add(to.getTipo());
      
        Data.executeUpdate(c, sql, p);

    }

}
