package Model;

/**
 *
 * Maycol Pazmiño
 * 
 */
public class CoventionalBhaModel {
    
    private String idBHA;
    private String description;
    BitModel bitKey = new BitModel();
    private String bit = bitKey.getIdBit();
    private String bit_sub;
    DcModel dcKey = new DcModel();
    private String DC = dcKey.getIdNMDC();
    StabilizersModel stabilizerKey = new StabilizersModel();
    private String stabilizers = stabilizerKey.getIdStabilizers();
    XoversModel xOverKey = new XoversModel();
    private String x_over = xOverKey.getIdx_overs();
    HwdpModel heavyDpKey = new HwdpModel();
    private String heavy_dp = heavyDpKey.getIdHWDP();
    JarModel jarKey = new JarModel();
    private String jar = jarKey.getIdJar();
    DpModel dpKey = new DpModel();
    private String dp = dpKey.getIdDP();

    public CoventionalBhaModel(String idBHA, String description, String bit, 
            String bit_sub, String DC, String stabilizers, String x_over,
            String heavy_dp, String jar, String dp) {
        this.idBHA = idBHA;
        this.description = description;
        this.bit = bit;
        this.bit_sub = bit_sub;
        this.DC = DC;
        this.stabilizers = stabilizers;
        this.x_over = x_over;
        this.heavy_dp = heavy_dp;
        this.jar = jar;
        this.dp = dp;
    }

    public String getIdBHA() {
        return idBHA;
    }

    public String getDescription() {
        return description;
    }

    public String getBit() {
        return bit;
    }

    public String getBit_sub() {
        return bit_sub;
    }

    public String getDC() {
        return DC;
    }

    public String getStabilizers() {
        return stabilizers;
    }

    public String getX_over() {
        return x_over;
    }

    public String getHeavy_dp() {
        return heavy_dp;
    }

    public String getJar() {
        return jar;
    }

    public String getDp() {
        return dp;
    }
}