/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PVT;

import formulas.Bg;
import formulas.BgFormula;
import formulas.Bo;
import formulas.BoFormula;
import formulas.Bt;
import formulas.BtFormula;
import formulas.Capillary;
import formulas.DistributionPb;
import formulas.Equation;
import formulas.GOR;
import formulas.Porosity;
import formulas.Pseudo;
import formulas.RangesPb;
import formulas.RsStanding;
import formulas.SolutionOilGas1;
import formulas.SolutionOilGas2;
import formulas.Standing;
import formulas.Viscosity;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author EQUIPO
 */
public class Clasificacion_Fluidos extends javax.swing.JFrame {

    DefaultTableModel tblProperties = new DefaultTableModel();
    DefaultTableModel tblDensity = new DefaultTableModel();
    DefaultTableModel tblCorrection = new DefaultTableModel();

    public Clasificacion_Fluidos() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        this.pintarImagen(this.jLabelLogo, "/Images/Logo2.jpeg");
        setExtendedState(MAXIMIZED_BOTH);   
        selects();
        tablesCalsification();
        setTitleTableProperties();
        setTitleTableDensity();
        setTitleTableCorrections();
    }
    
    public void tablesCalsification(){
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        JTableHeader th;
        th = fluidTypeTable.getTableHeader();
        Font fuente = new Font("Verdana", Font.BOLD, 15);
        th.setFont(fuente);
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
        fluidTypeTable.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        fluidTypeTable.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        fluidTypeTable.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        fluidTypeTable.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        fluidTypeTable.getColumnModel().getColumn(4).setCellRenderer(Alinear);

        JTableHeader th2;
        th2 = mechanismRecoveryTable.getTableHeader();
        Font fuente2 = new Font("Verdana", Font.BOLD, 12);
        th2.setFont(fuente2);
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
        mechanismRecoveryTable.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        mechanismRecoveryTable.getColumnModel().getColumn(1).setCellRenderer(Alinear);

        InputStream is3 = getClass().getResourceAsStream("/Textos/Permeabilidad/RelativePermeabaility.txt");
        textoPermeRela(is3);
        InputStream is4 = getClass().getResourceAsStream("/Textos/Permeabilidad/Absolutepermeability.txt");
        textoPermeAbso(is4);

        buttonGroupFactor.add(RBEquationState);
        buttonGroupFactor.add(RBFactorZ);
        buttonGroupFactor.add(RBPseudo);
    }
    
    public void selects(){
        selectCurvaFases.addItem("Select");
        selectCurvaFases.addItem("Black Oil");
        selectCurvaFases.addItem("Volatile Oil");
        selectCurvaFases.addItem("Condensade Gas");
        selectCurvaFases.addItem("Wet Gas");
        selectCurvaFases.addItem("Dry Gas");
        selectCurvaFases.addItem("Alfastenic");

        selectColorTipo.addItem("Select");
        selectColorTipo.addItem("Dark");
        selectColorTipo.addItem("Colored");
        selectColorTipo.addItem("Ligthly Colored");
        selectColorTipo.addItem("Water White");
        selectColorTipo.addItem("No Liquid");

        selectRecoveryMechanism.addItem("Select");
        selectRecoveryMechanism.addItem("Rock and Fluid Expansion");
        selectRecoveryMechanism.addItem("Solution Gas Drive");
        selectRecoveryMechanism.addItem("Gas Cap Drive");
        selectRecoveryMechanism.addItem("Gravity Drainage");
        selectRecoveryMechanism.addItem("Aquifer Drive (Weak Aquifer)");
        selectRecoveryMechanism.addItem("Aquifer Drive (Strong Aquifer)");
        selectRecoveryMechanism.addItem("Combined Drive Mechanisms");
        
        selectPorVisCap.addItem("Select");
        selectPorVisCap.addItem("Porosity");
        selectPorVisCap.addItem("Viscosity");
        selectPorVisCap.addItem("Capillarity");
        selectPorVisCap.addItem("Gas and Oil Ratio");

        fluidSaturationCB.addItem("Select");
        fluidSaturationCB.addItem("Oil Saturation");
        fluidSaturationCB.addItem("Gas Saturation");
        fluidSaturationCB.addItem("Water Saturation");

        relativePermeabilityCB.addItem("Select");
        relativePermeabilityCB.addItem("Relative Permeability to Oil");
        relativePermeabilityCB.addItem("Relative Permeability to Gas");
        relativePermeabilityCB.addItem("Relative Permeability to Water");
        relativePermeabilityCB.addItem("Formula Explication");
    }

    public void setTitleTableProperties() {
        tblProperties.addColumn("Composition");
        tblProperties.addColumn("Yi");
        tblProperties.addColumn("Mi");
        tblProperties.addColumn("Yi * Mi");
        tblProperties.addColumn("yg");
        tblProperties.addColumn("Tci °F");
        tblProperties.addColumn("Tci °R");
        tblProperties.addColumn("Yi * Tci");
        tblProperties.addColumn("Pci (psi)");
        tblProperties.addColumn("Yi * Pci ( psi)");
        tblGases.setModel(tblProperties);
    }

    public double apparentMolecularWeight(double val1, double val2) {
        return (val1 / 100) * val2;
    }

    public double mixSpecificGravity(double val) {
        return val / 28.96;
    }

    public double fahrenheitToRankine(double val) {
        return val + 459.67;
    }

    public double yiTciR(double val1, double val2) {
        return (val1 / 100) * val2;
    }

    public double yiPciPsi(double val1, double val2) {
        return (val1 / 100) * val2;
    }

    public double total(
            double val1, double val2, double val3, double val4, double val5,
            double val6, double val7, double val8, double val9, double val10,
            double val11
    ) {
        return val1 + val2 + val3 + val4 + val5 + val6
                + val7 + val8 + val9 + val10 + val11;
    }

    public void getValuesTableProperties() {
        double n2Field = Double.parseDouble(n2.getText());
        double co2Field = Double.parseDouble(co2.getText());
        double h2sField = Double.parseDouble(h2s.getText());
        double ch4Field = Double.parseDouble(ch4.getText());
        double c2h6Field = Double.parseDouble(c2h6.getText());
        double c3h8Field = Double.parseDouble(c3h8.getText());
        double ic4h10Field = Double.parseDouble(ic4h10.getText());
        double nc4h10Field = Double.parseDouble(nc4h10.getText());
        double ic5h12Field = Double.parseDouble(ic5h12.getText());
        double nc5h12Field = Double.parseDouble(nc5h12.getText());
        double c6h14Field = Double.parseDouble(c6h14.getText());
        double sumApparentMolecularWeight = total(
                apparentMolecularWeight(n2Field, 26.0134),
                apparentMolecularWeight(co2Field, 44.01),
                apparentMolecularWeight(h2sField, 34.082),
                apparentMolecularWeight(ch4Field, 16.043),
                apparentMolecularWeight(c2h6Field, 30.07),
                apparentMolecularWeight(c3h8Field, 44.097),
                apparentMolecularWeight(ic4h10Field, 58.123),
                apparentMolecularWeight(nc4h10Field, 58.123),
                apparentMolecularWeight(ic5h12Field, 72.15),
                apparentMolecularWeight(nc5h12Field, 72.15),
                apparentMolecularWeight(c6h14Field, 86.17));

        Object[] n2Row = new Object[10];
        n2Row[0] = "N2";
        n2Row[1] = n2Field;
        n2Row[2] = String.format("%.2f", 26.0134);
        n2Row[3] = String.format("%.2f", apparentMolecularWeight(n2Field, 26.0134));
        n2Row[4] = String.format("%.2f", mixSpecificGravity(sumApparentMolecularWeight));
        n2Row[5] = String.format("%.2f", -232.49);
        n2Row[6] = String.format("%.2f", fahrenheitToRankine(-232.49));
        n2Row[7] = String.format("%.2f", yiTciR(n2Field, fahrenheitToRankine(-232.49)));
        n2Row[8] = String.format("%.2f", 492.8);
        n2Row[9] = String.format("%.2f", yiPciPsi(n2Field, 492.8));
        tblProperties.addRow(n2Row);

        Object[] co2Row = new Object[10];
        co2Row[0] = "CO2";
        co2Row[1] = co2Field;
        co2Row[2] = String.format("%.2f", 44.01);
        co2Row[3] = String.format("%.2f", apparentMolecularWeight(co2Field, 44.01));
        co2Row[4] = "";
        co2Row[5] = String.format("%.2f", 87.73);
        co2Row[6] = String.format("%.2f", fahrenheitToRankine(87.73));
        co2Row[7] = String.format("%.2f", yiTciR(co2Field, fahrenheitToRankine(87.73)));
        co2Row[8] = String.format("%.2f", 1069.5);
        co2Row[9] = String.format("%.2f", yiPciPsi(co2Field, 1069.5));
        tblProperties.addRow(co2Row);

        Object[] h2sRow = new Object[10];
        h2sRow[0] = "H2S";
        h2sRow[1] = h2sField;
        h2sRow[2] = String.format("%.2f", 34.082);
        h2sRow[3] = String.format("%.2f", apparentMolecularWeight(h2sField, 34.082));
        h2sRow[4] = "";
        h2sRow[5] = String.format("%.2f", 212.4);
        h2sRow[6] = String.format("%.2f", fahrenheitToRankine(212.4));
        h2sRow[7] = String.format("%.2f", yiTciR(h2sField, fahrenheitToRankine(212.4)));
        h2sRow[8] = String.format("%.2f", 1300d);
        h2sRow[9] = String.format("%.2f", yiPciPsi(h2sField, 1300d));
        tblProperties.addRow(h2sRow);

        Object[] ch4Row = new Object[10];
        ch4Row[0] = "CH4";
        ch4Row[1] = ch4Field;
        ch4Row[2] = String.format("%.2f", 16.043);
        ch4Row[3] = String.format("%.2f", apparentMolecularWeight(ch4Field, 16.043));
        ch4Row[4] = "";
        ch4Row[5] = String.format("%.2f", -116.66);
        ch4Row[6] = String.format("%.2f", fahrenheitToRankine(-116.66));
        ch4Row[7] = String.format("%.2f", yiTciR(ch4Field, fahrenheitToRankine(-116.66)));
        ch4Row[8] = String.format("%.2f", 667d);
        ch4Row[9] = String.format("%.2f", yiPciPsi(ch4Field, 667d));
        tblProperties.addRow(ch4Row);

        Object[] c2h6Row = new Object[10];
        c2h6Row[0] = "C2H6";
        c2h6Row[1] = c2h6Field;
        c2h6Row[2] = String.format("%.2f", 30.07);
        c2h6Row[3] = String.format("%.2f", apparentMolecularWeight(c2h6Field, 30.07));
        c2h6Row[4] = "";
        c2h6Row[5] = String.format("%.2f", 90.07);
        c2h6Row[6] = String.format("%.2f", fahrenheitToRankine(90.07));
        c2h6Row[7] = String.format("%.2f", yiTciR(c2h6Field, fahrenheitToRankine(90.07)));
        c2h6Row[8] = String.format("%.2f", 707.8);
        c2h6Row[9] = String.format("%.2f", yiPciPsi(c2h6Field, 707.8));
        tblProperties.addRow(c2h6Row);

        Object[] c3h8Row = new Object[10];
        c3h8Row[0] = "C3H8";
        c3h8Row[1] = c3h8Field;
        c3h8Row[2] = String.format("%.2f", 44.097);
        c3h8Row[3] = String.format("%.2f", apparentMolecularWeight(c3h8Field, 44.097));
        c3h8Row[4] = "";
        c3h8Row[5] = String.format("%.2f", 205.92);
        c3h8Row[6] = String.format("%.2f", fahrenheitToRankine(205.92));
        c3h8Row[7] = String.format("%.2f", yiTciR(c3h8Field, fahrenheitToRankine(205.92)));
        c3h8Row[8] = String.format("%.2f", 615d);
        c3h8Row[9] = String.format("%.2f", yiPciPsi(c3h8Field, 615d));
        tblProperties.addRow(c3h8Row);

        Object[] ic4h10Row = new Object[10];
        ic4h10Row[0] = "i-C4H10";
        ic4h10Row[1] = ic4h10Field;
        ic4h10Row[2] = String.format("%.2f", 58.123);
        ic4h10Row[3] = String.format("%.2f", apparentMolecularWeight(ic4h10Field, 58.123));
        ic4h10Row[4] = "";
        ic4h10Row[5] = String.format("%.2f", 527.9);
        ic4h10Row[6] = String.format("%.2f", fahrenheitToRankine(527.9));
        ic4h10Row[7] = String.format("%.2f", yiTciR(ic4h10Field, fahrenheitToRankine(527.9)));
        ic4h10Row[8] = String.format("%.2f", 274.41);
        ic4h10Row[9] = String.format("%.2f", yiPciPsi(ic4h10Field, 274.41));
        tblProperties.addRow(ic4h10Row);

        Object[] nc4h10Row = new Object[10];
        nc4h10Row[0] = "n-C4H10";
        nc4h10Row[1] = nc4h10Field;
        nc4h10Row[2] = String.format("%.2f", 58.123);
        nc4h10Row[3] = String.format("%.2f", apparentMolecularWeight(nc4h10Field, 58.123));
        nc4h10Row[4] = "";
        nc4h10Row[5] = String.format("%.2f", 305.51);
        nc4h10Row[6] = String.format("%.2f", fahrenheitToRankine(305.51));
        nc4h10Row[7] = String.format("%.2f", yiTciR(nc4h10Field, fahrenheitToRankine(305.51)));
        nc4h10Row[8] = String.format("%.2f", 548.8);
        nc4h10Row[9] = String.format("%.2f", yiPciPsi(nc4h10Field, 548.8));
        tblProperties.addRow(nc4h10Row);

        Object[] ic5h12Row = new Object[10];
        ic5h12Row[0] = "i-C5H12";
        ic5h12Row[1] = ic5h12Field;
        ic5h12Row[2] = String.format("%.2f", 72.15);
        ic5h12Row[3] = String.format("%.2f", apparentMolecularWeight(ic5h12Field, 72.15));
        ic5h12Row[4] = "";
        ic5h12Row[5] = String.format("%.2f", 368.96);
        ic5h12Row[6] = String.format("%.2f", fahrenheitToRankine(368.96));
        ic5h12Row[7] = String.format("%.2f", yiTciR(ic5h12Field, fahrenheitToRankine(368.96)));
        ic5h12Row[8] = String.format("%.2f", 490.4);
        ic5h12Row[9] = String.format("%.2f", yiPciPsi(ic5h12Field, 490.4));
        tblProperties.addRow(ic5h12Row);

        Object[] nc5h12Row = new Object[10];
        nc5h12Row[0] = "n-C5H12";
        nc5h12Row[1] = nc5h12Field;
        nc5h12Row[2] = String.format("%.2f", 72.15);
        nc5h12Row[3] = String.format("%.2f", apparentMolecularWeight(nc5h12Field, 72.15));
        nc5h12Row[4] = "";
        nc5h12Row[5] = String.format("%.2f", 385.7);
        nc5h12Row[6] = String.format("%.2f", fahrenheitToRankine(385.7));
        nc5h12Row[7] = String.format("%.2f", yiTciR(nc5h12Field, fahrenheitToRankine(385.7)));
        nc5h12Row[8] = String.format("%.2f", 488.1);
        nc5h12Row[9] = String.format("%.2f", yiPciPsi(nc5h12Field, 488.1));
        tblProperties.addRow(nc5h12Row);

        Object[] c6h14Row = new Object[10];
        c6h14Row[0] = "C6H14";
        c6h14Row[1] = c6h14Field;
        c6h14Row[2] = String.format("%.2f", 86.17);
        c6h14Row[3] = String.format("%.2f", apparentMolecularWeight(c6h14Field, 86.17));
        c6h14Row[4] = "";
        c6h14Row[5] = String.format("%.2f", 451.8);
        c6h14Row[6] = String.format("%.2f", fahrenheitToRankine(451.8));
        c6h14Row[7] = String.format("%.2f", yiTciR(c6h14Field, fahrenheitToRankine(451.8)));
        c6h14Row[8] = String.format("%.2f", 439.5);
        c6h14Row[9] = String.format("%.2f", yiPciPsi(c6h14Field, 439.5));
        tblProperties.addRow(c6h14Row);
    }

    public void setTitleTableDensity() {
        tblDensity.addColumn("Psr");
        tblDensity.addColumn("Tsr");
        tblDensity.addColumn("Grafic Z");
        tblDensity.addColumn("Density");
        tblDensity.addColumn("Vol. Factor");
        tblDensityValue.setModel(tblDensity);
    }

    public double psrOrTsr(double val1, double val2) {
        return val1 / val2;
    }

    public double densidadLbPerFt3(double presion, double apparentMolecularWeight,
            double factorZ, double CONST_UNIVER_GAS_R, double temperature) {
        return (presion * apparentMolecularWeight)
                / (factorZ * CONST_UNIVER_GAS_R * temperature);
    }

    public double volumetricFactor(double CONST_VOL_FACTOR, double factorZ,
            double temperature, double presion) {
        return (CONST_VOL_FACTOR * factorZ * temperature) / presion;
    }

    public void getValuesTableDensity() {
        double n2Field = Double.parseDouble(n2.getText());
        double co2Field = Double.parseDouble(co2.getText());
        double h2sField = Double.parseDouble(h2s.getText());
        double ch4Field = Double.parseDouble(ch4.getText());
        double c2h6Field = Double.parseDouble(c2h6.getText());
        double c3h8Field = Double.parseDouble(c3h8.getText());
        double ic4h10Field = Double.parseDouble(ic4h10.getText());
        double nc4h10Field = Double.parseDouble(nc4h10.getText());
        double ic5h12Field = Double.parseDouble(ic5h12.getText());
        double nc5h12Field = Double.parseDouble(nc5h12.getText());
        double c6h14Field = Double.parseDouble(c6h14.getText());
        double CONST_UNIVER_GAS_R = 10.73159;
        double CONST_VOL_FACTOR = 0.02829;
        double sumApparentMolecularWeight = total(
                apparentMolecularWeight(n2Field, 26.0134),
                apparentMolecularWeight(co2Field, 44.01),
                apparentMolecularWeight(h2sField, 34.082),
                apparentMolecularWeight(ch4Field, 16.043),
                apparentMolecularWeight(c2h6Field, 30.07),
                apparentMolecularWeight(c3h8Field, 44.097),
                apparentMolecularWeight(ic4h10Field, 58.123),
                apparentMolecularWeight(nc4h10Field, 58.123),
                apparentMolecularWeight(ic5h12Field, 72.15),
                apparentMolecularWeight(nc5h12Field, 72.15),
                apparentMolecularWeight(c6h14Field, 86.17));
        double pressureValue = Double.parseDouble(pressure.getText());
        double fareTemperatureValue = Double.parseDouble(farenTemperature.getText());
        double graficZValue = Double.parseDouble(graficZ.getText());
        rankTemperature.setText(Double.toString(fahrenheitToRankine(fareTemperatureValue)));

        Object[] cals = new Object[5];
        cals[0] = String.format("%.2f", psrOrTsr(pressureValue, total(
                yiPciPsi(n2Field, 492.8),
                yiPciPsi(co2Field, 1069.5),
                yiPciPsi(h2sField, 1300d),
                yiPciPsi(ch4Field, 667d),
                yiPciPsi(c2h6Field, 707.8),
                yiPciPsi(c3h8Field, 615d),
                yiPciPsi(ic4h10Field, 274.41),
                yiPciPsi(nc4h10Field, 548.8),
                yiPciPsi(ic5h12Field, 490.4),
                yiPciPsi(nc5h12Field, 488.1),
                yiPciPsi(c6h14Field, 439.5))));
        cals[1] = String.format("%.2f", psrOrTsr(fahrenheitToRankine(fareTemperatureValue), total(
                yiTciR(n2Field, fahrenheitToRankine(-232.49)),
                yiTciR(co2Field, fahrenheitToRankine(87.73)),
                yiTciR(h2sField, fahrenheitToRankine(212.4)),
                yiTciR(ch4Field, fahrenheitToRankine(-116.66)),
                yiTciR(c2h6Field, fahrenheitToRankine(90.07)),
                yiTciR(c3h8Field, fahrenheitToRankine(205.92)),
                yiTciR(ic4h10Field, fahrenheitToRankine(527.9)),
                yiTciR(nc4h10Field, fahrenheitToRankine(305.51)),
                yiTciR(ic5h12Field, fahrenheitToRankine(368.96)),
                yiTciR(nc5h12Field, fahrenheitToRankine(385.7)),
                yiTciR(c6h14Field, fahrenheitToRankine(451.8)))));
        cals[2] = String.format("%.2f", graficZValue);
        cals[3] = String.format("%.2f", densidadLbPerFt3(
                pressureValue,
                sumApparentMolecularWeight,
                graficZValue,
                CONST_UNIVER_GAS_R,
                fahrenheitToRankine(fareTemperatureValue)));
        cals[4] = String.format("%.2f", volumetricFactor(
                CONST_VOL_FACTOR,
                graficZValue,
                fahrenheitToRankine(fareTemperatureValue),
                pressureValue));
        tblDensity.addRow(cals);
    }

    public void setTitleTableCorrections() {
        tblCorrection.addColumn("A");
        tblCorrection.addColumn("B");
        tblCorrection.addColumn("Fsk");
        tblCorrection.addColumn("Tcc");
        tblCorrection.addColumn("Pcc");
        tblCorrection.addColumn("Tsr");
        tblCorrection.addColumn("Psr");
        tblCorrection.addColumn("Grafic Z");
        tblCorrection.addColumn("Corrected Density");
        tblCorrection.addColumn("Bg");
        tblCorrections.setModel(tblCorrection);
    }

    public double factorFSK(double CONST_FSK_1, double a, double CONST_FSK_3,
            double CONST_FSK_4, double CONST_FSK_2, double b, double CONST_FSK_5,
            double CONST_FSK_6) {
        return (CONST_FSK_1 * (Math.pow(a, CONST_FSK_3) - Math.pow(a, CONST_FSK_4))
                + (CONST_FSK_2 * (Math.pow(b, CONST_FSK_5) - Math.pow(b, CONST_FSK_6))));
    }
    
    public double pcc(double sumYiPciPsi, double tcc, double sumYiTciR, double B, double fsk){
        return (sumYiPciPsi*tcc)/(sumYiTciR+B*(1-B)*fsk);
    }
    
    public double correctedDensity(double pressureValue, 
            double sumApparentMolecularWeight, double graficZValue, 
            double rankineTemp){
        return (pressureValue*sumApparentMolecularWeight)/(graficZValue*10.73*rankineTemp);
    }
    
    public double bg(double graficZValue, double rankineTemp, double pressureValue){
        return (0.02829*graficZValue*rankineTemp/pressureValue);
    }

    public void getValuesTableCorrections() {
        double n2Field = Double.parseDouble(n2.getText());
        double co2Field = Double.parseDouble(co2.getText());
        double h2sField = Double.parseDouble(h2s.getText());
        double ch4Field = Double.parseDouble(ch4.getText());
        double c2h6Field = Double.parseDouble(c2h6.getText());
        double c3h8Field = Double.parseDouble(c3h8.getText());
        double ic4h10Field = Double.parseDouble(ic4h10.getText());
        double nc4h10Field = Double.parseDouble(nc4h10.getText());
        double ic5h12Field = Double.parseDouble(ic5h12.getText());
        double nc5h12Field = Double.parseDouble(nc5h12.getText());
        double c6h14Field = Double.parseDouble(c6h14.getText());
        double CONST_FSK_1 = 120;
        double CONST_FSK_2 = 15;
        double CONST_FSK_3 = 0.9f;
        double CONST_FSK_4 = 1.6f;
        double CONST_FSK_5 = 0.5f;
        double CONST_FSK_6 = 4;
        double pressureValue = Double.parseDouble(pressure.getText());
        double fareTemperatureValue = Double.parseDouble(farenTemperature.getText());
        double graficZValue = Double.parseDouble(graficZ.getText());
        double sumApparentMolecularWeight = total(
                apparentMolecularWeight(n2Field, 26.0134),
                apparentMolecularWeight(co2Field, 44.01),
                apparentMolecularWeight(h2sField, 34.082),
                apparentMolecularWeight(ch4Field, 16.043),
                apparentMolecularWeight(c2h6Field, 30.07),
                apparentMolecularWeight(c3h8Field, 44.097),
                apparentMolecularWeight(ic4h10Field, 58.123),
                apparentMolecularWeight(nc4h10Field, 58.123),
                apparentMolecularWeight(ic5h12Field, 72.15),
                apparentMolecularWeight(nc5h12Field, 72.15),
                apparentMolecularWeight(c6h14Field, 86.17));
        double sumYiTciR = total(
                yiTciR(n2Field, fahrenheitToRankine(-232.49)),
                yiTciR(co2Field, fahrenheitToRankine(87.73)),
                yiTciR(h2sField, fahrenheitToRankine(212.4)),
                yiTciR(ch4Field, fahrenheitToRankine(-116.66)),
                yiTciR(c2h6Field, fahrenheitToRankine(90.07)),
                yiTciR(c3h8Field, fahrenheitToRankine(205.92)),
                yiTciR(ic4h10Field, fahrenheitToRankine(527.9)),
                yiTciR(nc4h10Field, fahrenheitToRankine(305.51)),
                yiTciR(ic5h12Field, fahrenheitToRankine(368.96)),
                yiTciR(nc5h12Field, fahrenheitToRankine(385.7)),
                yiTciR(c6h14Field, fahrenheitToRankine(451.8)));
        double sumYiPciPsi = total(
                yiPciPsi(n2Field, 492.8), 
                yiPciPsi(co2Field, 1069.5), 
                yiPciPsi(h2sField, 1300d), 
                yiPciPsi(ch4Field, 667d), 
                yiPciPsi(c2h6Field, 707.8), 
                yiPciPsi(c3h8Field, 615d), 
                yiPciPsi(ic4h10Field, 274.41), 
                yiPciPsi(nc4h10Field, 548.8), 
                yiPciPsi(ic5h12Field, 490.4), 
                yiPciPsi(nc5h12Field, 488.1), 
                yiPciPsi(c6h14Field, 439.5));
        double A = (co2Field / 100) + (h2sField / 100);
        double B = (h2sField / 100);
        double fsk = factorFSK(CONST_FSK_1, A, CONST_FSK_3, 
                CONST_FSK_4, CONST_FSK_2, B, CONST_FSK_5, CONST_FSK_6);
        double tcc = sumYiTciR -fsk;
        double pcc = pcc(sumYiPciPsi, tcc, sumYiTciR, B, fsk);
        double rankineTemp = fahrenheitToRankine(fareTemperatureValue);
        double correctDensity = correctedDensity(
                pressureValue, 
                sumApparentMolecularWeight, 
                graficZValue, 
                rankineTemp);
        double bg = bg(graficZValue, rankineTemp, pressureValue);
        
        Object[] correction = new Object[10];
        correction[0] = String.format("%.2f", A);
        correction[1] = String.format("%.2f", B);
        correction[2] = String.format("%.2f", fsk);
        correction[3] = String.format("%.2f", tcc);
        correction[4] = String.format("%.2f", pcc);
        correction[5] = String.format("%.2f", rankineTemp/tcc);
        correction[6] = String.format("%.2f", pressureValue/pcc);
        correction[7] = String.format("%.2f", graficZValue);
        correction[8] = String.format("%.2f", correctDensity);
        correction[9] = String.format("%.2f", bg);
        tblCorrection.addRow(correction);
    }
    
    public void graphValues(){
        double p1 = Double.parseDouble(pres1.getText());
        double p2 = Double.parseDouble(pres2.getText());
        double p3 = Double.parseDouble(pres3.getText());
        double p4 = Double.parseDouble(pres4.getText());
        double p5 = Double.parseDouble(pres5.getText());
        double p6 = Double.parseDouble(pres6.getText());
        float zVal1 = (float) Double.parseDouble(z1.getText());
        float zVal2 = (float) Double.parseDouble(z2.getText());
        float zVal3 = (float) Double.parseDouble(z3.getText());
        float zVal4 = (float) Double.parseDouble(z4.getText());
        float zVal5 = (float) Double.parseDouble(z5.getText());
        float zVal6 = (float) Double.parseDouble(z6.getText());
        double d1 = Double.parseDouble(den1.getText());
        double d2 = Double.parseDouble(den2.getText());
        double d3 = Double.parseDouble(den3.getText());
        double d4 = Double.parseDouble(den4.getText());
        double d5 = Double.parseDouble(den5.getText());
        double d6 = Double.parseDouble(den6.getText());
        double v1 = Double.parseDouble(vol1.getText());
        double v2 = Double.parseDouble(vol2.getText());
        double v3 = Double.parseDouble(vol3.getText());
        double v4 = Double.parseDouble(vol4.getText());
        double v5 = Double.parseDouble(vol5.getText());
        double v6 = Double.parseDouble(vol6.getText());
        
        XYSeries oSeries1 = new XYSeries("Volumetric Factor");
        oSeries1.add(p1, v1);
        oSeries1.add(p2, v2);
        oSeries1.add(p3, v3);
        oSeries1.add(p4, v4);
        oSeries1.add(p5, v5);
        oSeries1.add(p6, v6);
        XYSeriesCollection oDataSet1 = new XYSeriesCollection();
        oDataSet1.addSeries(oSeries1);
        JFreeChart oChart1 = ChartFactory.createXYLineChart(
                "Volumetric Factor Bg p3/PCS", 
                "Pressure (psia)", 
                "Volumetric facor p3/PCS", 
                oDataSet1, 
                PlotOrientation.VERTICAL, 
                true, false, false);
        ChartPanel oPanel1 = new ChartPanel(oChart1);
        plnVolmetricFactor.setLayout(new java.awt.BorderLayout());
        plnVolmetricFactor.add(oPanel1);
        plnVolmetricFactor.validate();
        
        XYSeries oSeries2 = new XYSeries("Z Factor");
        oSeries2.add(p1, zVal1);
        oSeries2.add(p2, zVal2);
        oSeries2.add(p3, zVal3);
        oSeries2.add(p4, zVal4);
        oSeries2.add(p5, zVal5);
        oSeries2.add(p6, zVal6);
        XYSeriesCollection oDataSet2 = new XYSeriesCollection();
        oDataSet2.addSeries(oSeries2);
        JFreeChart oChart2 = ChartFactory.createXYLineChart(
                "Compressibility Factor Z", 
                "Pressure (psia)", 
                "Compressibility Factor Z", 
                oDataSet2, 
                PlotOrientation.VERTICAL, 
                true, false, false);
        ChartPanel oPanel2 = new ChartPanel(oChart2);
        plnFactorZ.setLayout(new java.awt.BorderLayout());
        plnFactorZ.add(oPanel2);
        plnFactorZ.validate();
        
        XYSeries oSeries3 = new XYSeries("Density");
        oSeries3.add(p1, d1);
        oSeries3.add(p2, d2);
        oSeries3.add(p3, d3);
        oSeries3.add(p4, d4);
        oSeries3.add(p5, d5);
        oSeries3.add(p6, d6);
        XYSeriesCollection oDataSet3 = new XYSeriesCollection();
        oDataSet3.addSeries(oSeries3);
        JFreeChart oChart3 = ChartFactory.createXYLineChart(
                "Density", 
                "Pressure (psia)", 
                "Density", 
                oDataSet3, 
                PlotOrientation.VERTICAL, 
                true, false, false);
        ChartPanel oPanel3 = new ChartPanel(oChart3);
        plnDensity.setLayout(new java.awt.BorderLayout());
        plnDensity.add(oPanel3);
        plnDensity.validate();
    }
    
    public boolean RevNumeros() {
        Operaciones op = new Operaciones();
        if (op.getCheckempty(APIGravity.getText(), RGP.getText(), Molar.getText())) {
            JOptionPane.showMessageDialog(this, "Campos Vacios", "ERROR", 1);
            return false;
        } else {
            if (op.getCheckIsNumeric()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Usa solo Números", "ERROR", 1);
                return false;
            }
        }
    }

    public void textoClasificacion(InputStream is) {
        jTextAreaClasificacion.setText("");
        try {

            BufferedReader read = new BufferedReader(new InputStreamReader(is));
            String linea = read.readLine();
            while (linea != null) {
                jTextAreaClasificacion.append(linea + "\n");
                linea = read.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Clasificacion_Fluidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void textoRecoveryMechanisms(InputStream is) {
        jTextAreaRecovey.setText("");
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(is));
            String linea = read.readLine();
            while (linea != null) {
                jTextAreaRecovey.append(linea + "\n");
                linea = read.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Clasificacion_Fluidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void textoPorVisCapGOR(InputStream is) {
        JTextPorVisCapiGOR.setText("");
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(is));
            String linea = read.readLine();
            while (linea != null) {
                JTextPorVisCapiGOR.append(linea + "\n");
                linea = read.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Clasificacion_Fluidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void textoFluidSaturation(InputStream is) {
        textSaturation.setText("");
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(is));
            String linea = read.readLine();
            while (linea != null) {
                textSaturation.append(linea + "\n");
                linea = read.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Clasificacion_Fluidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void textoDarcyLaw(InputStream is) {
        textDarcy.setText("");
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(is));
            String linea = read.readLine();
            while (linea != null) {
                textDarcy.append(linea + "\n");
                linea = read.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Clasificacion_Fluidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void textoPermeRela(InputStream is) {
        textRelative.setText("");
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(is));
            String linea = read.readLine();
            while (linea != null) {
                textRelative.append(linea + "\n");
                linea = read.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Clasificacion_Fluidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void textoPermeAbso(InputStream is) {
        textAbsolute.setText("");
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(is));
            String linea = read.readLine();
            while (linea != null) {
                textAbsolute.append(linea + "\n");
                linea = read.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Clasificacion_Fluidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pintarImagen(JLabel lbl, String ruta) {
        lbl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ruta)).getImage().getScaledInstance(
                lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupFactor = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        selectCurvaFases = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        curvaFases = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButtomFluidTypeEvaluate = new javax.swing.JButton();
        APIGravity = new javax.swing.JTextField();
        RGP = new javax.swing.JTextField();
        Molar = new javax.swing.JTextField();
        selectColorTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaTypeFluid = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        fluidTypeTable = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        mechanismRecoveryTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaRecovey = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        selectRecoveryMechanism = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaClasificacion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        fotoPoroVisCapiGOR = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JTextPorVisCapiGOR = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        selectPorVisCap = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        textDarcy = new javax.swing.JTextArea();
        DarcyImage = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textSaturation = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        fluidSaturationCB = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        textAbsolute = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        textRelative = new javax.swing.JTextArea();
        relativePermeabilityCB = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        RBEquationState = new javax.swing.JRadioButton();
        RBPseudo = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        RBFactorZ = new javax.swing.JRadioButton();
        jButton10 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTextArea10 = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane24 = new javax.swing.JScrollPane();
        tblGases = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblDensityValue = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        farenTemperature = new javax.swing.JTextField();
        rankTemperature = new javax.swing.JTextField();
        pressure = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        graficZ = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tblCorrections = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        plnVolmetricFactor = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        plnFactorZ = new javax.swing.JPanel();
        plnDensity = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel40 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        co2 = new javax.swing.JTextField();
        h2s = new javax.swing.JTextField();
        ch4 = new javax.swing.JTextField();
        c2h6 = new javax.swing.JTextField();
        c3h8 = new javax.swing.JTextField();
        ic4h10 = new javax.swing.JTextField();
        nc4h10 = new javax.swing.JTextField();
        ic5h12 = new javax.swing.JTextField();
        nc5h12 = new javax.swing.JTextField();
        c6h14 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        n2 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        pres1 = new javax.swing.JTextField();
        pres2 = new javax.swing.JTextField();
        pres4 = new javax.swing.JTextField();
        pres3 = new javax.swing.JTextField();
        z1 = new javax.swing.JTextField();
        z3 = new javax.swing.JTextField();
        z2 = new javax.swing.JTextField();
        z4 = new javax.swing.JTextField();
        vol1 = new javax.swing.JTextField();
        den2 = new javax.swing.JTextField();
        den3 = new javax.swing.JTextField();
        den4 = new javax.swing.JTextField();
        den1 = new javax.swing.JTextField();
        vol2 = new javax.swing.JTextField();
        vol4 = new javax.swing.JTextField();
        vol3 = new javax.swing.JTextField();
        jPanel47 = new javax.swing.JPanel();
        pres5 = new javax.swing.JTextField();
        pres6 = new javax.swing.JTextField();
        z5 = new javax.swing.JTextField();
        z6 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        den6 = new javax.swing.JTextField();
        vol5 = new javax.swing.JTextField();
        vol6 = new javax.swing.JTextField();
        den5 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        jScrollPane25 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
        jLabel65 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        label3 = new java.awt.Label();
        jPanel51 = new javax.swing.JPanel();
        label4 = new java.awt.Label();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel43 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PVTPEDIA Academic");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 372));

        selectCurvaFases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCurvaFasesActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Fluid Type");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButtomFluidTypeEvaluate.setText("Evaluate");
        jButtomFluidTypeEvaluate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtomFluidTypeEvaluateActionPerformed(evt);
            }
        });

        jLabel4.setText("API Gravity");

        jLabel5.setText("RGP (scf/STB)");

        jLabel6.setText("% Molar C7+");

        jLabel7.setText("Color");

        jTextAreaTypeFluid.setEditable(false);
        jTextAreaTypeFluid.setColumns(20);
        jTextAreaTypeFluid.setRows(5);
        jScrollPane3.setViewportView(jTextAreaTypeFluid);

        fluidTypeTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        fluidTypeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Black Oil", "< 45°", "< 1750", "> 20%", "Dark"},
                {"Volatile Oil", "> 40°", "1750<x<3200", "12%<x<20%", "Colored"},
                {"Retrograde Gas", "> 40°", "> 3200", "> 12.5%", "Ligthly Colored"},
                {"Wet Gas", "> 70", "> 15000", "> 4%", "Water White"},
                {"Dry Gas", "No Liquid", "> 100000", "< 0.8%", "No Liquid"}
            },
            new String [] {
                "Fluid Type", "API Gravity", "RGP (scf/SBT)", "4% Molar C7+", "Tan Liquid Color"
            }
        ));
        jScrollPane2.setViewportView(fluidTypeTable);
        if (fluidTypeTable.getColumnModel().getColumnCount() > 0) {
            fluidTypeTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jTextField4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Naturally Occuring Drive Mechanism and Associated Recovery Factors in Oil Reservoirs");
        jTextField4.setBorder(null);

        mechanismRecoveryTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mechanismRecoveryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Rock an Fluid Expansion", "Up to 5 percent"},
                {"Solution Gas Drive", "20"},
                {"Gas Cap Drive", "30"},
                {"Gravity Drainage", "40"},
                {"Aquifer Drive (Weak Aquifer)", "35"},
                {"Aquifer Drive (Strong Aquifer)", "45"},
                {"Combined drive Mechanisms", "60 Very Rarely This High"}
            },
            new String [] {
                "Recovery Mechanism", "Typical Recovery Efficencies (Percent STOOPIP)"
            }
        ));
        jScrollPane4.setViewportView(mechanismRecoveryTable);
        if (mechanismRecoveryTable.getColumnModel().getColumnCount() > 0) {
            mechanismRecoveryTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jTextAreaRecovey.setEditable(false);
        jTextAreaRecovey.setColumns(20);
        jTextAreaRecovey.setLineWrap(true);
        jTextAreaRecovey.setRows(5);
        jTextAreaRecovey.setWrapStyleWord(true);
        jScrollPane5.setViewportView(jTextAreaRecovey);

        jLabel2.setText("Recovery Mechanism");

        selectRecoveryMechanism.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRecoveryMechanismActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(selectRecoveryMechanism, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(APIGravity, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel5))
                                    .addComponent(Molar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RGP, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtomFluidTypeEvaluate)))
                            .addComponent(selectColorTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(APIGravity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(RGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Molar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jButtomFluidTypeEvaluate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(selectColorTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectRecoveryMechanism, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextAreaClasificacion.setEditable(false);
        jTextAreaClasificacion.setColumns(20);
        jTextAreaClasificacion.setLineWrap(true);
        jTextAreaClasificacion.setRows(5);
        jTextAreaClasificacion.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaClasificacion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(curvaFases, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectCurvaFases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectCurvaFases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(curvaFases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Fluid Classification", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Porosity, Viscosity, Capillarity, GOR "));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(fotoPoroVisCapiGOR, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoPoroVisCapiGOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        JTextPorVisCapiGOR.setEditable(false);
        JTextPorVisCapiGOR.setColumns(20);
        JTextPorVisCapiGOR.setLineWrap(true);
        JTextPorVisCapiGOR.setRows(5);
        JTextPorVisCapiGOR.setWrapStyleWord(true);
        jScrollPane6.setViewportView(JTextPorVisCapiGOR);

        jLabel3.setText("Choose an item ");

        selectPorVisCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPorVisCapActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setText("To know more, click on the following buttons");
        jTextField1.setBorder(null);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton1.setText("Porosity");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton2.setText("Viscosity");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton3.setText("Capillarity");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton4.setText("GOR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(selectPorVisCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectPorVisCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Fluid Saturation and Darcy's Law"));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Darcy's Law"));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

        textDarcy.setEditable(false);
        textDarcy.setColumns(20);
        textDarcy.setLineWrap(true);
        textDarcy.setRows(5);
        textDarcy.setText("The unit of the Darcy is defined as the permeability, k, required to allow a flow rate, qw, of one cc of water per second through a medium with a cross-sectional area, A, of one cm2, with an applied pressure gradient, Δp/ΔL, of one atm/cm. As it turns out, the Darcy as a unit is too large for most field applications. In reservoir engineering we typically work with the millidarcy, md.\nDarcy’s Law has several important assumptions associated with it. These include:\n- A rigid porous medium (incompressible medium with no transport of rock grains, e.g. fines movement).\n- An incompressible, homogeneous, Newtonian fluid that fully saturates (single-phase) the porous medium.\n- Steady-state, isothermal, and laminar (low Reynolds number) flow conditions.\n- No interactions between the porous medium and the fluid flowing through it\n- A no-slip interface between the porous medium and the fluid flowing through it (zero velocity boundary condition at the rock-fluid interface).");
        textDarcy.setWrapStyleWord(true);
        jScrollPane8.setViewportView(textDarcy);

        DarcyImage.setBackground(new java.awt.Color(255, 255, 255));
        DarcyImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FluidSaturation_DarcyLaw/darcyLaw2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(DarcyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane8)
                        .addContainerGap())))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarcyImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Fluid Saturation"));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        textSaturation.setEditable(false);
        textSaturation.setColumns(20);
        textSaturation.setLineWrap(true);
        textSaturation.setRows(5);
        textSaturation.setText("Saturation is defined as that fraction, or percent, of the pore volume occupied by a particular fluid (oil, gas, or water)\nThe fluids in most reservoirs are believed to have reached a state of equilibrium and, therefore, will have become separated according to their density, i.e., oil overlain by gas and underlain by water. In addition to the bottom (or edge) water, there will be connate water distributed throughout the oil and gas zones.\nConnate (interstitial) water saturation Swc is important primarily because it reduces the amount of space available between oil and gas. It is generally not uniformly distributed throughout the reservoir but varies with permeability, lithology, and height above the free water table.");
        textSaturation.setWrapStyleWord(true);
        jScrollPane7.setViewportView(textSaturation);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FluidSaturation_DarcyLaw/fluidSaturation.jpg"))); // NOI18N

        fluidSaturationCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fluidSaturationCBActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FluidSaturation_DarcyLaw/SoSgSw.png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fluidSaturationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fluidSaturationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Solution Oil Gas (Rs) - Bubble Point Pressure (Pb)"));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Rs"));

        jScrollPane16.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea6.setEditable(false);
        jTextArea6.setColumns(20);
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(5);
        jTextArea6.setText("When oil is transported to the surface, we learned that it shrinks. It shrinks because gas evolves out of the oil as the pressure decreases. The gas that evolves from oil as it is transported from reservoir to surface conditions is called solution gas.");
        jTextArea6.setWrapStyleWord(true);
        jScrollPane16.setViewportView(jTextArea6);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jLabel20.setText("Reservoir pressure above the bubble point.");

        jScrollPane15.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);
        jTextArea5.setText("The amount of gas dissolved in a unit volume of oil at a specified temperature and pressure is defined as the solution gas oil ratio. When the reservoir pressure is above the bubble point, all of the available gases are dissolved in oil, leading to a maximum and constant solution gas oil ratio. Below the bubble point pressure, the liberation of gas bubbles from crude oil reduces the solution gas oil ratio (see Fig. 1.1). It is well known that the solution gas oil ratio strongly depends on the reservoir pressure, reservoir temperature, oil density, and gas density.");
        jTextArea5.setWrapStyleWord(true);
        jScrollPane15.setViewportView(jTextArea5);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jLabel21.setText("Typical Solution Gas-Oil Ratio Shape");

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton8.setText("Show");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton7.setText("Show");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Using Standing Correlation");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane15)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7)))
                        .addGap(26, 26, 26)))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18))
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder("Pb"));

        jScrollPane17.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea7.setEditable(false);
        jTextArea7.setColumns(20);
        jTextArea7.setLineWrap(true);
        jTextArea7.setRows(5);
        jTextArea7.setText("The bubble point pressure, also known as the saturation pressure, is the pressure, at some reference temperature, that the first bubble of gas is liberated from the liquid phase. The reference temperature is usually the reservoir temperature, but any temperature can be used. Note that the bubble point pressure is a function of temperature and changing the reference temperature will change the bubble point pressure.");
        jTextArea7.setWrapStyleWord(true);
        jScrollPane17.setViewportView(jTextArea7);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Statistical analysis of correlations:  ");

        jScrollPane18.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea8.setEditable(false);
        jTextArea8.setColumns(20);
        jTextArea8.setLineWrap(true);
        jTextArea8.setRows(5);
        jTextArea8.setText("Al-Shammasi, in his SPE paper “A Review of Bubble point Pressure and Oil Formation Volume Factor Correlations” (SPE-71302-PA, April 2001), compiled a databank of 1,243 data points from the literature. This was supplemented by 133 samples available from a GeoMark Research database (GeoMark Research. 2003. RFD base (Reservoir Fluid Database)), bringing the total number of data points to 1,376. These data were then used to rank the bubble point pressure correlations. The following Table summarizes the ranges of data used for bubble point pressure, temperature, oil FVF, Solution GOR, oil gravity, and gas specific gravity.");
        jTextArea8.setWrapStyleWord(true);
        jScrollPane18.setViewportView(jTextArea8);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Ranges");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Distribution");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane18))
                .addContainerGap())
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(39, 39, 39))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Types of Permeabilities"));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Absolute Permeability"));

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));

        textAbsolute.setEditable(false);
        textAbsolute.setColumns(20);
        textAbsolute.setLineWrap(true);
        textAbsolute.setRows(5);
        textAbsolute.setWrapStyleWord(true);
        jScrollPane10.setViewportView(textAbsolute);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Permeabilidad/absolutePermeability.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Relative Permeability"));

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));

        textRelative.setEditable(false);
        textRelative.setColumns(20);
        textRelative.setLineWrap(true);
        textRelative.setRows(5);
        textRelative.setWrapStyleWord(true);
        jScrollPane9.setViewportView(textRelative);

        relativePermeabilityCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relativePermeabilityCBActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Permeabilidad/relativePermeability.jpg"))); // NOI18N

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addComponent(relativePermeabilityCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(relativePermeabilityCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reservoir Mechanics", jPanel2);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jPanel19.setBackground(java.awt.Color.white);
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Volumetric Factors"));

        jPanel25.setBackground(java.awt.Color.white);
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Gas Formation Volume Factor"));

        jScrollPane12.setBackground(java.awt.Color.white);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("The gas formation volume factor is used to relate the volume of gas, as measured at reservoir conditions, to the volume of the gas as measured at standard conditions, i.e., 60°F and 14.7 psia. This gas property is then defined as the actual volume occupied by a certain amount of gas at a specified pressure and temperature, divided by the volume occupied by the same amount of gas at standard conditions.");
        jTextArea2.setWrapStyleWord(true);
        jScrollPane12.setViewportView(jTextArea2);

        jButton13.setBackground(java.awt.Color.white);
        jButton13.setText("Formula");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(java.awt.Color.white);
        jButton14.setText("Example");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12)
                .addContainerGap())
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton13)
                .addGap(49, 49, 49)
                .addComponent(jButton14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jButton13))
                .addContainerGap())
        );

        jPanel27.setBackground(java.awt.Color.white);
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Formation Volume Factor"));

        jScrollPane13.setBackground(java.awt.Color.white);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("So far we have considered reservoir pressures maintained above the bubble point. At reservoir pressures above the bubble point, only single phase oil exists. Below the bubble point, solution gas evolves out of the oil becoming free gas in the reservoir.");
        jTextArea3.setWrapStyleWord(true);
        jScrollPane13.setViewportView(jTextArea3);

        jButton15.setBackground(java.awt.Color.white);
        jButton15.setText("Formula");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(java.awt.Color.white);
        jButton16.setText("Example");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13)
                .addContainerGap())
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton15)
                .addGap(47, 47, 47)
                .addComponent(jButton16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton16))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel31.setBackground(java.awt.Color.white);
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder("Compressibility Factor"));

        RBEquationState.setBackground(java.awt.Color.white);
        RBEquationState.setText("EquationState");

        RBPseudo.setBackground(java.awt.Color.white);
        RBPseudo.setText("Pseudo-properties");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CompresibilityFactor/relleno.png"))); // NOI18N

        RBFactorZ.setBackground(java.awt.Color.white);
        RBFactorZ.setText("Z Factor");

        jButton10.setBackground(java.awt.Color.white);
        jButton10.setText("Show");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(RBEquationState)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(RBPseudo)
                        .addGap(25, 25, 25)
                        .addComponent(RBFactorZ)))
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBPseudo)
                    .addComponent(RBFactorZ))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBEquationState)
                    .addComponent(jButton10))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel24.setBackground(java.awt.Color.white);
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Oil Formation Volume Factor"));

        jScrollPane11.setBackground(java.awt.Color.white);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("The oil formation volume factor is a measure of the degree of change in oil volume as it is produced from the reservoir and brought to surface conditions. In the subsurface formation, pressure as well as temperature is significantly higher than stock-tank conditions. As oil is produced, it undergoes shrinkage or reduction in volume due to the liberation of dissolved gas. The effect is greater in the case of highly volatile oil due to the abundance of light hydrocarbons.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane11.setViewportView(jTextArea1);

        jButton11.setBackground(java.awt.Color.white);
        jButton11.setText("Formula");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(java.awt.Color.white);
        jButton12.setText("Example");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11)
                .addContainerGap())
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jButton11)
                .addGap(47, 47, 47)
                .addComponent(jButton12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton11))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Materials Balance Sheet"));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Gas Production = Expansion of Free Gas In Reservoir"));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BalanceMateriales/Balance3.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane14.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setText("The material-balance equation is the simplest expression of the conservation of mass in a reservoir. The equation mathematically defines the different producing mechanisms and effectively relates the reservoir fluid and rock expansion to the subsequent fluid withdrawal.\n\nthe applicable equation for initially saturated volatile- and black-oil reservoirs is:");
        jTextArea4.setWrapStyleWord(true);
        jScrollPane14.setViewportView(jTextArea4);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BalanceMateriales/Balance1.jpg"))); // NOI18N

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BalanceMateriales/Balance2.jpg"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel18.setText("For gas reservoirs, the material balance concept can be applied to determine");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel19.setText("gas in place and expected gas reservoir reserve.");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane14)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel19)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PVT"));

        jLabel24.setText("Example:");

        jScrollPane20.setBackground(java.awt.Color.white);

        jTextArea10.setEditable(false);
        jTextArea10.setColumns(20);
        jTextArea10.setLineWrap(true);
        jTextArea10.setRows(5);
        jTextArea10.setText("A gas well is producing at a rate of 15,000 ft3/day from a gas reservoir at an average pressure of 2,000 psia and a temperature of 140°F. The specific gravity is 0.72. Calculate the gas flow rate in scf/day.");
        jTextArea10.setWrapStyleWord(true);
        jTextArea10.setBorder(null);
        jScrollPane20.setViewportView(jTextArea10);

        jLabel25.setBackground(java.awt.Color.white);
        jLabel25.setText("Solution:");

        jLabel26.setBackground(java.awt.Color.white);
        jLabel26.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel26.setText("Step 1:");

        jLabel27.setBackground(java.awt.Color.white);
        jLabel27.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel27.setText("Calculate the pseudo-critical properties from equations:");

        jLabel28.setBackground(java.awt.Color.white);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PVT/PVT1.png"))); // NOI18N

        jLabel29.setBackground(java.awt.Color.white);
        jLabel29.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel29.setText("Step 2: Calculate pseudo-reduced properties from equations:");

        jLabel31.setBackground(java.awt.Color.white);
        jLabel31.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel31.setText("140°F = 600°R");

        jLabel32.setBackground(java.awt.Color.white);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PVT/PVT2.png"))); // NOI18N

        jLabel33.setBackground(java.awt.Color.white);
        jLabel33.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel33.setText("Step 3: Determine the z-factor from Sanding and Katz compressibility factor chart.  = 0.78");

        jButton17.setBackground(java.awt.Color.white);
        jButton17.setText("Show Graphic");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel30.setBackground(java.awt.Color.white);
        jLabel30.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel30.setText("Step 4: Calculate the gas expansion factor from Equation of expansion factor");

        jLabel34.setBackground(java.awt.Color.white);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PVT/PVT5.jpg"))); // NOI18N

        jLabel36.setBackground(java.awt.Color.white);
        jLabel36.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel36.setText("Step 5. Calculate the gas flow rate in scf/day by multiplying the gas flow rate (in ft3/day)");

        jLabel35.setBackground(java.awt.Color.white);
        jLabel35.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel35.setText("by the gas expansion factor Eg as expressed in scf/ft3:");

        jLabel37.setBackground(java.awt.Color.white);
        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 102, 102));
        jLabel37.setText("Gas flow rate = (151.15) (15,000) = 2.267 MMscf/day");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane20)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel32))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jButton17))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel30)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(39, 39, 39))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Volumetric Calculations", jPanel18);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jPanel32.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        tblGases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblGases.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane24.setViewportView(tblGases);

        tblDensityValue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane19.setViewportView(tblDensityValue);

        jLabel40.setBackground(new java.awt.Color(255, 102, 102));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Calculations with defined pressure (psi) and temperature (°R)");

        jButton18.setText("jButton18");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel23.setText("Pressure (psi)");

        jLabel38.setText("Temperature °F");

        jLabel39.setText("Temperature °R");

        rankTemperature.setEditable(false);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel23)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(farenTemperature, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(pressure, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rankTemperature))
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(pressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(farenTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(rankTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel46.setText("Grafic Z");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(18, 18, 18)
                        .addComponent(graficZ)
                        .addGap(100, 100, 100)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jLabel46)
                    .addComponent(graficZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblCorrections.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane22.setViewportView(tblCorrections);

        jLabel42.setBackground(new java.awt.Color(255, 102, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Correction of pseudocritical properties due to the presence of CO2 and H2S");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane22))
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout plnVolmetricFactorLayout = new javax.swing.GroupLayout(plnVolmetricFactor);
        plnVolmetricFactor.setLayout(plnVolmetricFactorLayout);
        plnVolmetricFactorLayout.setHorizontalGroup(
            plnVolmetricFactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        plnVolmetricFactorLayout.setVerticalGroup(
            plnVolmetricFactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jPanel36.setBackground(new java.awt.Color(102, 255, 102));

        javax.swing.GroupLayout plnFactorZLayout = new javax.swing.GroupLayout(plnFactorZ);
        plnFactorZ.setLayout(plnFactorZLayout);
        plnFactorZLayout.setHorizontalGroup(
            plnFactorZLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        plnFactorZLayout.setVerticalGroup(
            plnFactorZLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout plnDensityLayout = new javax.swing.GroupLayout(plnDensity);
        plnDensity.setLayout(plnDensityLayout);
        plnDensityLayout.setHorizontalGroup(
            plnDensityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        plnDensityLayout.setVerticalGroup(
            plnDensityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(plnFactorZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(plnDensity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(plnFactorZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(plnDensity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0", null},
                {"0", null},
                {"637.1", null},
                {"1010", null},
                {"1769.6", null},
                {"2516.1", null},
                {"3251.9", null},
                {"3262.3", null},
                {"4000.9", null},
                {"4008.9", null},
                {"4755.9", null}
            },
            new String [] {
                "CV", "CV (Mix)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane23.setViewportView(jTable5);

        jLabel43.setText("CO2");

        jLabel52.setText("H2S");

        jLabel53.setText("CH4");

        jLabel54.setText("C2H6");

        jLabel55.setText("C3H8");

        jLabel56.setText("i-C4H10");

        jLabel57.setText("n-C4H10");

        jLabel58.setText("i-C5H12");

        jLabel59.setText("n-C5H12");

        jLabel60.setText("C6H14");

        jLabel44.setText("Fill In The Fields To Calculate");

        jLabel45.setText("N2");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58)
                            .addComponent(jLabel59)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nc5h12, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(ic5h12)
                            .addComponent(nc4h10)
                            .addComponent(ic4h10)
                            .addComponent(c3h8)
                            .addComponent(c2h6)
                            .addComponent(ch4)
                            .addComponent(h2s)
                            .addComponent(co2)
                            .addComponent(n2)
                            .addComponent(c6h14))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(co2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(h2s, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ch4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c2h6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c3h8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ic4h10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nc4h10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ic5h12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nc5h12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c6h14, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addContainerGap())
        );

        jLabel41.setBackground(new java.awt.Color(255, 102, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Calorific Value");

        jButton20.setText("jButton20");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton20)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plnVolmetricFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plnVolmetricFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Pressure");

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Vol. Factor");

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Grafic Z");

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Density");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pres4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(pres3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pres2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pres1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(z4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(z3)
                                    .addComponent(z2)))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(z1))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(den3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(den2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(den1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(den4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vol1)
                    .addComponent(vol2)
                    .addComponent(vol3)
                    .addComponent(vol4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel49)
                    .addComponent(jLabel61)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pres1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(z1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vol1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(den1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pres2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(z2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(den2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vol2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pres3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(z3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(den3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vol3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pres4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(z4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(den4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vol4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Pressure");

        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Grafic Z");

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Density");

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Vol. Factor");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pres5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(pres6))
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(z5)
                    .addComponent(z6)
                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(den6)
                    .addComponent(den5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(vol5)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vol6))
                .addGap(17, 17, 17))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pres5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(z5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vol5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(den5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pres6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(z6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(den6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(vol6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jButton19.setText("jButton19");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton21.setText("jButton21");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane24)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton19)
                            .addComponent(jButton21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Density - Heating power(Gas)", jPanel22);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        jPanel38.setBackground(java.awt.Color.white);
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Gas in Place"));
        jPanel38.setAutoscrolls(true);
        jPanel38.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        label1.setText("Gas in Place");

        jTextArea9.setEditable(false);
        jTextArea9.setColumns(20);
        jTextArea9.setLineWrap(true);
        jTextArea9.setRows(6);
        jTextArea9.setText("The volumetric equation is useful in reserve work for estimating gas in place at any stage of depletion. Multiplication of this unit figure by the best available estimate of bulk reservoir volume then gives gas in place for the lease, tract, or reservoir under consideration. Later in the life of the reservoir, when the reservoir volume is defined and performance data are available, volumetric calculations provide valuable checks on gas in place estimates obtained from material balance methods.");
        jTextArea9.setWrapStyleWord(true);
        jTextArea9.setAutoscrolls(false);
        jTextArea9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane21.setViewportView(jTextArea9);

        jTextArea11.setEditable(false);
        jTextArea11.setColumns(20);
        jTextArea11.setLineWrap(true);
        jTextArea11.setRows(6);
        jTextArea11.setText("Reservoirs containing only free gas are termed gas reservoirs.  During the development period before reservoir limits have been accurately defined, it is convenient to calculate gas in place per acre-foot of bulk reservoir rock.\nGas reservoirs may have water influx from a contiguous water-bearing portion of the formation or may be volumetric (i.e., have no water influx).\n");
        jTextArea11.setWrapStyleWord(true);
        jTextArea11.setAutoscrolls(false);
        jTextArea11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane25.setViewportView(jTextArea11);

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PVT/GOES/Formula 1.jpg"))); // NOI18N

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PVT/GOES/Formula 2.png"))); // NOI18N
        jLabel51.setToolTipText("");

        jButton22.setText("Gas reservoir");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label3.setText("The Volumetric Method");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane21)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addGap(0, 197, Short.MAX_VALUE)
                .addComponent(jButton22)
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jButton22)
                .addGap(35, 35, 35)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel51)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(513, Short.MAX_VALUE)))
        );

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Calculator and step-by-step example"));

        label4.setAlignment(java.awt.Label.CENTER);
        label4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label4.setText("GIP Calculator");

        jLabel66.setText("A gas reservoir has the following characteristics:");

        jLabel67.setText("(this information must be entered in orderto perform the calculation)");

        jPanel39.setBackground(new java.awt.Color(204, 204, 204));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Information required", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel39.setForeground(new java.awt.Color(255, 255, 255));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel68.setText("A (acres) =");

        jTextField2.setToolTipText("");

        jTextField6.setToolTipText("");

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel71.setText("h (ft.) =");

        jTextField7.setToolTipText("");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel69.setText("ϕ =");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel70.setText("Swi (%) =");

        jTextField3.setToolTipText("");

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel72.setText("T (°F) =");

        jTextField8.setToolTipText("");

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel73.setText("p (psi.) =");

        jTextField9.setToolTipText("");

        jTextField5.setToolTipText("");

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel74.setText("z =");

        jLabel75.setText("taken from the Standing and Katz compressibility factor chart");
        jLabel75.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel76.setForeground(new java.awt.Color(0, 0, 204));
        jLabel76.setText("Cllic here to view the compressibility factor chart");
        jLabel76.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel76MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel71))
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel72)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel75))
                            .addComponent(jLabel76))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73))
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel76)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel77.setText("Calculate the Gas in Place using the volumetric method");

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel78.setText("Equation:");

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PVT/GOES/Formula 3.png"))); // NOI18N

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("P.V =");

        jTextField10.setToolTipText("");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("MMft3");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel78)
                    .addComponent(jLabel79)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel81)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78)
                .addGap(18, 18, 18)
                .addComponent(jLabel79)
                .addGap(27, 27, 27)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("1. Pore Volume", jPanel43);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("2. Gas formation volume factor", jPanel44);

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel67)
                .addGap(27, 27, 27)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel77)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Recovery Factor"));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel51.getAccessibleContext().setAccessibleName("Calculator and step-by-step example");
        jPanel51.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane1.addTab("GIP", jPanel34);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabelLogo.setText("jLabel3");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1174, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        graphValues();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        getValuesTableCorrections();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        getValuesTableProperties();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        getValuesTableDensity();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        Standing st = new Standing(this, false);
        st.setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Bo bo = new Bo();
        bo.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        BoFormula boF = new BoFormula(this, false);
        boF.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (RBPseudo.isSelected()) {
            Pseudo ps = new Pseudo(this, false);
            ps.setVisible(true);

        } else if (RBFactorZ.isSelected()) {

            /**
            * AQUI INCLUIR FACTOR Z
            */
        } else if (RBEquationState.isSelected()) {
            Equation eq = new Equation(this, false);
            eq.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "You must check at least one option.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        Bt bt = new Bt();
        bt.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        BtFormula bt = new BtFormula(this, false);
        bt.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        Bg bg = new Bg();
        bg.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        BgFormula bg = new BgFormula(this, false);
        bg.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void relativePermeabilityCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relativePermeabilityCBActionPerformed
        String clasificacion = (String) relativePermeabilityCB.getSelectedItem();

        switch (clasificacion) {
            case "Select":
            this.pintarImagen(this.jLabel12, "/Images/formulas/Capillarity/empty.jpg");
            break;
            case "Relative Permeability to Oil":
            this.pintarImagen(this.jLabel12, "/Images/Permeabilidad/relativePermeabilityOil.jpg");
            break;
            case "Relative Permeability to Gas":
            this.pintarImagen(this.jLabel12, "/Images/Permeabilidad/relativePermeabilityGas.jpg");
            break;
            case "Relative Permeability to Water":
            this.pintarImagen(this.jLabel12, "/Images/Permeabilidad/relativePermeabilityWater.jpg");
            break;
            case "Formula Explication":
            this.pintarImagen(this.jLabel12, "/Images/Permeabilidad/ExpliPermeRela.jpg");
            break;
            default:
            break;
        }
    }//GEN-LAST:event_relativePermeabilityCBActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DistributionPb dPb = new DistributionPb(this, false);
        dPb.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        RangesPb rPb = new RangesPb(this, false);
        rPb.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        RsStanding rS = new RsStanding(this, false);
        rS.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        SolutionOilGas1 s1 = new SolutionOilGas1(this, false);
        s1.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        SolutionOilGas2 s2 = new SolutionOilGas2(this, false);
        s2.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void fluidSaturationCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fluidSaturationCBActionPerformed
        String clasificacion = (String) fluidSaturationCB.getSelectedItem();

        switch (clasificacion) {
            case "Select":
            this.pintarImagen(this.jLabel9, "/Images/formulas/Capillarity/empty.jpg");
            break;
            case "Oil Saturation":
            this.pintarImagen(this.jLabel9, "/Images/FluidSaturation_DarcyLaw/fluidSaturationOil.jpg");
            break;
            case "Gas Saturation":
            this.pintarImagen(this.jLabel9, "/Images/FluidSaturation_DarcyLaw/fluidSaturationGas.jpg");
            break;
            case "Water Saturation":
            this.pintarImagen(this.jLabel9, "/Images/FluidSaturation_DarcyLaw/fluidSaturationWater.jpg");
            break;
            default:
            break;
        }
    }//GEN-LAST:event_fluidSaturationCBActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        GOR gor = new GOR(this, true);
        gor.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Capillary cp = new Capillary(this, true);
        cp.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Viscosity vs = new Viscosity(this, true);
        vs.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Porosity ps = new Porosity(this, true);
        ps.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void selectPorVisCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPorVisCapActionPerformed
        String clasificacion = (String) selectPorVisCap.getSelectedItem();

        switch (clasificacion) {
            case "Select": {
                this.pintarImagen(this.fotoPoroVisCapiGOR, "/Images/formulas/Capillarity/empty.jpg");
                InputStream is = getClass().getResourceAsStream("/Textos/PorVisCapiGOR/GOR/Empty.txt");
                textoPorVisCapGOR(is);
                break;
            }
            case "Porosity": {
                this.pintarImagen(this.fotoPoroVisCapiGOR, "/Images/Porosity1.jpeg");
                InputStream is = getClass().getResourceAsStream("/Textos/PorVisCapiGOR/Porosity.txt");
                textoPorVisCapGOR(is);
                break;
            }
            case "Viscosity": {
                this.pintarImagen(this.fotoPoroVisCapiGOR, "/Images/Viscosity.png");
                InputStream is = getClass().getResourceAsStream("/Textos/PorVisCapiGOR/Viscosity/Viscosity.txt");
                textoPorVisCapGOR(is);
                break;
            }
            case "Capillarity": {
                this.pintarImagen(this.fotoPoroVisCapiGOR, "/Images/formulas/Capillarity/CapillaryPressureContactAngle.png");
                InputStream is = getClass().getResourceAsStream("/Textos/PorVisCapiGOR/Capillary/Capillary1.txt");
                textoPorVisCapGOR(is);
                break;
            }
            case "Gas and Oil Ratio": {
                this.pintarImagen(this.fotoPoroVisCapiGOR, "/Images/formulas/GOR/solutiongasdrive.jpg");
                InputStream is = getClass().getResourceAsStream("/Textos/PorVisCapiGOR/GOR/GOR01.txt");
                textoPorVisCapGOR(is);
                break;
            }
            default:
            break;
        }
    }//GEN-LAST:event_selectPorVisCapActionPerformed

    private void selectRecoveryMechanismActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRecoveryMechanismActionPerformed
        String clasificacion = (String) selectRecoveryMechanism.getSelectedItem();

        switch (clasificacion) {
            case "Select": {
                InputStream is = getClass().getResourceAsStream("/Textos/RecoveryMechanism/Primary_Recovery.txt");
                textoRecoveryMechanisms(is);
                break;
            }
            case "Rock and Fluid Expansion": {
                InputStream is = getClass().getResourceAsStream("/Textos/RecoveryMechanism/Rock_And_Liquid_Expansion_Drive.txt");
                textoRecoveryMechanisms(is);
                break;
            }
            case "Solution Gas Drive": {
                InputStream is = getClass().getResourceAsStream("/Textos/RecoveryMechanism/Depletion_Drive.txt");
                textoRecoveryMechanisms(is);
                break;
            }
            case "Gas Cap Drive": {
                InputStream is = getClass().getResourceAsStream("/Textos/RecoveryMechanism/Gas_Cap_Drive.txt");
                textoRecoveryMechanisms(is);
                break;
            }
            case "Gravity Drainage": {
                InputStream is = getClass().getResourceAsStream("/Textos/RecoveryMechanism/Gravity_Drainage_Drive.txt");
                textoRecoveryMechanisms(is);
                break;
            }
            case "Aquifer Drive (Weak Aquifer)": {
                InputStream is = getClass().getResourceAsStream("/Textos/RecoveryMechanism/Water_Drive.txt");
                textoRecoveryMechanisms(is);
                break;
            }
            case "Aquifer Drive (Strong Aquifer)": {
                InputStream is = getClass().getResourceAsStream("/Textos/RecoveryMechanism/Water_Drive.txt");
                textoRecoveryMechanisms(is);
                break;
            }
            case "Combined Drive Mechanisms": {
                InputStream is = getClass().getResourceAsStream("/Textos/RecoveryMechanism/Combination_Drive_Mechanism.txt");
                textoRecoveryMechanisms(is);
                break;
            }
            default:
            break;
        }
    }//GEN-LAST:event_selectRecoveryMechanismActionPerformed

    private void jButtomFluidTypeEvaluateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtomFluidTypeEvaluateActionPerformed
        String clasificacion = (String) selectColorTipo.getSelectedItem();
        double api = Double.parseDouble(APIGravity.getText());
        double rgp = Double.parseDouble(RGP.getText());
        double molar = Double.parseDouble(Molar.getText());

        if (clasificacion.equals("Dark") && (api < 45) && (rgp < 1750) && (molar > 20)) {
            jTextAreaTypeFluid.setText("The fluid evaluated is:" + "\n" + "Black Oil");
        } else if (clasificacion.equals("Colored") && (api > 40) && (rgp >= 1750 && rgp <= 3200) && (molar > 12 && molar < 20)) {
            jTextAreaTypeFluid.setText("The fluid evaluated is:" + "\n" + "Volatile Oil");
        } else if (clasificacion.equals("Ligthly Colored") && (api > 40) && (rgp > 3200) && (molar > 12.5)) {
            jTextAreaTypeFluid.setText("The fluid evaluated is:" + "\n" + "Retrogade Gas");
        } else if (clasificacion.equals("Water White") && (api > 70) && (rgp > 15000) && (molar > 4)) {
            jTextAreaTypeFluid.setText("The fluid evaluated is:" + "\n" + "Wet Gas");
        } else if (clasificacion.equals("No Liquid") && (rgp > 100000) && (molar > 0.8)) {
            jTextAreaTypeFluid.setText("The fluid evaluated is:" + "\n" + "Wet Gas");
        } else {
            JOptionPane.showMessageDialog(this, "Try Again", "ERROR", 1);
        }
    }//GEN-LAST:event_jButtomFluidTypeEvaluateActionPerformed

    private void selectCurvaFasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCurvaFasesActionPerformed
        String clasificacion = (String) selectCurvaFases.getSelectedItem();

        switch (clasificacion) {
            case "Select": {
                this.pintarImagen(this.curvaFases, "/Images/ClasificationFluids.jpeg");
                InputStream is = getClass().getResourceAsStream("/Textos/FluidClassification/TypeClassification.txt");
                textoClasificacion(is);
                break;
            }
            case "Black Oil": {
                this.pintarImagen(this.curvaFases, "/Images/BlackOil.jpeg");
                InputStream is = getClass().getResourceAsStream("/Textos/FluidClassification/BlackOil.txt");
                textoClasificacion(is);
                break;
            }
            case "Volatile Oil": {
                this.pintarImagen(this.curvaFases, "/Images/VolatileOil.jpeg");
                InputStream is = getClass().getResourceAsStream("/Textos/FluidClassification/VolatileOil.txt");
                textoClasificacion(is);
                break;
            }
            case "Condensade Gas": {
                this.pintarImagen(this.curvaFases, "/Images/CondensadeGas.jpeg");
                InputStream is = getClass().getResourceAsStream("/Textos/FluidClassification/RetrogradeGas.txt");
                textoClasificacion(is);
                break;
            }
            case "Wet Gas": {
                this.pintarImagen(this.curvaFases, "/Images/WetGas.jpeg");
                InputStream is = getClass().getResourceAsStream("/Textos/FluidClassification/WetGas.txt");
                textoClasificacion(is);
                break;
            }
            case "Dry Gas": {
                this.pintarImagen(this.curvaFases, "/Images/DryGas.jpeg");
                InputStream is = getClass().getResourceAsStream("/Textos/FluidClassification/DryGas.txt");
                textoClasificacion(is);
                break;
            }
            case "Alfastenic": {
                this.pintarImagen(this.curvaFases, "/Images/Asfaltenic.jpeg");
                InputStream is = getClass().getResourceAsStream("/Textos/FluidClassification/Asfaltenic.txt");
                textoClasificacion(is);
                break;
            }
            default:
            break;
        }
    }//GEN-LAST:event_selectCurvaFasesActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        Standing st = new Standing(this, false);
        st.setVisible(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jLabel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel76MouseClicked
        Standing st = new Standing(this, false);
        st.setVisible(true);
    }//GEN-LAST:event_jLabel76MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField APIGravity;
    private javax.swing.JLabel DarcyImage;
    private javax.swing.JTextArea JTextPorVisCapiGOR;
    private javax.swing.JTextField Molar;
    private javax.swing.JRadioButton RBEquationState;
    private javax.swing.JRadioButton RBFactorZ;
    private javax.swing.JRadioButton RBPseudo;
    private javax.swing.JTextField RGP;
    private javax.swing.ButtonGroup buttonGroupFactor;
    private javax.swing.JTextField c2h6;
    private javax.swing.JTextField c3h8;
    private javax.swing.JTextField c6h14;
    private javax.swing.JTextField ch4;
    private javax.swing.JTextField co2;
    private javax.swing.JLabel curvaFases;
    private javax.swing.JTextField den1;
    private javax.swing.JTextField den2;
    private javax.swing.JTextField den3;
    private javax.swing.JTextField den4;
    private javax.swing.JTextField den5;
    private javax.swing.JTextField den6;
    private javax.swing.JTextField farenTemperature;
    private javax.swing.JComboBox<String> fluidSaturationCB;
    private javax.swing.JTable fluidTypeTable;
    private javax.swing.JLabel fotoPoroVisCapiGOR;
    private javax.swing.JTextField graficZ;
    private javax.swing.JTextField h2s;
    private javax.swing.JTextField ic4h10;
    private javax.swing.JTextField ic5h12;
    private javax.swing.JButton jButtomFluidTypeEvaluate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextArea jTextAreaClasificacion;
    private javax.swing.JTextArea jTextAreaRecovey;
    private javax.swing.JTextArea jTextAreaTypeFluid;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JTable mechanismRecoveryTable;
    private javax.swing.JTextField n2;
    private javax.swing.JTextField nc4h10;
    private javax.swing.JTextField nc5h12;
    private javax.swing.JPanel plnDensity;
    private javax.swing.JPanel plnFactorZ;
    private javax.swing.JPanel plnVolmetricFactor;
    private javax.swing.JTextField pres1;
    private javax.swing.JTextField pres2;
    private javax.swing.JTextField pres3;
    private javax.swing.JTextField pres4;
    private javax.swing.JTextField pres5;
    private javax.swing.JTextField pres6;
    private javax.swing.JTextField pressure;
    private javax.swing.JTextField rankTemperature;
    private javax.swing.JComboBox<String> relativePermeabilityCB;
    private javax.swing.JComboBox<String> selectColorTipo;
    private javax.swing.JComboBox<String> selectCurvaFases;
    private javax.swing.JComboBox<String> selectPorVisCap;
    private javax.swing.JComboBox<String> selectRecoveryMechanism;
    private javax.swing.JTable tblCorrections;
    private javax.swing.JTable tblDensityValue;
    private javax.swing.JTable tblGases;
    private javax.swing.JTextArea textAbsolute;
    private javax.swing.JTextArea textDarcy;
    private javax.swing.JTextArea textRelative;
    private javax.swing.JTextArea textSaturation;
    private javax.swing.JTextField vol1;
    private javax.swing.JTextField vol2;
    private javax.swing.JTextField vol3;
    private javax.swing.JTextField vol4;
    private javax.swing.JTextField vol5;
    private javax.swing.JTextField vol6;
    private javax.swing.JTextField z1;
    private javax.swing.JTextField z2;
    private javax.swing.JTextField z3;
    private javax.swing.JTextField z4;
    private javax.swing.JTextField z5;
    private javax.swing.JTextField z6;
    // End of variables declaration//GEN-END:variables
}
