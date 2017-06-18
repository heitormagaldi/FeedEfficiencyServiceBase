/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.bo;

import embrapa.dao.DAOBase;
import embrapa.dao.Data;
import embrapa.to.TOBase;
import java.sql.Connection;
import org.json.JSONArray;

/**
 *
 * @author Heitor
 */
public class BOFactory {
    public static void insert(DAOBase d, TOBase t) throws Exception{
        Connection c = null;
        try{
            c = Data.openConnection();
            d.insert(c, t);
        }finally{
            c.close();
        }
           
    }
    public static void update(DAOBase d, TOBase t) throws Exception{
        Connection c = null;
        try{
            c = Data.openConnection();
            d.update(c, t);
        }finally{
            c.close();
        }
           
    }
    public static void delete(DAOBase d, TOBase t) throws Exception{
        Connection c = null;
        try{
            c = Data.openConnection();
            d.delete(c, t);
        }finally{
            c.close();
        }
           
    }
    
    public static TOBase get(DAOBase d, TOBase t) throws Exception{
        Connection c = null;
        try{
            c = Data.openConnection();
            return d.get(c, t);
        }finally{
            c.close();
        }
           
    }
    public static JSONArray list(DAOBase d) throws Exception{
        Connection c = null;
        try{
            c = Data.openConnection();
            return d.list(c);
        }finally{
            c.close();
        }
           
    }
        
    public static TOBase check(DAOBase d,TOBase t) throws Exception{
        Connection c = null;
        try{
            c = Data.openConnection();
            return d.check(c, t);
        }finally{
            c.close();
        }
           
    }
    
    public static JSONArray listCodigo(DAOBase d,TOBase t) throws Exception{
        Connection c = null;
        try{
            c = Data.openConnection();
            return d.listCodigo(c,t);
        }finally{
            c.close();
        }
           
    }
    
    public static int count(DAOBase d) throws Exception{
        Connection c = null;
        try{
            c = Data.openConnection();
            return d.count(c);
        }finally{
            c.close();
        }
           
    }
    
    
    
    
    
    
}
