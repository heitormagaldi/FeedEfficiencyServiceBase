/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embrapa.to;

/**
 *
 * @author Heitor
 */

import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;


public class TOExperimento extends TOBase {
    private Integer codigo;
    private String descricao;
    private String sigla;
    private Date inicio;
    private Date termino;

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the termino
     */
    public Date getTermino() {
        return termino;
    }

    /**
     * @param termino the termino to set
     */
    public void setTermino(Date termino) {
        this.termino = termino;
    }
    public TOExperimento(){
        
    }
    public TOExperimento(ResultSet rs) throws Exception {
        this.codigo = rs.getInt("codigo");
        this.descricao = rs.getString("descricao");
        this.sigla = rs.getString("sigla");
        this.inicio = rs.getDate("inicio");
        this.termino = rs.getDate("termino");
     }

    @Override
    public JSONObject getJson() {
        JSONObject j = new JSONObject();
        try {
            j.put("codigo", codigo);
            j.put("descricao", descricao);
            j.put("sigla", sigla);
            j.put("inicio", inicio);
            j.put("termino", termino);
           } catch (JSONException ex) {
            Logger.getLogger(TOAnimal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return j;
    }
}
