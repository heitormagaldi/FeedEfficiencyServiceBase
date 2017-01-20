/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.dao;

import embrapa.to.TOBase;
import embrapa.to.TORefeicao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author Heitor
 */
public class DAORefeicao extends DAOBase {

    public DAORefeicao() {
    }

    @Override
    public JSONArray listCodigo(Connection c, TOBase t) throws Exception {
        String sql = "SELECT \"CODIGO\",\"ANIMAL\",\"ID\",\"PESO\",\"DURACAO\""
                + ",\"CONSUMIDO\",\"DATA\",\"HORA\" FROM public.\"Refeicao\" WHERE \"ANIMAL\" = ?  LIMIT '100'";
        //order by \"CODIGO\"
        ResultSet rs = null;
        JSONArray ja = new JSONArray();
        
        TORefeicao to = (TORefeicao) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getCodigo());
                 

        //Data.executeUpdate(c, sql, p);
        
        try {
            rs = Data.executeQuery(c, sql,p);
            while (rs.next()) {
                to = new TORefeicao(rs);
                ja.put(to.getJson());
            }

        } finally {
            rs.close();
        }
        return ja;
    }
    
    @Override
    public JSONArray list(Connection c) throws Exception {
        String sql = "SELECT \"CODIGO\",\"ANIMAL\",\"ID\",\"PESO\",\"DURACAO\""
                + ",\"CONSUMIDO\",\"DATA\",\"HORA\" FROM public.\"Refeicao\" LIMIT '100' ";
        //order by \"CODIGO\"
        ResultSet rs = null;
        JSONArray ja = new JSONArray();

        try {
            rs = Data.executeQuery(c, sql);
            while (rs.next()) {
                TORefeicao t = new TORefeicao(rs);
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
                + ",\"CONSUMIDO\",\"DATA\",\"HORA\" FROM public.\"Refeicao\" WHERE \"CODIGO\" = ? ";

        ResultSet rs = null;

        try {
            TORefeicao to = (TORefeicao) t;
            rs = Data.executeQuery(c, sql, to.getCodigo());

            if (rs.next()) {
                return new TORefeicao(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }

    @Override
    public void delete(Connection c, TOBase t) throws Exception {
        String sql = "DELETE FROM public.\"Refeicao\" WHERE \"CODIGO\" = ?";

        TORefeicao to = (TORefeicao) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getCodigo());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void update(Connection c, TOBase t) throws Exception {
        String sql = "UPDATE public.\"Refeicao\" SET \"ANIMAL\" = ?,"
                + " \"ID\" = ? ,\"PESO\" = ? ,\"DURACAO\" = ?"
                + ",\"CONSUMIDO\" = ?,\"DATA\" = ?,\"HORA\" = ? WHERE \"CODIGO\" = ?";

        TORefeicao to = (TORefeicao) t;

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

        String sql = "INSERT INTO public.\"Refeicao\""
                + "(\"CODIGO\",\"ANIMAL\",\"ID\",\"PESO\",\"DURACAO\","
                + "\"CONSUMIDO\",\"DATA\",\"HORA\")"
                + "VALUES"
                + "(?,?,?,?,?,?,?,?)";

        TORefeicao to = (TORefeicao) t;

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
