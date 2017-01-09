/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.dao;

import embrapa.to.TOBase;
import embrapa.to.TOBebedouro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author Heitor
 */
public class DAOBebedouro extends DAOBase {

    public DAOBebedouro() {
    }

    @Override
    public JSONArray list(Connection c) throws Exception {
        String sql = "SELECT \"CODIGO\",\"ANIMAL\",\"ID\",\"PESO\",\"DURACAO\""
                + ",\"CONSUMIDO\",\"DATA\",\"HORA\" FROM public.\"Bebedouro\" LIMIT '100' ";
        //order by \"CODIGO\"
        ResultSet rs = null;
        JSONArray ja = new JSONArray();

        try {
            rs = Data.executeQuery(c, sql);
            while (rs.next()) {
                TOBebedouro t = new TOBebedouro(rs);
                ja.put(t.getJson());

            }

        } finally {
            rs.close();
        }
        return ja;
    }

    @Override
    public TOBase get(Connection c, TOBase t) throws Exception {
        String sql = "SELECT \"CODIGO\",\"ANIMAL\",\"ID\",\"PESO\",\"DURACAO\""
                + ",\"CONSUMIDO\",\"DATA\",\"HORA\" FROM public.\"Bebedouro\" WHERE \"CODIGO\" = ? ";

        ResultSet rs = null;

        try {
            TOBebedouro to = (TOBebedouro) t;
            rs = Data.executeQuery(c, sql, to.getCodigo());

            if (rs.next()) {
                return new TOBebedouro(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }

    @Override
    public void delete(Connection c, TOBase t) throws Exception {
        String sql = "DELETE FROM public.\"Bebedouro\" WHERE \"CODIGO\" = ?";

        TOBebedouro to = (TOBebedouro) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getCodigo());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void update(Connection c, TOBase t) throws Exception {
        String sql = "UPDATE public.\"Bebedouro\" SET \"ANIMAL\" = ?,"
                + " \"ID\" = ? ,\"PESO\" = ? ,\"DURACAO\" = ?"
                + ",\"CONSUMIDO\" = ?,\"DATA\" = ?,\"HORA\" = ? WHERE \"CODIGO\" = ?";

        TOBebedouro to = (TOBebedouro) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getAnimal());
        p.add(to.getId());
        p.add(to.getPeso());
        p.add(to.getDuracao());
        p.add(to.getConsumido());
        p.add(to.getData());
        p.add(to.getHora());
        p.add(to.getCodigo());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void insert(Connection c, TOBase t) throws Exception {

        String sql = "INSERT INTO public.\"Bebedouro\""
                + "(\"CODIGO\",\"ANIMAL\",\"ID\",\"PESO\",\"DURACAO\","
                + "\"CONSUMIDO\",\"DATA\",\"HORA\")"
                + "VALUES"
                + "(?,?,?,?,?,?,?,?)";

        TOBebedouro to = (TOBebedouro) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getCodigo());
        p.add(to.getAnimal());
        p.add(to.getId());
        p.add(to.getPeso());
        p.add(to.getDuracao());
        p.add(to.getConsumido());
        p.add(to.getData());
        p.add(to.getHora());
        
        Data.executeUpdate(c, sql, p);

    }

}
