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
public class TOExperimento_Animal extends TOBase {
    private Integer animal;
    private Integer experimento;
    private float gpd;
    private float ims;
    private float pm_medio;
    
    
    public TOExperimento_Animal(){
        
    }

    /**
     * @return the animal
     */
    public Integer getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(Integer animal) {
        this.animal = animal;
    }

    /**
     * @return the experimento
     */
    public Integer getExperimento() {
        return experimento;
    }

    /**
     * @return the gpd
     */
    public float getGpd() {
        return gpd;
    }

     /**
     * @return the ims
     */
    public float getIms() {
        return ims;
    }


    /**
     * @return the pm_medio
     */
    public float getPm_medio() {
        return pm_medio;
    }

    public TOExperimento_Animal(ResultSet rs) throws Exception {
        this.animal = rs.getInt("animal");
        this.experimento = rs.getInt("experimento");
        this.gpd = rs.getFloat("gpd");
        this.ims = rs.getFloat("ims");
        this.pm_medio = rs.getFloat("pm_medio");
     }

    @Override
    public JSONObject getJson() {
        JSONObject j = new JSONObject();
        try {
            j.put("animal", animal);
            j.put("experimento", experimento);
            j.put("gpd", gpd);
            j.put("ims", ims);
            j.put("pm_medio", pm_medio);
           } catch (JSONException ex) {
            Logger.getLogger(TOAnimal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return j;
    }

    /**
     * @param experimento the experimento to set
     */
    public void setExperimento(Integer experimento) {
        this.experimento = experimento;
    }

    /**
     * @param gpd the gpd to set
     */
    public void setGpd(float gpd) {
        this.gpd = gpd;
    }

    /**
     * @param ims the ims to set
     */
    public void setIms(float ims) {
        this.ims = ims;
    }

    /**
     * @param pm_medio the pm_medio to set
     */
    public void setPm_medio(float pm_medio) {
        this.pm_medio = pm_medio;
    }
    
    
}
