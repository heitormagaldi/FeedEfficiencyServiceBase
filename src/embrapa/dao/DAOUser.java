/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.dao;

import embrapa.to.TOBase;
import embrapa.to.TOUser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author Heitor
 */
public class DAOUser extends DAOBase {

    public DAOUser() {
    }

    @Override
    public JSONArray list(Connection c) throws Exception {
        String sql = "SELECT \"ID\",\"LOGIN\",\"PERFIL\",\"EMAIL\",\"SENHA\" FROM public.\"Usuario\" order by \"LOGIN\"";
        ResultSet rs = null;
        JSONArray ja = new JSONArray();

        try {
            rs = Data.executeQuery(c, sql);
            while (rs.next()) {
                TOUser t = new TOUser(rs);
                ja.put(t.getJson());

            }

        } finally {
            rs.close();
        }
        return ja;
    }

    @Override
    public TOBase get(Connection c, TOBase t) throws Exception {
        String sql = "SELECT \"ID\",\"LOGIN\",\"PERFIL\",\"EMAIL\",\"SENHA\" FROM public.\"Usuario\" WHERE \"ID\" = ? ";
        ResultSet rs = null;

        try {
            TOUser to = (TOUser) t;
            rs = Data.executeQuery(c, sql, to.getId());

            if (rs.next()) {
                return new TOUser(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }

    @Override
    public void delete(Connection c, TOBase t) throws Exception {
        String sql = "DELETE FROM public.\"Usuario\" WHERE \"ID\" = ?";

        TOUser to = (TOUser) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getLogin());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void update(Connection c, TOBase t) throws Exception {
        String sql = "UPDATE public.\"Usuario\" SET \"LOGIN\" = ?, \"SENHA\" = ? ,\"PERFIL\" = ? ,\"EMAIL\" = ? WHERE \"ID\" = ?";

        TOUser to = (TOUser) t;

        List<Object> p = new ArrayList<Object>();
       
        p.add(to.getLogin());
        p.add(to.getSenha());
        p.add(to.getPerfil());
        p.add(to.getEmail());
        p.add(to.getId());
        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void insert(Connection c, TOBase t) throws Exception {
        String sql = "INSERT INTO public.\"Usuario\"(\"ID\",\"LOGIN\",\"SENHA\",\"PERFIL\",\"EMAIL\") VALUES(?,?,?,?,?)";

        TOUser to = (TOUser) t;

        List<Object> p = new ArrayList<Object>();
       
        p.add(to.getId());
        p.add(to.getLogin());
        p.add(to.getSenha());
        p.add(to.getPerfil());
        p.add(to.getEmail());

        Data.executeUpdate(c, sql, p);

    }

}
