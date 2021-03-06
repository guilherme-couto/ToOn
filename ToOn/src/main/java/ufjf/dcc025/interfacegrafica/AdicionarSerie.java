/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.interfacegrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author guilherme
 */
public class AdicionarSerie implements ActionListener, MouseListener {

    private JPanel panel = new JPanel();
    
    private JButton botaoAdicionar = new JButton();
    private JTextField titulo = new JTextField();
    private JTextField genero = new JTextField();
    private JTextField subgenero = new JTextField();
    private JTextField plataforma = new JTextField();
    private JTextField numTemporadas = new JTextField();
    private JTextField numEpisodios = new JTextField();
    
    private FrameToOn frame = new FrameToOn();

    public AdicionarSerie() {
        
        // caixas de texto
        titulo.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        titulo.setBackground(new Color(34, 34, 34));
        titulo.setForeground(Color.white);
        titulo.setCaretColor(Color.white);
        titulo.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        
        //botão
        botaoAdicionar.addActionListener(this);
        botaoAdicionar.setBackground(new Color(248, 161, 31));
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoAdicionar.setPreferredSize(new Dimension(150, 30));
        botaoAdicionar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoAdicionar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoAdicionar.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoAdicionar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAdicionar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAdicionar.setForeground(Color.WHITE); // cor da fonte 
        botaoAdicionar.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoAdicionar.setSize(60, 20);
        botaoAdicionar.setToolTipText("Clique para adicionar a Série");
        botaoAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoAdicionar.addMouseListener(this);
        
        //panel
        panel.setBorder(BorderFactory.createEmptyBorder());
        panel.setLayout(new GridLayout(4, 2, 20, 20));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo  
        panel.add(titulo);
        panel.add(botaoAdicionar);
        
        // frame
        frame.setTitle("Tô On - Adicionar Série");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setSize(750, 500);
        frame.add(panel, BorderLayout.CENTER);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == botaoAdicionar) {
            botaoAdicionar.setBackground(new Color(255, 183, 76));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoAdicionar) {
            botaoAdicionar.setBackground(new Color(248, 161, 31));
        }
    }

}
