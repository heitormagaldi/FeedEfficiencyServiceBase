/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.to;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Heitor
 */
public class TOUser extends TOBase {
    private String login;
    private String senha;
    private String perfil;
    private String email;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TOUser() {
    }
    
    
    public TOUser(ResultSet rs) throws Exception{
        this.login = rs.getString("login");
        this.senha = rs.getString("senha");
        this.email = rs.getString("email");
        this.perfil = rs.getString("perfil");
        this.id = rs.getString("id");
    }
    
   
    @Override
    public JSONObject getJson() {
        JSONObject j = new JSONObject();
        
        try {
            j.put("id", id);
            j.put("login", login);
            j.put("perfil", perfil);
            j.put("email", email);
           
            
        } catch (JSONException ex) {
            Logger.getLogger(TOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return j;
    }
    
    
    
    
}
