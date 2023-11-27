/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author ""
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
        }
    }

    public static void limparCampos(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {

            if (componentes[i] instanceof JTextField) {
                JTextField comp = (JTextField) componentes[i];
                comp.setText("");
            }
            if (componentes[i] instanceof JComboBox) {
                JComboBox comp = (JComboBox) componentes[i];
                comp.setSelectedIndex(-1);
            }
            if (componentes[i] instanceof JCheckBox) {
                JCheckBox comp = (JCheckBox) componentes[i];
                comp.setSelected(false);
            }
            if (componentes[i] instanceof JPasswordField) {
                JPasswordField comp = (JPasswordField) componentes[i];
                comp.setText("");
            }
            if (componentes[i] instanceof JTextPane) {
                JTextPane comp = (JTextPane) componentes[i];
                comp.setText("");
            }
        }
    }

    public static void mensagem(String msg) {

        JOptionPane.showMessageDialog(null, msg);

    }

    public static boolean pergunta(String msg) {

        return JOptionPane.showConfirmDialog(null, msg, "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION;

    }

    public static int paraInteiro(String cad) {
        return Integer.valueOf(cad);
    }

    public static String paraString(int num) {
        return String.valueOf(num);
    }
    public static String dbStr(double num) {
        return String.valueOf(num);
    }

    public static double paraDouble(String cad) {
        return Double.valueOf(cad);
    }

  /*  public static Date paraData(String data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Especifique o formato da data aqui
        try {
            return dateFormat.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/

    public static String dataParaString(Date data) {
        return String.valueOf(data);
    }

}
