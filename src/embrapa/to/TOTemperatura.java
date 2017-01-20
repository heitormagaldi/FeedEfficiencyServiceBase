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
public class TOTemperatura extends TOBase{
    Integer codigo;
    float valor;
    Integer equipamento ;
    String sensor;
    Date data;
    String hora;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Integer getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Integer equipamento) {
        this.equipamento = equipamento;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

   
    public TOTemperatura() {
    }

    public TOTemperatura(Integer codigo, float valor, Integer equipamento, String sensor, Date data, String hora) {
        this.codigo = codigo;
        this.valor = valor;
        this.equipamento = equipamento;
        this.sensor = sensor;
        this.data = data;
        this.hora = hora;
    }
    public TOTemperatura(ResultSet rs) throws Exception {
        this.codigo = rs.getInt("codigo");
        this.valor = rs.getFloat("valor");
        this.equipamento = rs.getInt("equipamento");
        this.sensor = rs.getString("sensor");
        this.data = rs.getDate("data");
        this.hora = rs.getString("hora");
    }
        
    @Override
    public JSONObject getJson() {
        JSONObject j = new JSONObject();

        try {
            j.put("codigo", codigo);
            j.put("valor", valor);
            j.put("equipamento", equipamento);
            j.put("sensor", sensor);
            j.put("data", data);
            j.put("hora", hora);
            

        } catch (JSONException ex) {
            Logger.getLogger(TOTemperatura.class.getName()).log(Level.SEVERE, null, ex);
        }

        return j;
    }

}
