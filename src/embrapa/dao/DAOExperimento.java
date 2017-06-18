/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.dao;

import embrapa.to.TOExperimento;
import embrapa.to.TOBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author Heitor
 */
public class DAOExperimento extends DAOBase{
    
    public DAOExperimento(){
        
    }
    @Override
    public JSONArray list(Connection c) throws Exception {
        String sql = "SELECT \"CODIGO\",\"DESCRICAO\",\"SIGLA\",\"INICIO\",\"TERMINO\""
                + " FROM public.\"Experimento\" order by \"CODIGO\"";
        
         
        ResultSet rs = null;
        JSONArray ja = new JSONArray();

        try {
            rs = Data.executeQuery(c, sql);
            while (rs.next()) {
                TOExperimento t = new TOExperimento(rs);
                ja.put(t.getJson());

            }

        } finally {
            rs.close();
        }
        return ja;
    }

    @Override
    public TOBase get(Connection c, TOBase t) throws Exception {
        String sql = "SELECT \"CODIGO\",\"DESCRICAO\",\"SIGLA\",\"INICIO\",\"TERMINO\""
                + " FROM public.\"Experimento\" WHERE \"CODIGO\" = ? ";
        ResultSet rs = null;

        try {
            TOExperimento to = (TOExperimento) t;
            rs = Data.executeQuery(c, sql, to.getCodigo());

            if (rs.next()) {
                return new TOExperimento(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }

    @Override
    public void delete(Connection c, TOBase t) throws Exception {
        String sql = "DELETE FROM public.\"Experimento\" WHERE \"CODIGO\" = ?";

        TOExperimento to = (TOExperimento) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getCodigo());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void update(Connection c, TOBase t) throws Exception {
        String sql = "UPDATE public.\"Experimento\" SET \"DESCRICAO\" = ?,"
                + " \"SIGLA\" = ? ,\"INICIO\" = ? ,\"TERMINO\" = ?"
                +" WHERE \"CODIGO\" = ?";

        TOExperimento to = (TOExperimento) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getDescricao());
        p.add(to.getSigla());
        p.add(to.getInicio());
        p.add(to.getTermino());
        p.add(to.getCodigo());
        
        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void insert(Connection c, TOBase t) throws Exception {
        String sql = "INSERT INTO public.\"Experimento\""
                + "(\"CODIGO\",\"DESCRICAO\",\"SIGLA\",\"INICIO\",\"TERMINO\")"
                + "VALUES"
                + "(?,?,?,?,?)";

        TOExperimento to = (TOExperimento) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getCodigo());
        p.add(to.getDescricao());
        p.add(to.getSigla());
        p.add(to.getInicio());
        p.add(to.getTermino());
                
        Data.executeUpdate(c, sql, p);

    }
    @Override
    public int count(Connection c) throws Exception {
        String sql = "SELECT * FROM public.\"Experimento\" ";
        ResultSet rs = null;
        TOExperimento to = new TOExperimento();
        
        try {
            rs = Data.executeQuery(c, sql,to);
            
            int Contador = 0;
            while(rs.next()){										                                   //mesmo usando um select *, nesse ponto defino que quero usar	
		Contador ++;
            }
            
            
           return Contador;

        } finally {
            rs.close();
        }
   }
}
