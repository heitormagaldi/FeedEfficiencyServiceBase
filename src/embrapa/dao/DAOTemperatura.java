/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.dao;

import embrapa.to.TOBase;
import embrapa.to.TOTemperatura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author Heitor
 */
public class DAOTemperatura extends DAOBase {

    public DAOTemperatura() {
    }

    @Override
    public JSONArray listCodigo(Connection c, TOBase t) throws Exception {
        String sql = "SELECT \"CODIGO\",\"VALOR\",\"EQUIPAMENTO\",\"SENSOR\","
                + "\"DATA\",\"HORA\" FROM public.\"Temperatura\" WHERE \"SENSOR\" = ?  LIMIT '100'";
        //order by \"CODIGO\"
        ResultSet rs = null;
        JSONArray ja = new JSONArray();
        
        TOTemperatura to = (TOTemperatura) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getSensor());
                 

        //Data.executeUpdate(c, sql, p);
        
        try {
            rs = Data.executeQuery(c, sql,p);
            while (rs.next()) {
                to = new TOTemperatura(rs);
                ja.put(to.getJson());
            }

        } finally {
            rs.close();
        }
        return ja;
    }
    
    @Override
    public JSONArray list(Connection c) throws Exception {
        String sql = "SELECT \"CODIGO\",\"VALOR\",\"EQUIPAMENTO\",\"SENSOR\""
                + ",\"DATA\",\"HORA\" FROM public.\"Temperatura\" LIMIT '100' ";
        //order by \"CODIGO\"
        ResultSet rs = null;
        JSONArray ja = new JSONArray();

        try {
            rs = Data.executeQuery(c, sql);
            while (rs.next()) {
                TOTemperatura t = new TOTemperatura(rs);
                ja.put(t.getJson());

            }

        } finally {
            rs.close();
        }
        return ja;
    }

    @Override
    public TOBase get(Connection c, TOBase t) throws Exception {
        String sql = "SELECT \"CODIGO\",\"VALOR\",\"EQUIPAMENTO\",\"SENSOR\""
                + ",\"DATA\",\"HORA\" FROM public.\"Temperatura\" WHERE \"CODIGO\" = ? ";

        ResultSet rs = null;

        try {
            TOTemperatura to = (TOTemperatura) t;
            rs = Data.executeQuery(c, sql, to.getCodigo());

            if (rs.next()) {
                return new TOTemperatura(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }

    @Override
    public void delete(Connection c, TOBase t) throws Exception {
        String sql = "DELETE FROM public.\"Temperatura\" WHERE \"CODIGO\" = ?";

        TOTemperatura to = (TOTemperatura) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getCodigo());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void update(Connection c, TOBase t) throws Exception {
        String sql = "UPDATE public.\"Temperatura\" SET \"VALOR\" = ?,"
                + " \"EQUIPAMENTO\" = ? ,\"SENSOR\" = ? ,\"DATA\" = ?,\"HORA\" = ? WHERE \"CODIGO\" = ?";

        TOTemperatura to = (TOTemperatura) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getValor());
        p.add(to.getEquipamento());
        p.add(to.getSensor());
        p.add(to.getData());
        p.add(to.getHora());
        p.add(to.getCodigo());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void insert(Connection c, TOBase t) throws Exception {

        String sql = "INSERT INTO public.\"Temperatura\""
                + "(\"CODIGO\",\"VALOR\",\"EQUIPAMENTO\",\"SENSOR\",\"DATA\",\"HORA\")"
                + "VALUES"
                + "(?,?,?,?,?,?)";

        TOTemperatura to = (TOTemperatura) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getCodigo());
        p.add(to.getValor());
        p.add(to.getEquipamento());
        p.add(to.getSensor());
        p.add(to.getData());
        p.add(to.getHora());
        
        
        
        Data.executeUpdate(c, sql, p);

    }

}
