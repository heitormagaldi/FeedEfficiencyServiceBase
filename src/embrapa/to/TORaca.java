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
public class TORaca extends TOBase{
    Integer codigo;
    String descricao;

    public TORaca() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TORaca(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
     public TORaca(ResultSet rs) throws Exception{
        this.codigo = rs.getInt("codigo");
        this.descricao = rs.getString("descricao");
    }
    
   
    @Override
    public JSONObject getJson() {
        JSONObject j = new JSONObject();
        
        try {
            j.put("codigo", codigo);
            j.put("descricao", descricao);
                       
        } catch (JSONException ex) {
            Logger.getLogger(TORaca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return j;
    }
}
