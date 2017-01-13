/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.dao;

import embrapa.to.TOBase;
import java.sql.Connection;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Heitor
 */
public class DAOBase {

    public void insert(Connection c, TOBase t) throws Exception {
    }

    public void update(Connection c, TOBase t) throws Exception {
    }

    public void delete(Connection c, TOBase t) throws Exception {
    }

    public TOBase get(Connection c, TOBase t) throws Exception {
        return null;
    }
    
    public TOBase check(Connection c, TOBase t) throws Exception {
        return null;
    }

    public JSONArray list (Connection c) throws Exception{
        return null;
    }
}
