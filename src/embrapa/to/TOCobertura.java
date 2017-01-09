/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.to;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Heitor
 */
public class TOCobertura extends TOBase {

    Integer codigo;
    Integer pai;
    Integer mae;
    Integer receptora;
    Date data;
    String tipo;

    public TOCobertura() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getPai() {
        return pai;
    }

    public void setPai(Integer pai) {
        this.pai = pai;
    }

    public Integer getMae() {
        return mae;
    }

    public void setMae(Integer mae) {
        this.mae = mae;
    }

    public Integer getReceptora() {
        return receptora;
    }

    public void setReceptora(Integer receptora) {
        this.receptora = receptora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TOCobertura(Integer codigo, Integer pai, Integer mae, Integer receptora, Date data, String tipo) {
        this.codigo = codigo;
        this.pai = pai;
        this.mae = mae;
        this.receptora = receptora;
        this.data = data;
        this.tipo = tipo;
    }
    public TOCobertura(ResultSet rs) throws Exception{
        this.codigo = rs.getInt("codigo");
        this.pai = rs.getInt("pai");
        this.mae = rs.getInt("mae");
        this.receptora = rs.getInt("receptora");
        this.data = rs.getDate("data");
        this.tipo = rs.getString("tipo");
    }
    
    @Override
    public JSONObject getJson() {
        JSONObject j = new JSONObject();

        try {
            j.put("codigo", codigo);
            j.put("pai", pai);
            j.put("mae", mae);
            j.put("receptora", receptora);
            j.put("data", data);
            j.put("tipo", tipo);

        } catch (JSONException ex) {
            Logger.getLogger(TOCobertura.class.getName()).log(Level.SEVERE, null, ex);
        }

        return j;
    }

}
