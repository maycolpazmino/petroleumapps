/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author EQUIPO
 */
public class MudMotorModel {

    private String idMud_Motor;
    private String description;
    private String OD;
    private String ID;
    private String max_bend;
    private String material;
    private String company;
    private String power;
    private String weigth;
    private String length;
    private String rev_gal;
    private String conection_type;
    private String image;

    public MudMotorModel(String idMud_Motor, String description, String OD,
            String ID, String max_bend, String material, String company,
            String power, String weigth, String length, String rev_gal,
            String conection_type, String image) {
        this.idMud_Motor = idMud_Motor;
        this.description = description;
        this.OD = OD;
        this.ID = ID;
        this.max_bend = max_bend;
        this.material = material;
        this.company = company;
        this.power = power;
        this.weigth = weigth;
        this.length = length;
        this.rev_gal = rev_gal;
        this.conection_type = conection_type;
        this.image = image;
    }

    public MudMotorModel() {
        this.idMud_Motor = idMud_Motor;
    }

    public String getIdMud_Motor() {
        return idMud_Motor;
    }

    public String getDescription() {
        return description;
    }

    public String getOD() {
        return OD;
    }

    public String getID() {
        return ID;
    }

    public String getMax_bend() {
        return max_bend;
    }

    public String getMaterial() {
        return material;
    }

    public String getCompany() {
        return company;
    }

    public String getPower() {
        return power;
    }

    public String getWeigth() {
        return weigth;
    }

    public String getLength() {
        return length;
    }

    public String getRev_gal() {
        return rev_gal;
    }

    public String getConection_type() {
        return conection_type;
    }

    public String getImage() {
        return image;
    }

}
