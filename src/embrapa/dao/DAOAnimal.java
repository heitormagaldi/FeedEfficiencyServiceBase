/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.dao;

import embrapa.to.TOAnimal;
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
public class DAOAnimal extends DAOBase {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    public DAOAnimal() {
    }

    @Override
    public JSONArray list(Connection c) throws Exception {
        String sql = "SELECT \"CODIGO\",\"REGISTRO\",\"MANEJO\",\"RACA\",\"COBERTURA\""
                + ",\"NASCIMENTO\",\"NOME\",\"SEXO\" FROM public.\"Animal\" order by \"CODIGO\"";
        
        
        /*String sql = "SELECT \"Animal\".\"CODIGO\",\"Animal\".\"REGISTRO\",\"Animal\".\"MANEJO\",\"Raca\".\"DESCRICAO\" as \"RACA\",\"Animal\".\"COBERTURA\""
                + ",\"Animal\".\"NASCIMENTO\",\"Animal\".\"NOME\",\"Animal\".\"SEXO\" FROM public.\"Animal\",public.\"Raca\" "
                + "where \"Animal\".\"RACA\"=\"Raca\".\"CODIGO\" order by \"CODIGO\"";
        */
        //SELECT "Animal"."CODIGO","Animal"."REGISTRO","Animal"."MANEJO","Raca"."DESCRICAO","Animal"."COBERTURA","Animal"."NASCIMENTO","Animal"."NOME","Animal"."SEXO" FROM public."Animal",public."Raca" where "Animal"."RACA"="Raca"."CODIGO"  order by "CODIGO"
        
        ResultSet rs = null;
        JSONArray ja = new JSONArray();

        try {
            rs = Data.executeQuery(c, sql);
            while (rs.next()) {
                TOAnimal t = new TOAnimal(rs);
                ja.put(t.getJson());

            }

        } finally {
            rs.close();
        }
        return ja;
    }

    @Override
    public TOBase get(Connection c, TOBase t) throws Exception {
        String sql = "SELECT \"CODIGO\",\"REGISTRO\",\"MANEJO\",\"RACA\",\"COBERTURA\""
                + ",\"NASCIMENTO\",\"NOME\",\"SEXO\" FROM public.\"Animal\" WHERE \"CODIGO\" = ? ";
        ResultSet rs = null;

        try {
            TOAnimal to = (TOAnimal) t;
            rs = Data.executeQuery(c, sql, to.getCodigo());

            if (rs.next()) {
                return new TOAnimal(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }

    @Override
    public void delete(Connection c, TOBase t) throws Exception {
        String sql = "DELETE FROM public.\"Animal\" WHERE \"CODIGO\" = ?";

        TOAnimal to = (TOAnimal) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getCodigo());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void update(Connection c, TOBase t) throws Exception {
        String sql = "UPDATE public.\"Animal\" SET \"REGISTRO\" = ?,"
                + " \"MANEJO\" = ? ,\"RACA\" = ? ,\"COBERTURA\" = ?"
                + ",\"NASCIMENTO\" = ?,\"NOME\" = ?"
                + ",\"SEXO\" = ? WHERE \"CODIGO\" = ?";

        TOAnimal to = (TOAnimal) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getRegistro());
        p.add(to.getManejo());
        p.add(to.getRaca());
        p.add(to.getCobertura());
        p.add(to.getNascimento());
        p.add(to.getNome());
        p.add(to.getSexo());
        p.add(to.getCodigo());
        
        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void insert(Connection c, TOBase t) throws Exception {
        String sql = "INSERT INTO public.\"Animal\""
                + "(\"CODIGO\",\"REGISTRO\",\"MANEJO\",\"RACA\",\"COBERTURA\",\"NASCIMENTO\",\"NOME\",\"SEXO\")"
                + "VALUES"
                + "(?,?,?,?,?,?,?,?)";

        TOAnimal to = (TOAnimal) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getCodigo());
        p.add(to.getRegistro());
        p.add(to.getManejo());
        p.add(to.getRaca());
        p.add(to.getCobertura());
        p.add(to.getNascimento());
        p.add(to.getNome());
        p.add(to.getSexo());
        
        Data.executeUpdate(c, sql, p);

    }
    @Override
    public int count(Connection c) throws Exception {
        String sql = "SELECT * FROM public.\"Animal\" ";
        ResultSet rs = null;
              
        try {
            rs = Data.executeQuery(c, sql);
            
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


