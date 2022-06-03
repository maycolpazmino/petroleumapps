package Model;

/**
 *
 * Maycol Pazmiño
 * 
 */
public class MwdModel {
    
    private String idMwd;
    private String description;
    private String OD;
    private String ID;
    private String material;
    private String comany;
    private String weigth;
    private String length;
    private String conection_type;
    private String image;

    public MwdModel(String idMwd, String description, String OD, String ID, String material, String comany, String weigth, String length, String conection_type, String image) {
        this.idMwd = idMwd;
        this.description = description;
        this.OD = OD;
        this.ID = ID;
        this.material = material;
        this.comany = comany;
        this.weigth = weigth;
        this.length = length;
        this.conection_type = conection_type;
        this.image = image;
    }

    public MwdModel() {
        this.idMwd = idMwd;
    }

    public String getIdMwd() {
        return idMwd;
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

    public String getMaterial() {
        return material;
    }

    public String getComany() {
        return comany;
    }

    public String getWeigth() {
        return weigth;
    }

    public String getLength() {
        return length;
    }

    public String getConection_type() {
        return conection_type;
    }

    public String getImage() {
        return image;
    }      
}
