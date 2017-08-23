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
public class TOAnimal extends TOBase {

    private Integer codigo;
    private String registro;
    private String manejo;
    private Integer raca;
    private Integer cobertura;
    private Date nascimento;
    private String nome;
    private String sexo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getManejo() {
        return manejo;
    }

    public void setManejo(String manejo) {
        this.manejo = manejo;
    }

    public Integer getRaca() {
        return raca;
    }

    public void setRaca(Integer raca) {
        this.raca = raca;
    }

    public Integer getCobertura() {
        return cobertura;
    }

    public void setCobertura(Integer cobertura) {
        this.cobertura = cobertura;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public TOAnimal() {
    }

    public TOAnimal(ResultSet rs) throws Exception {
        this.codigo = rs.getInt("codigo");
        this.registro = rs.getString("registro");
        this.manejo = rs.getString("manejo");
        this.raca = rs.getInt("raca");
        this.cobertura = rs.getInt("cobertura");
        this.nascimento = rs.getDate("nascimento");
        this.nome = rs.getString("nome");
        this.sexo = rs.getString("sexo");
    }
    public TOAnimal(int codigo,String registro,String manejo, int raca,
            int cobertura, Date data,String nome, String sexo) throws Exception {
        this.codigo = codigo;
        this.registro = registro;
        this.manejo = manejo;
        this.raca = raca;
        this.cobertura = cobertura;
        this.nascimento = data;
        this.nome = nome;
        this.sexo = sexo;
    }

    @Override
    public JSONObject getJson() {
        JSONObject j = new JSONObject();
        try {
            j.put("codigo", codigo);
            j.put("registro", registro);
            j.put("manejo", manejo);
            j.put("raca", raca);
            j.put("cobertura", cobertura);
            j.put("nascimento", nascimento);
            j.put("nome", nome);
            j.put("sexo", sexo);
                        

        } catch (JSONException ex) {
            Logger.getLogger(TOAnimal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return j;
    }
}
