/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.dao;
import embrapa.to.TOExperimento_Animal;
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
public class DAOExperimento_Animal extends DAOBase {
    public DAOExperimento_Animal(){
        
    }
    
    @Override
    public JSONArray list(Connection c) throws Exception {
        String sql = "SELECT \"ANIMAL\",\"EXPERIMENTO\",\"GPD\",\"IMS\",\"PM_MEDIO\""
                + " FROM public.\"Experimento_Animal\" order by \"EXPERIMENTO\",\"ANIMAL\" ";
        
        
        ResultSet rs = null;
        JSONArray ja = new JSONArray();

        try {
            rs = Data.executeQuery(c, sql);
            while (rs.next()) {
                TOExperimento_Animal t = new TOExperimento_Animal(rs);
                ja.put(t.getJson());

            }

        } finally {
            rs.close();
        }
        return ja;
    }

    @Override
    public TOBase get(Connection c, TOBase t) throws Exception {
        String sql = "SELECT \"ANIMAL\",\"EXPERIMENTO\",\"GPD\",\"IMS\",\"PM_MEDIO\""
                + " FROM public.\"Experimento_Animal\" WHERE \"ANIMAL\" = ? AND \"EXPERIMENTO\" = ? ";
        ResultSet rs = null;
        
               
        try {
            TOExperimento_Animal to = (TOExperimento_Animal) t;
            List<Object> p = new ArrayList<Object>();

            p.add(to.getAnimal());
            p.add(to.getExperimento());
            
            rs = Data.executeQuery(c, sql, p);

            if (rs.next()) {
                return new TOExperimento_Animal(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }

    @Override
    public void delete(Connection c, TOBase t) throws Exception {
        String sql = "DELETE FROM public.\"Experimento_Animal\" WHERE \"ANIMAL\" = ? AND \"EXPERIMENTO\" = ? ";

        TOExperimento_Animal to = (TOExperimento_Animal) t;

        List<Object> p = new ArrayList<Object>();
        p.add(to.getAnimal());
        p.add(to.getExperimento());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void update(Connection c, TOBase t) throws Exception {
        String sql = "UPDATE public.\"Experimento_Animal\" SET \"GPD\" = ?,"
                + " \"IMS\" = ? ,\"PM_MEDIO\" = ? WHERE \"ANIMAL\" = ? AND \"EXPERIMENTO\" = ?";

        TOExperimento_Animal to = (TOExperimento_Animal) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getGpd());
        p.add(to.getIms());
        p.add(to.getPm_medio());
        p.add(to.getAnimal());
        p.add(to.getExperimento());
               
        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void insert(Connection c, TOBase t) throws Exception {
        String sql = "INSERT INTO public.\"Experimento_Animal\""
                + "(\"ANIMAL\",\"EXPERIMENTO\",\"GPD\",\"IMS\",\"PM_MEDIO\")"
                + "VALUES"
                + "(?,?,?,?,?)";

        TOExperimento_Animal to = (TOExperimento_Animal) t;

        List<Object> p = new ArrayList<Object>();

        p.add(to.getAnimal());
        p.add(to.getExperimento());
        p.add(to.getGpd());
        p.add(to.getIms());
        p.add(to.getPm_medio());
               
        Data.executeUpdate(c, sql, p);

    }
    @Override
    public int count(Connection c) throws Exception {
        String sql = "SELECT * FROM public.\"Experimento_Animal\" ";
        ResultSet rs = null;
        TOExperimento_Animal to = new TOExperimento_Animal();
        
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
