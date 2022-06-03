package Model;

/**
 *
 * Maycol Pazmiño
 * 
 */
public class BitModel {
    
    private String idBit;
    BitTypeModel type = new BitTypeModel();
    private String idBit_Type = type.getIdBit_Type();
    private String name = type.getName();
    private String description = type.getDescription();
    private String uses = type.getUses();
    private String material = type.getMaterial();
    private String OD;
    private String company;
    private String image;
    private String num_jets;

    public BitModel(String idBit, String idBit_Type, String name, 
            String description, String uses, String material, String OD, 
            String company, String image, String num_jets) {
        this.idBit = idBit;
        this.idBit_Type = idBit_Type;
        this.name = name;
        this.description = description;
        this.uses = uses;
        this.material = material;
        this.OD = OD;
        this.company = company;
        this.image = image;
        this.num_jets = num_jets;
    }

    public BitModel() {
        this.idBit = idBit;
    }  

    public String getIdBit() {
        return idBit;
    }

    public BitTypeModel getType() {
        return type;
    }

    public String getIdBit_Type() {
        return idBit_Type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUses() {
        return uses;
    }

    public String getMaterial() {
        return material;
    }

    public String getOD() {
        return OD;
    }

    public String getCompany() {
        return company;
    }

    public String getImage() {
        return image;
    }

    public String getNum_jets() {
        return num_jets;
    }
    
    
}
