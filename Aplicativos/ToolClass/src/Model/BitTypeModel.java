package Model;

/**
 *
 * Maycol Pazmiño
 * 
 */
public class BitTypeModel {
    
    private String idBit_Type;
    private String name;
    private String description;
    private String uses;
    private String material;
    private String image;

    public BitTypeModel(String idBit_Type, String name, String description, String uses, String material, String image) {
        this.idBit_Type = idBit_Type;
        this.name = name;
        this.description = description;
        this.uses = uses;
        this.material = material;
        this.image = image;
    }

    public BitTypeModel() {
        this.idBit_Type = idBit_Type;
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

    public String getImage() {
        return image;
    }
}
