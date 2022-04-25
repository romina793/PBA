/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pav.tp1;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Franco
 */
public class Util {
     public static String abrirPanel(Component parent) {
        String archivoElegido = "";
        
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "txt");
        jFileChooser.setFileFilter(filter);

        int result = jFileChooser.showOpenDialog(parent);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = jFileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                archivoElegido = "...";
            } else {
                archivoElegido = fileName.getAbsolutePath();;
            }
        }
        return archivoElegido;
    }
}
