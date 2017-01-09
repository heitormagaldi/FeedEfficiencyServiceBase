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
public class TORefeicao extends TOBase{
    Integer codigo;
    Integer animal;
    float id;
    float peso;
    float duracao;
    float consumido;
    Date data;
    String hora;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getAnimal() {
        return animal;
    }

    public void setAnimal(Integer animal) {
        this.animal = animal;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public float getConsumido() {
        return consumido;
    }

    public void setConsumido(float consumido) {
        this.consumido = consumido;
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

    public TORefeicao() {
    }

    public TORefeicao(Integer codigo, Integer animal, float id, float peso, float duracao, float consumido, Date data, String hora) {
        this.codigo = codigo;
        this.animal = animal;
        this.id = id;
        this.peso = peso;
        this.duracao = duracao;
        this.consumido = consumido;
        this.data = data;
        this.hora = hora;
    }

    public TORefeicao(ResultSet rs) throws Exception {
        this.codigo = rs.getInt("codigo");
        this.animal = rs.getInt("animal");
        this.id = rs.getFloat("id");
        this.peso = rs.getFloat("peso");
        this.duracao = rs.getFloat("duracao");
        this.consumido = rs.getFloat("consumido");
        this.data = rs.getDate("data");
        this.hora = rs.getString("hora");

    }

    @Override
    public JSONObject getJson() {
        JSONObject j = new JSONObject();

        try {
            j.put("codigo", codigo);
            j.put("animal", animal);
            j.put("id", id);
            j.put("peso", peso);
            j.put("duracao", duracao);
            j.put("consumido", consumido);
            j.put("data", data);
            j.put("hora", hora);

        } catch (JSONException ex) {
            Logger.getLogger(TORefeicao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return j;
    }

}
