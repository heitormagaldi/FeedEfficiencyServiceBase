/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.dao;

import embrapa.to.TOBase;
import embrapa.to.TORaca;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author Heitor
 */
public class DAORaca extends DAOBase {

    public DAORaca() {
    }

    @Override
    public JSONArray list(Connection c) throws Exception {
        String sql = "SELECT \"CODIGO\",\"DESCRICAO\" FROM public.\"Raca\" order by \"CODIGO\"";
        ResultSet rs = null;
        JSONArray ja = new JSONArray();

        try {
            rs = Data.executeQuery(c, sql);
            while (rs.next()) {
                TORaca t = new TORaca(rs);
                ja.put(t.getJson());

            }

        } finally {
            rs.close();
        }
        return ja;
    }

    @Override
    public TOBase get(Connection c, TOBase t) throws Exception {
        String sql = "SELECT \"CODIGO\",\"DESCRICAO\" FROM public.\"Raca\" WHERE \"CODIGO\" = ? ";
        ResultSet rs = null;

        try {
            TORaca to = (TORaca) t;
            rs = Data.executeQuery(c, sql, to.getCodigo());

            if (rs.next()) {
                return new TORaca(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }

    @Override
    public void delete(Connection c, TOBase t) throws Exception {
        String sql = "DELETE FROM public.\"Raca\" WHERE \"CODIGO\" = ?";

        TORaca to = (TORaca) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getCodigo());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void update(Connection c, TOBase t) throws Exception {
        String sql = "UPDATE public.\"Raca\" SET \"DESCRICAO\" = ? WHERE \"CODIGO\" = ?";

        TORaca to = (TORaca) t;

        List<Object> p = new ArrayList<Object>();
       
        p.add(to.getDescricao());
        p.add(to.getCodigo());
       
        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void insert(Connection c, TOBase t) throws Exception {
        String sql = "INSERT INTO public.\"Raca\"(\"CODIGO\",\"DESCRICAO\") VALUES(?,?)";

        TORaca to = (TORaca) t;

        List<Object> p = new ArrayList<Object>();
       
        p.add(to.getCodigo());
        p.add(to.getDescricao());
        
        Data.executeUpdate(c, sql, p);

    }

}
