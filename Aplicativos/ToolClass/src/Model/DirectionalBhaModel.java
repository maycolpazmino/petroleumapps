package Model;

/**
 *
 * Maycol Pazmiño
 * 
 */
public class DirectionalBhaModel {
    
    private String idBHA;
    private String description;
    BitModel bitKey = new BitModel();
    private String bit = bitKey.getIdBit();
    MudMotorModel mudKey = new MudMotorModel();
    private String mud_motor = mudKey.getIdMud_Motor();
    RssModel rssKey = new RssModel();
    private String RSS = rssKey.getIdRss();
    MwdModel mwdKey = new MwdModel();
    private String MWD = mwdKey.getIdMwd();
    LwdModel lwdKey = new LwdModel();
    private String LWD = lwdKey.getIdLwd();
    NmdcModel nmdcKey = new NmdcModel();
    private String NMDC = nmdcKey.getIdNmdc();
    StabilizersModel stabilizerKey = new StabilizersModel();
    private String stabilizers = stabilizerKey.getIdStabilizers();
    DcModel dcKey = new DcModel();
    private String DC = dcKey.getIdNMDC();
    XoversModel xOverKey = new XoversModel();
    private String x_over = xOverKey.getIdx_overs();
    HwdpModel heavyDpKey = new HwdpModel();
    private String heavy_dp = heavyDpKey.getIdHWDP();
    JarModel jarKey = new JarModel();
    private String jar = jarKey.getIdJar();
    DpModel dpKey = new DpModel();
    private String dp = dpKey.getIdDP();

    public DirectionalBhaModel(String idBHA, String description, String bit,
            String mud_motor, String RSS, String MWD, String LWD, String NMDC,
            String stabilizers, String DC, String x_over, String heavy_dp,
            String jar, String dp) {
        this.idBHA = idBHA;
        this.description = description;
        this.bit = bit;
        this.mud_motor = mud_motor;
        this.RSS = RSS;
        this.MWD = MWD;
        this.LWD = LWD;
        this.NMDC = NMDC;
        this.stabilizers = stabilizers;
        this.DC = DC;
        this.x_over = x_over;
        this.heavy_dp = heavy_dp;
        this.jar = jar;
        this.dp = x_over;
    }
    
    
  
}