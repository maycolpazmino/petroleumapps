/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PVT;

/**
 *
 * @author EQUIPO
 */
public class Operaciones {

    String a, b, c;
    float x, y, z;

    public boolean getCheckempty(String a, String b, String c) {
        if (a.equals("") || b.equals("") || c.equals("") || a.equals("") && b.equals("") && c.equals("")) {
            return true;
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
            return false;
        }
    }

    public boolean getCheckIsNumeric() {
        try {
            Float.parseFloat(a);
            Float.parseFloat(b);
            Float.parseFloat(c);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void Convertir() {
        this.x = Float.parseFloat(a);
        this.y = Float.parseFloat(b);
        this.z = Float.parseFloat(c);
    }
}
