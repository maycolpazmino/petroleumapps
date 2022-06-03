package View.Containers;

import Utils.ConnectionDB;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Maycol Pazmiño
 *
 */
public class ExtraContainer extends javax.swing.JPanel {

    Connection conn;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    private ImageIcon image;
    private Icon icon;

    public ExtraContainer() {
        initComponents();
        imageContainer();
        selects();
        getListSelectBit(jcbBits);
        jPanelTabla.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bitImageContainer = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        direcToolsContainer = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        hwdpImageContainer = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        dpImageContainer = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jcbBits = new javax.swing.JComboBox<>();
        jcbDirectional = new javax.swing.JComboBox<>();
        jcbHw = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox = new javax.swing.JCheckBox();
        jPanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResults = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bitImageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bitImageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(direcToolsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(direcToolsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hwdpImageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hwdpImageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpImageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpImageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel1.setText("BITS");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel3.setText("Directional Tool");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel4.setText("Heavy Weight");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel2.setText("Drill Pipe");

        jCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox.setText("Select");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jcbBits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jcbDirectional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(jcbHw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel4)
                        .addGap(101, 101, 101)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jCheckBox)
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(99, 99, 99))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbDirectional, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbBits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbHw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelTabla.setBackground(new java.awt.Color(255, 255, 255));

        jTableResults.setBackground(new java.awt.Color(255, 255, 255));
        jTableResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableResults);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validateSelect();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void limpiarTabla() {
        int fila = jTableResults.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void validateSelect() {
        String bits = (String) jcbBits.getSelectedItem();
        String directional = (String) jcbDirectional.getSelectedItem();
        String heavyW = (String) jcbHw.getSelectedItem();

        if (("Select".equals(bits)) && ("Select".equals(directional))
                && ("Select".equals(heavyW)) && (!jCheckBox.isSelected())) {
            JOptionPane.showMessageDialog(this, "Select one option", "ERROR", 1);
        } else if ((!"Select".equals(bits)) && ("Select".equals(directional))
                && ("Select".equals(heavyW)) && (!jCheckBox.isSelected())) {

            jPanelTabla.setVisible(true);
            if (null != bits) {
                switch (bits) {
                    case "PDC":
                        getBitPDC();
                        break;
                    case "Triconic":
                        getBitTriconic();
                        break;
                    case "Mill":
                        getBitMiller();
                        break;
                    case "Nucleo":
                        getBitNueclo();
                        break;
                    default:
                        break;
                }
            }
        } else if (("Select".equals(bits)) && (!"Select".equals(directional))
                && ("Select".equals(heavyW)) && (!jCheckBox.isSelected())) {
            jPanelTabla.setVisible(true);
            if (null != directional) {
                switch (directional) {
                    case "Mud Motor":
                        getAllMudMotor();
                        break;
                    case "RSS":
                        getAllRSS();
                        break;
                    case "MWD":
                        getAllMwd();
                        break;
                    case "LWD":
                        getAllLwd();
                        break;
                    default:
                        break;
                }
            }
        } else if (("Select".equals(bits)) && ("Select".equals(directional))
                && (!"Select".equals(heavyW)) && (!jCheckBox.isSelected())) {
            jPanelTabla.setVisible(true);
            if (null != heavyW) {
                switch (heavyW) {
                    case "NMDC":
                        getAllNmdc();
                        break;
                    case "DC":
                        getAllDc();
                        break;
                    case "HWDP":
                        getAllHwdp();
                        break;
                    case "Jars":
                        getAllJar();
                        break;
                    default:
                        break;
                }
            } else if (("Select".equals(bits)) && ("Select".equals(directional))
                    && ("Select".equals(heavyW)) && (jCheckBox.isSelected())) {
                jPanelTabla.setVisible(true);
                getAllDp();
            }
        }
    }

    public void imageContainer() {
        showImageContainer(bitImageContainer, "src/Images/Containers/bitImage.PNG");
        showImageContainer(direcToolsContainer, "src/Images/Containers/directionalImageContainer.jpg");
        showImageContainer(hwdpImageContainer, "src/Images/Containers/hwdpImageContainer.PNG");
        showImageContainer(dpImageContainer, "src/Images/Containers/dpImageContainer.jpg");
    }

    public void getListSelectBit(JComboBox tool) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT name FROM bit_type;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                tool.addItem(result.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllMudMotor() {

        String[] header = {"Company", "OD", "ID", "Bend °", "Material",
            "Power", "Weight", "Lenght", "Rev/Gal", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select company, OD, ID, max_bend, material, \n"
                    + "power, weight, lenght, rev_gal, \n"
                    + "conection_type from mud_motor;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] motor = new Object[10];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                motor[0] = (result.getString(1));
                motor[1] = (result.getString(2));
                motor[2] = (result.getString(3));
                motor[3] = (result.getString(4));
                motor[4] = (result.getString(5));
                motor[5] = (result.getString(6));
                motor[6] = (result.getString(7));
                motor[7] = (result.getString(8));
                motor[8] = (result.getString(9));
                motor[9] = (result.getString(10));

                modelo.addRow(motor);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllRSS() {

        String[] header = {"Company", "Name", "OD", "ID", "Material",
            "Weight", "Lenght", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select company, name, OD, ID, material, \n"
                    + "weight, lenght, conection_type from rss;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] rss = new Object[8];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                rss[0] = (result.getString(1));
                rss[1] = (result.getString(2));
                rss[2] = (result.getString(3));
                rss[3] = (result.getString(4));
                rss[4] = (result.getString(5));
                rss[5] = (result.getString(6));
                rss[6] = (result.getString(7));
                rss[7] = (result.getString(8));

                modelo.addRow(rss);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllMwd() {

        String[] header = {"OD", "ID", "Material", "Company",
            "Weight", "Lenght", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select OD, ID, material, company, weight, "
                    + "lenght, conection_type from mwd;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] rss = new Object[7];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                rss[0] = (result.getString(1));
                rss[1] = (result.getString(2));
                rss[2] = (result.getString(3));
                rss[3] = (result.getString(4));
                rss[4] = (result.getString(5));
                rss[5] = (result.getString(6));
                rss[6] = (result.getString(7));

                modelo.addRow(rss);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllLwd() {

        String[] header = {"OD", "ID", "Material", "Company",
            "Weight", "Lenght", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select OD, ID, material, company, weight, "
                    + "lenght, conection_type from lwd;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] rss = new Object[7];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                rss[0] = (result.getString(1));
                rss[1] = (result.getString(2));
                rss[2] = (result.getString(3));
                rss[3] = (result.getString(4));
                rss[4] = (result.getString(5));
                rss[5] = (result.getString(6));
                rss[6] = (result.getString(7));

                modelo.addRow(rss);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllDp() {

        String[] header = {"OD", "ID", "Material", "Company",
            "Weight", "Lenght", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select OD, ID, material, company, weight, "
                    + "lenght, conection_type from dp;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] rss = new Object[7];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                rss[0] = (result.getString(1));
                rss[1] = (result.getString(2));
                rss[2] = (result.getString(3));
                rss[3] = (result.getString(4));
                rss[4] = (result.getString(5));
                rss[5] = (result.getString(6));
                rss[6] = (result.getString(7));

                modelo.addRow(rss);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllHwdp() {

        String[] header = {"OD", "ID", "Material", "Company",
            "Weight", "Lenght", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select OD, ID, material, company, weight, "
                    + "lenght, conection_type from hwdp;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] rss = new Object[7];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                rss[0] = (result.getString(1));
                rss[1] = (result.getString(2));
                rss[2] = (result.getString(3));
                rss[3] = (result.getString(4));
                rss[4] = (result.getString(5));
                rss[5] = (result.getString(6));
                rss[6] = (result.getString(7));

                modelo.addRow(rss);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllNmdc() {

        String[] header = {"OD", "ID", "Material", "Company",
            "Weight", "Lenght", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select OD, ID, material, company, weight, "
                    + "lenght, conection_type from nmdc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] rss = new Object[7];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                rss[0] = (result.getString(1));
                rss[1] = (result.getString(2));
                rss[2] = (result.getString(3));
                rss[3] = (result.getString(4));
                rss[4] = (result.getString(5));
                rss[5] = (result.getString(6));
                rss[6] = (result.getString(7));

                modelo.addRow(rss);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllJar() {

        String[] header = {"OD", "ID", "Material", "Company",
            "Weight", "Lenght", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select OD, ID, material, company, weight, "
                    + "lenght, conection_type from jar;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] rss = new Object[7];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                rss[0] = (result.getString(1));
                rss[1] = (result.getString(2));
                rss[2] = (result.getString(3));
                rss[3] = (result.getString(4));
                rss[4] = (result.getString(5));
                rss[5] = (result.getString(6));
                rss[6] = (result.getString(7));

                modelo.addRow(rss);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllDc() {

        String[] header = {"OD", "ID", "Material", "Company",
            "Weight", "Lenght", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select OD, ID, material, company, weight, "
                    + "lenght, conection_type from dc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] rss = new Object[7];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                rss[0] = (result.getString(1));
                rss[1] = (result.getString(2));
                rss[2] = (result.getString(3));
                rss[3] = (result.getString(4));
                rss[4] = (result.getString(5));
                rss[5] = (result.getString(6));
                rss[6] = (result.getString(7));

                modelo.addRow(rss);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllStabilizer() {

        String[] header = {"OD", "ID", "Material", "Company",
            "Weight", "Lenght", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select OD, ID, material, company, weight, "
                    + "lenght, conection_type from stabilizer;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] rss = new Object[7];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                rss[0] = (result.getString(1));
                rss[1] = (result.getString(2));
                rss[2] = (result.getString(3));
                rss[3] = (result.getString(4));
                rss[4] = (result.getString(5));
                rss[5] = (result.getString(6));
                rss[6] = (result.getString(7));

                modelo.addRow(rss);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getAllXOver() {

        String[] header = {"OD", "ID", "Material", "Company",
            "Weight", "Lenght", "Connection"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select OD, ID, material, company, weight, "
                    + "lenght, conection_type from x_over;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Object[] rss = new Object[7];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                rss[0] = (result.getString(1));
                rss[1] = (result.getString(2));
                rss[2] = (result.getString(3));
                rss[3] = (result.getString(4));
                rss[4] = (result.getString(5));
                rss[5] = (result.getString(6));
                rss[6] = (result.getString(7));

                modelo.addRow(rss);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getBitPDC() {

        String[] header = {"Type", "OD", "Company", "Uses", "Material",
            "NumJets"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select name, OD, company, uses, material, numJets from bit, bit_type\n"
                    + "where (bit.idTypeBit = bit_type.idTypeBit);";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            Object[] a = new Object[6];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                a[0] = (result.getString(1));
                a[1] = (result.getString(2));
                a[2] = (result.getString(3));
                a[3] = (result.getString(4));
                a[4] = (result.getString(5));
                a[5] = (result.getString(6));

                modelo.addRow(a);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getBitTriconic() {

        String[] header = {"Type", "OD", "Company", "Uses", "Material",
            "NumJets"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select name, OD, company, uses, material, numJets from bit, bit_type\n"
                    + "where (bit.idTypeBit = bit_type.idTypeBit);";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            Object[] a = new Object[6];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                a[0] = (result.getString(1));
                a[1] = (result.getString(2));
                a[2] = (result.getString(3));
                a[3] = (result.getString(4));
                a[4] = (result.getString(5));
                a[5] = (result.getString(6));

                modelo.addRow(a);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getBitNueclo() {

        String[] header = {"Type", "OD", "Company", "Uses", "Material",
            "NumJets"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select name, OD, company, uses, material, numJets from bit, bit_type\n"
                    + "where (bit.idTypeBit = bit_type.idTypeBit);";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            Object[] a = new Object[6];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                a[0] = (result.getString(1));
                a[1] = (result.getString(2));
                a[2] = (result.getString(3));
                a[3] = (result.getString(4));
                a[4] = (result.getString(5));
                a[5] = (result.getString(6));

                modelo.addRow(a);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void getBitMiller() {

        String[] header = {"Type", "OD", "Company", "Uses", "Material",
            "NumJets"
        };
        modelo.setColumnIdentifiers(header);
        jTableResults.setModel(modelo);

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "Select name, OD, company, uses, material, numJets from bit, bit_type\n"
                    + "where (bit.idTypeBit = bit_type.idTypeBit);";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            Object[] a = new Object[6];
            modelo = (DefaultTableModel) jTableResults.getModel();

            while (result.next()) {
                a[0] = (result.getString(1));
                a[1] = (result.getString(2));
                a[2] = (result.getString(3));
                a[3] = (result.getString(4));
                a[4] = (result.getString(5));
                a[5] = (result.getString(6));

                modelo.addRow(a);
            }
            jTableResults.setModel(modelo);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExtraContainer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void showImageContainer(JLabel lbl, String ruta) {
        image = new ImageIcon(ruta);
        icon = new ImageIcon(image.getImage().getScaledInstance(
                197, 181, Image.SCALE_DEFAULT));
        lbl.setIcon(icon);
        repaint();
    }

    public void selects() {
        jcbDirectional.addItem("Select");
        jcbDirectional.addItem("Mud Motor");
        jcbDirectional.addItem("RSS");
        jcbDirectional.addItem("MWD");
        jcbDirectional.addItem("LWD");

        jcbHw.addItem("Select");
        jcbHw.addItem("NMDC");
        jcbHw.addItem("DC");
        jcbHw.addItem("HWDP");
        jcbHw.addItem("Jars");

        jcbBits.addItem("Select");
        jcbBits.addItem("Triconic");
        jcbBits.addItem("Mills");
        jcbBits.addItem("PDC");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bitImageContainer;
    private javax.swing.JLabel direcToolsContainer;
    private javax.swing.JLabel dpImageContainer;
    private javax.swing.JLabel hwdpImageContainer;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableResults;
    private javax.swing.JComboBox<String> jcbBits;
    private javax.swing.JComboBox<String> jcbDirectional;
    private javax.swing.JComboBox<String> jcbHw;
    // End of variables declaration//GEN-END:variables
}
