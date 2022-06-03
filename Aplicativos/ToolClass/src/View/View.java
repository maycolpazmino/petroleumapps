package View;

import View.Containers.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * Maycol Pazmiño ToolClass
 *
 */
public class View extends javax.swing.JFrame {

    private ImageIcon image;
    private Icon icon;

    DrillingContainer drilling = new DrillingContainer();

    public View() {
        initComponents();
        getContentPane().setBackground(Color.yellow);
        setLocationRelativeTo(null);
        //setExtendedState(MAXIMIZED_BOTH);
        homeContainer();
        showImageContainer(labelLogo, "src/Images/ToolClassLogo.jpeg");
    }

    public void showImageContainer(JLabel lbl, String ruta) {
        image = new ImageIcon(ruta);
        icon = new ImageIcon(image.getImage().getScaledInstance(
                244, 157, Image.SCALE_DEFAULT));
        lbl.setIcon(icon);
        repaint();
    }

    public void homeContainer() {
        HomeContainer home = new HomeContainer();
        home.setSize(923, 632);
        home.setLocation(0, 0);

        content.removeAll();
        content.add(home, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        footer1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        btnHome = new javax.swing.JLabel();
        btnDirectional = new javax.swing.JLabel();
        btnExtra = new javax.swing.JLabel();
        btnBha = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tool Class");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        footer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo2Sidebar.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        labelLogo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );

        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/home_blue.png"))); // NOI18N
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });

        btnDirectional.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDirectional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/drilling_blue.png"))); // NOI18N
        btnDirectional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDirectionalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDirectionalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDirectionalMouseExited(evt);
            }
        });

        btnExtra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/extra_blue.png"))); // NOI18N
        btnExtra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExtraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExtraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExtraMouseExited(evt);
            }
        });

        btnBha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/bha_blue.png"))); // NOI18N
        btnBha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBhaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBhaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBhaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(footer1)
                .addGap(94, 94, 94))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDirectional, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDirectional, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(footer1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/home_white.png")));
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnDirectionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDirectionalMouseEntered
        btnDirectional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/drilling_white.png")));
    }//GEN-LAST:event_btnDirectionalMouseEntered

    private void btnExtraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExtraMouseEntered
        btnExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/extra_white.png")));
    }//GEN-LAST:event_btnExtraMouseEntered

    private void btnBhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBhaMouseEntered
        btnBha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/bha_white.png")));
    }//GEN-LAST:event_btnBhaMouseEntered

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        HomeContainer home = new HomeContainer();
        home.setSize(923, 632);
        home.setLocation(0, 0);

        content.removeAll();
        content.add(home, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnDirectionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDirectionalMouseClicked
        DrillingContainer drilling = new DrillingContainer();
        drilling.setSize(923, 632);
        drilling.setLocation(0, 0);

        content.removeAll();
        content.add(drilling, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnDirectionalMouseClicked

    private void btnExtraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExtraMouseClicked
        ExtraContainer extra = new ExtraContainer();
        extra.setSize(923, 632);
        extra.setLocation(0, 0);

        content.removeAll();
        content.add(extra, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnExtraMouseClicked

    private void btnBhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBhaMouseClicked
        BhaContainer bha = new BhaContainer();
        bha.setSize(923, 632);
        bha.setLocation(0, 0);

        content.removeAll();
        content.add(bha, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnBhaMouseClicked

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/home_blue.png")));
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnDirectionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDirectionalMouseExited
        btnDirectional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/drilling_blue.png")));
    }//GEN-LAST:event_btnDirectionalMouseExited

    private void btnExtraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExtraMouseExited
        btnExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/extra_blue.png")));
    }//GEN-LAST:event_btnExtraMouseExited

    private void btnBhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBhaMouseExited
        btnBha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/bha_blue.png")));
    }//GEN-LAST:event_btnBhaMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBha;
    private javax.swing.JLabel btnDirectional;
    private javax.swing.JLabel btnExtra;
    private javax.swing.JLabel btnHome;
    private javax.swing.JPanel content;
    private javax.swing.JLabel footer1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelLogo;
    // End of variables declaration//GEN-END:variables
}
