/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaproject1;

import javax.swing.SwingUtilities;

/**
 *
 * @author LURA
 */
public class Javaproject1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EnrollmentGUI();
            }
        });     
    }
}
