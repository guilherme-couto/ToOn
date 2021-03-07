/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.usuario;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author mateu
 */
public class PaginaInicial {
    JFrame frame = new JFrame();
    JLabel labelInicial = new JLabel("Teste");
    
    PaginaInicial (){
        
        labelInicial.setBounds(0,0,200,35);
        labelInicial.setFont(new Font(null, Font.PLAIN, 25));
        
        frame.add(labelInicial);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
