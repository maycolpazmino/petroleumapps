package geomaster;

import Logs.Correlation1;
import Logs.Correlation2;
import Logs.Correlation3;
import Logs.Logging_2;
import Logs.Logging_3;
import Logs.Logging_1;
import Logs.Sample_1;
import Logs.Sample_2;
import Logs.Sample_3;
import geology.Claystone;
import geology.Coal;
import geology.Conglomerate;
import geology.Dolomite;
import geology.Limestone;
import geology.Sandstone;
import geology.Shale;
import geology.Siltstone;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author EQUIPO
 */
public class Description extends javax.swing.JFrame {

    cromatografia fondo = new cromatografia();
    String Texto;

    public Description() {
        //this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        this.setContentPane(fondo);
        initComponents();
        cobLitology.addItem("Select");
        cobLitology.addItem("Sandstone");
        cobLitology.addItem("Limestone");
        cobLitology.addItem("Claystone");
        cobLitology.addItem("Siltstone");
        cobLitology.addItem("Dolomite");
        cobLitology.addItem("Shale");
        cobLitology.addItem("Conglomerate");
        cobLitology.addItem("Coal");

        SampleSelec1.addItem("Select");
        SampleSelec1.addItem("Sandstone");
        SampleSelec1.addItem("Limestone");
        SampleSelec1.addItem("Claystone");
        SampleSelec1.addItem("Siltstone");
        SampleSelec1.addItem("Dolomite");
        SampleSelec1.addItem("Shale");
        SampleSelec1.addItem("Conglomerate");
        SampleSelec1.addItem("Coal");

        SampleSelec2.addItem("Select");
        SampleSelec2.addItem("Sandstone");
        SampleSelec2.addItem("Limestone");
        SampleSelec2.addItem("Claystone");
        SampleSelec2.addItem("Siltstone");
        SampleSelec2.addItem("Dolomite");
        SampleSelec2.addItem("Shale");
        SampleSelec2.addItem("Conglomerate");
        SampleSelec2.addItem("Coal");

        SampleSelec3.addItem("Select");
        SampleSelec3.addItem("Sandstone");
        SampleSelec3.addItem("Limestone");
        SampleSelec3.addItem("Claystone");
        SampleSelec3.addItem("Siltstone");
        SampleSelec3.addItem("Dolomite");
        SampleSelec3.addItem("Shale");
        SampleSelec3.addItem("Conglomerate");
        SampleSelec3.addItem("Coal");

        /*SampleSelec4.addItem("Select");
        SampleSelec4.addItem("Sandstone");
        SampleSelec4.addItem("Limestone");
        SampleSelec4.addItem("Claystone");
        SampleSelec4.addItem("Siltstone");
        SampleSelec4.addItem("Dolomite");
        SampleSelec4.addItem("Shale");
        SampleSelec4.addItem("Conglomerate");
        SampleSelec4.addItem("Coal");

        SampleSelec5.addItem("Select");
        SampleSelec5.addItem("Sandstone");
        SampleSelec5.addItem("Limestone");
        SampleSelec5.addItem("Claystone");
        SampleSelec5.addItem("Siltstone");
        SampleSelec5.addItem("Dolomite");
        SampleSelec5.addItem("Shale");
        SampleSelec5.addItem("Conglomerate");
        SampleSelec5.addItem("Coal");*/
        SamplePorcen1.addItem("Percentage");
        SamplePorcen1.addItem("10%");
        SamplePorcen1.addItem("20%");
        SamplePorcen1.addItem("30%");
        SamplePorcen1.addItem("40%");
        SamplePorcen1.addItem("50%");
        SamplePorcen1.addItem("60%");
        SamplePorcen1.addItem("70%");
        SamplePorcen1.addItem("80%");
        SamplePorcen1.addItem("90%");
        SamplePorcen1.addItem("100%");

        /*SamplePorcen5.addItem("Percentage");
        SamplePorcen5.addItem("10%");
        SamplePorcen5.addItem("20%");
        SamplePorcen5.addItem("30%");
        SamplePorcen5.addItem("40%");
        SamplePorcen5.addItem("50%");
        SamplePorcen5.addItem("60%");
        SamplePorcen5.addItem("70%");
        SamplePorcen5.addItem("80%");
        SamplePorcen5.addItem("90%");
        SamplePorcen5.addItem("100%");*/
        SamplePorcen2.addItem("Percentage");
        SamplePorcen2.addItem("10%");
        SamplePorcen2.addItem("20%");
        SamplePorcen2.addItem("30%");
        SamplePorcen2.addItem("40%");
        SamplePorcen2.addItem("50%");
        SamplePorcen2.addItem("60%");
        SamplePorcen2.addItem("70%");
        SamplePorcen2.addItem("80%");
        SamplePorcen2.addItem("90%");
        SamplePorcen2.addItem("100%");

        SamplePorcen3.addItem("Percentage");
        SamplePorcen3.addItem("10%");
        SamplePorcen3.addItem("20%");
        SamplePorcen3.addItem("30%");
        SamplePorcen3.addItem("40%");
        SamplePorcen3.addItem("50%");
        SamplePorcen3.addItem("60%");
        SamplePorcen3.addItem("70%");
        SamplePorcen3.addItem("80%");
        SamplePorcen3.addItem("90%");
        SamplePorcen3.addItem("100%");

        /*SamplePorcen4.addItem("Percentage");
        SamplePorcen4.addItem("10%");
        SamplePorcen4.addItem("20%");
        SamplePorcen4.addItem("30%");
        SamplePorcen4.addItem("40%");
        SamplePorcen4.addItem("50%");
        SamplePorcen4.addItem("60%");
        SamplePorcen4.addItem("70%");
        SamplePorcen4.addItem("80%");
        SamplePorcen4.addItem("90%");
        SamplePorcen4.addItem("100%");/*/
        SampleShow.addItem("Select");
        SampleShow.addItem("Sample 1 ");
        SampleShow.addItem("Sample 2 ");
        SampleShow.addItem("Sample 3 ");
        //SampleShow.addItem("Sample 4 ");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new cromatografia();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SampleSelec1 = new javax.swing.JComboBox<>();
        SampleSelec2 = new javax.swing.JComboBox<>();
        SampleSelec3 = new javax.swing.JComboBox<>();
        SamplePorcen1 = new javax.swing.JComboBox<>();
        SamplePorcen3 = new javax.swing.JComboBox<>();
        SamplePorcen2 = new javax.swing.JComboBox<>();
        SampleShow = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultadoSampleInfo = new javax.swing.JTextPane();
        cromatografia = new javax.swing.JPanel();
        fotoCromatografia = new javax.swing.JLabel();
        jPanel2 = new cromatografia();
        cobLitology = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoLitology = new javax.swing.JTextPane();
        jPanel3 = new cromatografia();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultadoLitology1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        FluorescenceTable = new javax.swing.JToggleButton();
        WirelineButtom = new javax.swing.JToggleButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        GasesLog = new javax.swing.JTextPane();
        jPanel4 = new cromatografia();
        fotoFluorecencia = new javax.swing.JLabel();
        fotoMuestra = new javax.swing.JLabel();
        PrintFull = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        View = new javax.swing.JMenu();
        MasterLog = new javax.swing.JMenu();
        MenuMasterLogSample1 = new javax.swing.JMenuItem();
        MenuMasterLogSample2 = new javax.swing.JMenuItem();
        MenuMasterLogSample3 = new javax.swing.JMenuItem();
        Correlation = new javax.swing.JMenu();
        Correlation1 = new javax.swing.JMenuItem();
        Correlation2 = new javax.swing.JMenuItem();
        Correlation3 = new javax.swing.JMenuItem();
        Geology = new javax.swing.JMenu();
        Claystone = new javax.swing.JMenuItem();
        Siltstone = new javax.swing.JMenuItem();
        Shale = new javax.swing.JMenuItem();
        Sandstone = new javax.swing.JMenuItem();
        Conglomerate = new javax.swing.JMenuItem();
        Dolomite = new javax.swing.JMenuItem();
        Limestone = new javax.swing.JMenuItem();
        Coal = new javax.swing.JMenuItem();
        About = new javax.swing.JMenu();
        Project = new javax.swing.JMenuItem();
        Manual = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GeoMaster Academic");

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel1.setText("LITOLOGY");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Rock Item"));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Arcilla-Claystone.PNG"))); // NOI18N
        jLabel7.setText("Claystone");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lutita-Shale.png"))); // NOI18N
        jLabel2.setText("Shale");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Anhidrita-Anhydrite.png"))); // NOI18N
        jLabel3.setText("Siltstone");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Arena-Sand.png"))); // NOI18N
        jLabel4.setText("Conglomerate");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Arenisca-Sandstone.png"))); // NOI18N
        jLabel5.setText("Sandstone");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Caliza-Limestone.png"))); // NOI18N
        jLabel6.setText("Limestone");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dolomía-Dolomite.png"))); // NOI18N
        jLabel8.setText("Dolomite");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Carbon-Coal.png"))); // NOI18N
        jLabel9.setText("Coal");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fomation Gas.png"))); // NOI18N
        jLabel14.setText("Form. Gas");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Trip Gas.png"))); // NOI18N
        jLabel15.setText("Trip Gas");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Patroleum.png"))); // NOI18N
        jLabel16.setText("Petroleum");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Patroleum&Gas.png"))); // NOI18N
        jLabel17.setText("Pet & Gas");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Operation-Coments.png"))); // NOI18N
        jLabel18.setText("Operations");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cap Gas.png"))); // NOI18N
        jLabel19.setText("Conec Gas");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gas.png"))); // NOI18N
        jLabel21.setText("Gas");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Shoe.png"))); // NOI18N
        jLabel20.setText("Casing");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)))
        );

        jLabel10.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel10.setText("SAMPLE");

        SampleSelec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleSelec1ActionPerformed(evt);
            }
        });

        SampleShow.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SampleShowItemStateChanged(evt);
            }
        });
        SampleShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleShowActionPerformed(evt);
            }
        });

        resultadoSampleInfo.setEditable(false);
        resultadoSampleInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Sample Information"));
        jScrollPane3.setViewportView(resultadoSampleInfo);

        cromatografia.setPreferredSize(new java.awt.Dimension(983, 345));

        javax.swing.GroupLayout cromatografiaLayout = new javax.swing.GroupLayout(cromatografia);
        cromatografia.setLayout(cromatografiaLayout);
        cromatografiaLayout.setHorizontalGroup(
            cromatografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cromatografiaLayout.createSequentialGroup()
                .addComponent(fotoCromatografia)
                .addGap(977, 977, 977))
        );
        cromatografiaLayout.setVerticalGroup(
            cromatografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cromatografiaLayout.createSequentialGroup()
                .addComponent(fotoCromatografia)
                .addGap(345, 345, 345))
        );

        cobLitology.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cobLitologyItemStateChanged(evt);
            }
        });
        cobLitology.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobLitologyActionPerformed(evt);
            }
        });

        resultadoLitology.setEditable(false);
        resultadoLitology.setBorder(javax.swing.BorderFactory.createTitledBorder("Rock's Description"));
        jScrollPane1.setViewportView(resultadoLitology);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cobLitology, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cobLitology, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        resultadoLitology1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sample Description"));
        resultadoLitology1.setText("\nDescribe here the Sample......");
        jScrollPane2.setViewportView(resultadoLitology1);

        jButton1.setText("PRINT");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("How should I describe the sample?");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        FluorescenceTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        FluorescenceTable.setText("Fluorescence Table");
        FluorescenceTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FluorescenceTableActionPerformed(evt);
            }
        });

        WirelineButtom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        WirelineButtom.setText("LWD LOG");
        WirelineButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WirelineButtomActionPerformed(evt);
            }
        });

        GasesLog.setBorder(javax.swing.BorderFactory.createTitledBorder("Student's Description"));
        GasesLog.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        GasesLog.setForeground(new java.awt.Color(0, 51, 102));
        GasesLog.setAutoscrolls(false);
        GasesLog.setFocusable(false);
        jScrollPane5.setViewportView(GasesLog);
        GasesLog.getAccessibleContext().setAccessibleName("Student Description");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FluorescenceTable)
                            .addComponent(WirelineButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(WirelineButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FluorescenceTable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(fotoMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(fotoFluorecencia, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(fotoMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fotoFluorecencia, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        PrintFull.setText("PRINT");
        PrintFull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintFullActionPerformed(evt);
            }
        });

        File.setText("File");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        View.setText("View");

        MasterLog.setText("Master Log");

        MenuMasterLogSample1.setText("Sample 1");
        MenuMasterLogSample1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMasterLogSample1ActionPerformed(evt);
            }
        });
        MasterLog.add(MenuMasterLogSample1);

        MenuMasterLogSample2.setText("Sample 2");
        MenuMasterLogSample2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMasterLogSample2ActionPerformed(evt);
            }
        });
        MasterLog.add(MenuMasterLogSample2);

        MenuMasterLogSample3.setText("Sample 3");
        MenuMasterLogSample3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMasterLogSample3ActionPerformed(evt);
            }
        });
        MasterLog.add(MenuMasterLogSample3);

        View.add(MasterLog);

        Correlation.setText("Correlation");

        Correlation1.setText("Sample 1");
        Correlation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Correlation1ActionPerformed(evt);
            }
        });
        Correlation.add(Correlation1);

        Correlation2.setText("Sample 2");
        Correlation2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Correlation2ActionPerformed(evt);
            }
        });
        Correlation.add(Correlation2);

        Correlation3.setText("Sample 3");
        Correlation3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Correlation3ActionPerformed(evt);
            }
        });
        Correlation.add(Correlation3);

        View.add(Correlation);

        jMenuBar1.add(View);

        Geology.setText("Geology");

        Claystone.setText("Claystone");
        Claystone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaystoneActionPerformed(evt);
            }
        });
        Geology.add(Claystone);

        Siltstone.setText("Siltstone");
        Siltstone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiltstoneActionPerformed(evt);
            }
        });
        Geology.add(Siltstone);

        Shale.setText("Shale");
        Shale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShaleActionPerformed(evt);
            }
        });
        Geology.add(Shale);

        Sandstone.setText("Sandstone");
        Sandstone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SandstoneActionPerformed(evt);
            }
        });
        Geology.add(Sandstone);

        Conglomerate.setText("Conglomerate");
        Conglomerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConglomerateActionPerformed(evt);
            }
        });
        Geology.add(Conglomerate);

        Dolomite.setText("Dolomite");
        Dolomite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DolomiteActionPerformed(evt);
            }
        });
        Geology.add(Dolomite);

        Limestone.setText("Limestone");
        Limestone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimestoneActionPerformed(evt);
            }
        });
        Geology.add(Limestone);

        Coal.setText("Coal");
        Coal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoalActionPerformed(evt);
            }
        });
        Geology.add(Coal);

        jMenuBar1.add(Geology);

        About.setText("About");

        Project.setText("Project");
        Project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProjectActionPerformed(evt);
            }
        });
        About.add(Project);

        Manual.setText("Manual");
        Manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualActionPerformed(evt);
            }
        });
        About.add(Manual);

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        About.add(jMenuItem1);

        jMenuBar1.add(About);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SampleShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SampleSelec1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SamplePorcen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SampleSelec2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SamplePorcen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SampleSelec3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SamplePorcen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(PrintFull))
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cromatografia, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(300, 300, 300))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SampleShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SampleSelec1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SamplePorcen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SampleSelec2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SamplePorcen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SampleSelec3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SamplePorcen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PrintFull))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cromatografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cobLitologyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobLitologyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cobLitologyActionPerformed

    private void cobLitologyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cobLitologyItemStateChanged
        String Litology = (String) cobLitology.getSelectedItem();

        if (Litology.equals("Select")) {
            resultadoLitology.setText("");
        }

        if (Litology.equals("Sandstone")) {
            resultadoLitology.setText("A clastic sedimentary rock whose grains are generally the size of sand. The term is commonly used to refer "
                    + "to consolidated sand or a rock composed primarily of quartz sand, although sandstones can often contain feldspars, rock "
                    + "fragments, mica and many other additional mineral grains bound together with silica or other cement. \n\nThe relatively high "
                    + "porosity and permeability of sandstones make them good reservoir rocks.");
        }
        if (Litology.equals("Limestone")) {
            resultadoLitology.setText("Limestone is a sedimentary rock composed mainly of calcium carbonate (CaCO3), generally calcite, although it "
                    + "often has traces of magnesite (MgCO3) and other carbonates.\n\nIt may also contain small amounts of minerals such as clay, "
                    + "hematite, siderite, quartz, etc., which modify (sometimes noticeably) the color and degree of coherence of the rock. "
                    + "\n\nThe practically monomineral character of limestones allows them to be easily recognized thanks to two fundamental physical "
                    + "and chemical characteristics of calcite: it is less hard than copper (its hardness on the Mohs scale is 3) and it reacts with "
                    + "effervescence in the presence of acids such as hydrochloric acid.\n"
                    + "\n"
                    + "They are very characteristic for their light, whitish or gray color. ");
        }
        if (Litology.equals("Claystone")) {
            resultadoLitology.setText("Clastic sedimentary rock resulting from the diagenesis of clay.\n\n"
                    + "Sedimentary rock of detrital origin. It is a compact rock, without fissility, formed by clay-sized particles. \n\n"
                    + "Fine-grained sediments, whose size is less than 0.0039 mm.");
        }
        if (Litology.equals("Siltstone")) {
            resultadoLitology.setText("The siltstone is a detrital sedimentary rock that comes in various colors and is characterized by "
                    + "having a silt-sized grain size (between 0.002mm to 0.06mm). \n\nIn addition, its texture is well sorted and mineralogically "
                    + "it is composed of 30% clay, feldspars, quartz, micas and iron oxides.");
        }
        if (Litology.equals("Dolomite")) {
            resultadoLitology.setText("Dolomite [CaMg(CO3)2], is a calcium magnesium carbonate that makes up approximately 2% of the earth's "
                    + "crust of sedimentary rocks that can be found in massive beds or strata several meters thick throughout the world; it is"
                    + "  relatively common with marble.");
        }
        if (Litology.equals("Shale")) {
            resultadoLitology.setText("A fine-grained, fissile, detrital sedimentary rock formed by the consolidation of clay- and silt-sized "
                    + "particles in relatively impermeable, thin layers. It is the most abundant sedimentary rock. \n\nShales can contain relatively "
                    + "large amounts of organic material compared with other rock types and therefore have the potential to become hydrocarbon-rich"
                    + " source rocks, although a typical shale contains only 1% organic matter. The typical fine grain size and lack of permeability, "
                    + "which result from the alignment of their lamellar or flaky grains, allow shales to form good cover rocks for hydrocarbon traps."
                    + " \n\nTraces of gas found in shales during drilling make these shales appear to be potential gas reservoirs. The various types "
                    + "and volumes of clays affect reservoir quality from a petrophysical and geomechanical point of view. The quality of shale "
                    + "reservoirs depends on their thickness and extent, organic content, thermal maturity, depth and pressure, fluid saturations, "
                    + "and permeability, among other factors.");
        }
        if (Litology.equals("Conglomerate")) {
            resultadoLitology.setText("Conglomerate is a type of sedimentary rock that is composed of large, rounded rock fragments contained within"
                    + " a matrix of smaller-grained sediments. The large fragments, known as clasts, can come in a variety of sizes. \n\n"
                    + "Detrital sedimentary rock consisting of diameter clasts (> 2mm) and a fine-grained matrix (< 2mm diameter) for the rock to be"
                    + " classified as a conglomerate. (With angular clasts: it is called breccia).");
        }
        if (Litology.equals("Coal")) {
            resultadoLitology.setText("Coal or mineral coal is an organogenic sedimentary rock of black color, very rich in carbon and with variable "
                    + "amounts of other elements, mainly hydrogen, sulfur, oxygen and nitrogen. It is mainly used as a fossil fuel. \n\nMost of the coal "
                    + "exploited was formed from plants that grew during the Carboniferous (359 to 299 million years ago) and Cretaceous periods, as "
                    + "both periods were of great temporal extension and most of the sedimentary environments favorable for its accumulation and "
                    + "conservation were located in intertropical latitudes. \nIt is a non-renewable resource.");
        }
    }//GEN-LAST:event_cobLitologyItemStateChanged

    private void SampleSelec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleSelec1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SampleSelec1ActionPerformed

    private void SampleShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleShowActionPerformed

        String SelectMuestra = (String) SampleShow.getSelectedItem();
        String SampleSelec_1 = (String) SampleSelec1.getSelectedItem();
        String SampleSelec_2 = (String) SampleSelec2.getSelectedItem();
        String SampleSelec_3 = (String) SampleSelec3.getSelectedItem();
        String Porcentaje1 = (String) SamplePorcen1.getSelectedItem();
        String Porcentaje2 = (String) SamplePorcen2.getSelectedItem();
        String Porcentaje3 = (String) SamplePorcen3.getSelectedItem();

        if (SelectMuestra.equals("Select")) {
            this.fotoMuestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fondo.png")));
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fondo.png")));
            //this.fotoFluorecencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            resultadoSampleInfo.setText("");
        }
        if (SelectMuestra.equals("Sample 1 ")) {
            this.fotoMuestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Arena_Cutting.png")));
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_1.png")));
            this.fotoFluorecencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            resultadoSampleInfo.setText("COMPANY: Big Oil LLC\nWELL: V2PHA\nLOCATION: Texas-USA\n\nDEPTH:\nFrom 2880' to 2900'\n\n"
                    + "SURVEY:\nMD: 2643'  INC: 0.12°  AZM: 316°  TVD: 2642.6'  VS: 49°\n\nDRILLING PARAMETERS:\nWOB: 15k  "
                    + "RPM: 77  PP: 1400 psi  STK: 140 stk/min\n\nMUD PROPERTIES:\nWT OUT: 8.7 ppg  Vis: 27 seg/qt  PH: 7.5  CHL: 350");
        }
        if (SelectMuestra.equals("Sample 2 ")) {
            this.fotoMuestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MuestraLutita.png")));
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_2.png")));
            this.fotoFluorecencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            resultadoSampleInfo.setText("COMPANY: Big Oil LLC\nWELL: V2PHA\nLOCATION: Texas-USA\n\nDEPTH:\nFrom 5695' to 5715'\n\n"
                    + "SURVEY:\nMD: 5732'  INC: 31.2°  AZM: 237.5°  TVD: 5709'  VS: 175°\n\nDRILLING PARAMETERS:\nWOB: 37k  "
                    + "RPM: 45  PP: 1070 psi  STK: 94 stk/min\n\nMUD PROPERTIES:\nWT OUT: 8.9 ppg  Vis: 66 seg/qt  PH: 9.3  CHL: 800  "
                    + "FIL/CK: 2/32  SOL: 1.28%  PV: 17");
        }
        if (SelectMuestra.equals("Sample 3 ")) {
            this.fotoMuestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MuestraArena.png")));
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_3.png")));
            this.fotoFluorecencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fluorecencia.png")));
            resultadoSampleInfo.setText("COMPANY: Big Oil LLC\nWELL: V2PHA\nLOCATION: Texas-USA\n\nDEPTH:\nFrom 4230' to 4240'\n\n"
                    + "SURVEY:\nMD: 4167'  INC: 0.4°  AZM: 15.6°  TVD: 4166.3'  VS: 49°\n\nDRILLING PARAMETERS:\nWOB: 12k  "
                    + "RPM: 45  PP: 1550 psi  STK: 150 stk/min\n\nMUD PROPERTIES:\nWT OUT: 8.7 ppg  Vis: 28 seg/qt  PH: 7  CHL: 800");
        }

    }//GEN-LAST:event_SampleShowActionPerformed

    private void SampleShowItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SampleShowItemStateChanged

    }//GEN-LAST:event_SampleShowItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Texto = resultadoLitology1.getText();
        GasesLog.setText(Texto);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DescripTable abrir = new DescripTable(this, false);
        abrir.setVisible(true);
        //this.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void WirelineButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WirelineButtomActionPerformed
        String SelectMuestra = (String) SampleShow.getSelectedItem();
        if (WirelineButtom.isSelected() && SelectMuestra.equals("Sample 3 ")) {

            Logging_3 abrir = new Logging_3(this, false);
            abrir.setVisible(true);
        }
        if (WirelineButtom.isSelected() && SelectMuestra.equals("Sample 2 ")) {

            Logging_2 abrir = new Logging_2(this, false);
            abrir.setVisible(true);
        }
        if (WirelineButtom.isSelected() && SelectMuestra.equals("Sample 1 ")) {

            Logging_1 abrir = new Logging_1(this, false);
            abrir.setVisible(true);
        }
        /*if (WirelineButtom.isSelected() && SelectMuestra.equals("Sample 4 ")) {

            Logging_4 abrir = new Logging_4(this, false);
            abrir.setVisible(true);
        }*/
    }//GEN-LAST:event_WirelineButtomActionPerformed

    private void PrintFullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintFullActionPerformed
        String SelectMuestra = (String) SampleShow.getSelectedItem();
        String SampleSelec_1 = (String) SampleSelec1.getSelectedItem();
        String SampleSelec_2 = (String) SampleSelec2.getSelectedItem();
        String SampleSelec_3 = (String) SampleSelec3.getSelectedItem();
        String Porcentaje1 = (String) SamplePorcen1.getSelectedItem();
        String Porcentaje2 = (String) SamplePorcen2.getSelectedItem();
        String Porcentaje3 = (String) SamplePorcen3.getSelectedItem();

        if (SelectMuestra.equals("Sample 1 ") && SampleSelec_1.equals("Sandstone") && SampleSelec_2.equals("Shale") && Porcentaje1.equals("80%") && Porcentaje2.equals("20%") && SampleSelec_3.equals("Select") && Porcentaje3.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_1Full2.png")));
        } else if (SelectMuestra.equals("Sample 1 ") && SampleSelec_1.equals("Shale") && SampleSelec_2.equals("Sandstone") && Porcentaje1.equals("20%") && Porcentaje2.equals("80%") && SampleSelec_3.equals("Select") && Porcentaje3.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_1Full2.png")));
        } else if (SelectMuestra.equals("Sample 1 ") && SampleSelec_1.equals("Sandstone") && SampleSelec_3.equals("Shale") && Porcentaje1.equals("80%") && Porcentaje3.equals("20%") && SampleSelec_2.equals("Select") && Porcentaje2.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_1Full2.png")));
        } else if (SelectMuestra.equals("Sample 1 ") && SampleSelec_1.equals("Shale") && SampleSelec_3.equals("Sandstone") && Porcentaje1.equals("20%") && Porcentaje3.equals("80%") && SampleSelec_2.equals("Select") && Porcentaje2.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_1Full2.png")));
        } else if (SelectMuestra.equals("Sample 1 ") && SampleSelec_2.equals("Sandstone") && SampleSelec_3.equals("Shale") && Porcentaje2.equals("80%") && Porcentaje3.equals("20%") && SampleSelec_1.equals("Select") && Porcentaje1.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_1Full2.png")));
        } else if (SelectMuestra.equals("Sample 1 ") && SampleSelec_2.equals("Shale") && SampleSelec_3.equals("Sandstone") && Porcentaje2.equals("20%") && Porcentaje3.equals("80%") && SampleSelec_1.equals("Select") && Porcentaje1.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_1Full2.png")));
        } else if (SelectMuestra.equals("Sample 2 ") && SampleSelec_1.equals("Shale") && Porcentaje1.equals("100%") && SampleSelec_2.equals("Select") && Porcentaje2.equals("Percentage") && SampleSelec_3.equals("Select") && Porcentaje3.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_2Full2.png")));
        } else if (SelectMuestra.equals("Sample 2 ") && SampleSelec_2.equals("Shale") && Porcentaje2.equals("100%") && SampleSelec_1.equals("Select") && Porcentaje1.equals("Percentage") && SampleSelec_3.equals("Select") && Porcentaje3.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_2Full2.png")));
        } else if (SelectMuestra.equals("Sample 2 ") && SampleSelec_3.equals("Shale") && Porcentaje3.equals("100%") && SampleSelec_2.equals("Select") && Porcentaje2.equals("Percentage") && SampleSelec_1.equals("Select") && Porcentaje1.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_2Full2.png")));
        } else if (SelectMuestra.equals("Sample 3 ") && SampleSelec_1.equals("Sandstone") && Porcentaje1.equals("100%") && SampleSelec_2.equals("Select") && Porcentaje2.equals("Percentage") && SampleSelec_3.equals("Select") && Porcentaje3.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_3Full2.png")));
        } else if (SelectMuestra.equals("Sample 3 ") && SampleSelec_2.equals("Sandstone") && Porcentaje2.equals("100%") && SampleSelec_1.equals("Select") && Porcentaje1.equals("Percentage") && SampleSelec_3.equals("Select") && Porcentaje3.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_3Full2.png")));
        } else if (SelectMuestra.equals("Sample 3 ") && SampleSelec_3.equals("Sandstone") && Porcentaje3.equals("100%") && SampleSelec_2.equals("Select") && Porcentaje2.equals("Percentage") && SampleSelec_1.equals("Select") && Porcentaje1.equals("Percentage")) {
            this.fotoCromatografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MasterLog_3Full2.png")));
        } else {
            JOptionPane.showMessageDialog(this, "Wrong Choice\nTry Again!!!");
        }
    }//GEN-LAST:event_PrintFullActionPerformed

    private void FluorescenceTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FluorescenceTableActionPerformed
        String SelectMuestra = (String) SampleShow.getSelectedItem();
        if (FluorescenceTable.isSelected() && SelectMuestra.equals("Sample 3 ")) {
            FluorescenceTable Tabla = new FluorescenceTable(this, false);
            Tabla.setVisible(true);
        }
    }//GEN-LAST:event_FluorescenceTableActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        About About = new About(this, false);
        About.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MenuMasterLogSample1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMasterLogSample1ActionPerformed
        Sample_1 Sample1 = new Sample_1(this, false);
        Sample1.setVisible(true);
    }//GEN-LAST:event_MenuMasterLogSample1ActionPerformed

    private void Correlation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Correlation1ActionPerformed
        Correlation1 Correlation1 = new Correlation1(this, false);
        Correlation1.setVisible(true);
    }//GEN-LAST:event_Correlation1ActionPerformed

    private void MenuMasterLogSample2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMasterLogSample2ActionPerformed
        Sample_2 Sample2 = new Sample_2(this, false);
        Sample2.setVisible(true);
    }//GEN-LAST:event_MenuMasterLogSample2ActionPerformed

    private void MenuMasterLogSample3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMasterLogSample3ActionPerformed
        Sample_3 Sample3 = new Sample_3(this, false);
        Sample3.setVisible(true);
    }//GEN-LAST:event_MenuMasterLogSample3ActionPerformed

    private void Correlation2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Correlation2ActionPerformed
        Correlation2 Correlation2 = new Correlation2(this, false);
        Correlation2.setVisible(true);
    }//GEN-LAST:event_Correlation2ActionPerformed

    private void Correlation3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Correlation3ActionPerformed
        Correlation3 Correlation3 = new Correlation3(this, false);
        Correlation3.setVisible(true);
    }//GEN-LAST:event_Correlation3ActionPerformed

    private void ClaystoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaystoneActionPerformed
        Claystone abrir = new Claystone(this, false);
        abrir.setVisible(true);
    }//GEN-LAST:event_ClaystoneActionPerformed

    private void SiltstoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiltstoneActionPerformed
        Siltstone abrir = new Siltstone(this, false);
        abrir.setVisible(true);
    }//GEN-LAST:event_SiltstoneActionPerformed

    private void ShaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShaleActionPerformed
        Shale abrir = new Shale(this, false);
        abrir.setVisible(true);
    }//GEN-LAST:event_ShaleActionPerformed

    private void SandstoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SandstoneActionPerformed
        Sandstone abrir = new Sandstone(this, false);
        abrir.setVisible(true);
    }//GEN-LAST:event_SandstoneActionPerformed

    private void ConglomerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConglomerateActionPerformed
        Conglomerate abrir = new Conglomerate(this, false);
        abrir.setVisible(true);
    }//GEN-LAST:event_ConglomerateActionPerformed

    private void DolomiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DolomiteActionPerformed
        Dolomite abrir = new Dolomite(this, false);
        abrir.setVisible(true);
    }//GEN-LAST:event_DolomiteActionPerformed

    private void LimestoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimestoneActionPerformed
        Limestone abrir = new Limestone(this, false);
        abrir.setVisible(true);
    }//GEN-LAST:event_LimestoneActionPerformed

    private void CoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoalActionPerformed
        Coal abrir = new Coal(this, false);
        abrir.setVisible(true);
    }//GEN-LAST:event_CoalActionPerformed

    private void ProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProjectActionPerformed
        try {
            String url = "https://drive.google.com/file/d/1P5tWgaM7SLEgkIg5Ere76NGs0cHlqEpJ/view?usp=sharing";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(Description.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ProjectActionPerformed

    private void ManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualActionPerformed
        try {
            String url = "https://drive.google.com/file/d/1HUhahw7S1M79zrBFNqsVd52E4tLzF-6z/view?usp=sharing";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(Description.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ManualActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Description.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Description.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Description.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Description.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Description().setVisible(true);
            }
        });

    }

    class cromatografia extends JPanel {

        public Image muestraCromatografia;

        public void paint(Graphics g) {
            muestraCromatografia = new ImageIcon(getClass().getResource("/images/Fondo.png")).getImage();
            g.drawImage(muestraCromatografia, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu About;
    private javax.swing.JMenuItem Claystone;
    private javax.swing.JMenuItem Coal;
    private javax.swing.JMenuItem Conglomerate;
    private javax.swing.JMenu Correlation;
    private javax.swing.JMenuItem Correlation1;
    private javax.swing.JMenuItem Correlation2;
    private javax.swing.JMenuItem Correlation3;
    private javax.swing.JMenuItem Dolomite;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JToggleButton FluorescenceTable;
    private javax.swing.JTextPane GasesLog;
    private javax.swing.JMenu Geology;
    private javax.swing.JMenuItem Limestone;
    private javax.swing.JMenuItem Manual;
    private javax.swing.JMenu MasterLog;
    private javax.swing.JMenuItem MenuMasterLogSample1;
    private javax.swing.JMenuItem MenuMasterLogSample2;
    private javax.swing.JMenuItem MenuMasterLogSample3;
    private javax.swing.JButton PrintFull;
    private javax.swing.JMenuItem Project;
    private javax.swing.JComboBox<String> SamplePorcen1;
    private javax.swing.JComboBox<String> SamplePorcen2;
    private javax.swing.JComboBox<String> SamplePorcen3;
    private javax.swing.JComboBox<String> SampleSelec1;
    private javax.swing.JComboBox<String> SampleSelec2;
    private javax.swing.JComboBox<String> SampleSelec3;
    private javax.swing.JComboBox<String> SampleShow;
    private javax.swing.JMenuItem Sandstone;
    private javax.swing.JMenuItem Shale;
    private javax.swing.JMenuItem Siltstone;
    private javax.swing.JMenu View;
    private javax.swing.JToggleButton WirelineButtom;
    private javax.swing.JComboBox<String> cobLitology;
    private javax.swing.JPanel cromatografia;
    private javax.swing.JLabel fotoCromatografia;
    private javax.swing.JLabel fotoFluorecencia;
    private javax.swing.JLabel fotoMuestra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane resultadoLitology;
    private javax.swing.JTextPane resultadoLitology1;
    private javax.swing.JTextPane resultadoSampleInfo;
    // End of variables declaration//GEN-END:variables
}
