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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ufjf.dcc025.usuario.LoginSenha;

/**
 *
 * @author guilherme
 */
public class MenuPrincipal implements ActionListener, MouseListener {

    private ImageIcon logo = new ImageIcon("src/main/java/imagens/logo.png");
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JButton botaoPrecisoAssistir = new JButton("Preciso Assistir");
    private JButton botaoAssistindo = new JButton("Assistindo");
    private JLabel logoToOn = new JLabel();
    private FrameToOn frame = new FrameToOn();

    public MenuPrincipal() {

        // a logo
        logoToOn.setIcon(logo);
        logoToOn.setHorizontalTextPosition((JLabel.CENTER));
        logoToOn.setVerticalTextPosition(JLabel.CENTER);
        logoToOn.setVerticalAlignment(JLabel.CENTER); // posiciona verticalmente icone+texto dentro da label
        logoToOn.setHorizontalAlignment(JLabel.CENTER);

        // botao Preciso Assistir
        botaoPrecisoAssistir.addActionListener(this);
        botaoPrecisoAssistir.setBackground(new Color(248, 161, 31));
        botaoPrecisoAssistir.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoPrecisoAssistir.setPreferredSize(new Dimension(200, 50));
        botaoPrecisoAssistir.setHorizontalTextPosition((JButton.CENTER)); // alinhamento horizontal do texto
        botaoPrecisoAssistir.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoPrecisoAssistir.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoPrecisoAssistir.setForeground(Color.WHITE); // cor da fonte 
        botaoPrecisoAssistir.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoPrecisoAssistir.setSize(60, 20);
        botaoPrecisoAssistir.setToolTipText("Clique para abrir o Menu Preciso Assistir");
        botaoPrecisoAssistir.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoPrecisoAssistir.addMouseListener(this);

        // botao Assistindo
        botaoAssistindo.addActionListener(this);
        botaoAssistindo.setBackground(new Color(248, 161, 31));
        botaoAssistindo.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoAssistindo.setPreferredSize(new Dimension(200, 50));
        botaoAssistindo.setHorizontalTextPosition((JButton.CENTER)); // alinhamento horizontal do texto
        botaoAssistindo.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoAssistindo.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoAssistindo.setForeground(Color.WHITE); // cor da fonte 
        botaoAssistindo.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoAssistindo.setSize(60, 20);
        botaoAssistindo.setToolTipText("Clique para abrir o Menu Assistindo");
        botaoAssistindo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botaoAssistindo.addMouseListener(this);

        // paineis
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        panel2.setBackground(new Color(30, 29, 29)); // muda a cor de fundo
        panel2.add(botaoPrecisoAssistir);
        panel2.add(botaoAssistindo);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1)); // GridLaytou(lunhas, colunas, margem vertical, margem horizontal)
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo
        panel.add(logoToOn);
        panel.add(panel2);

        // frame set up
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Tô On - Menu Principal");

        /*
        // variáveis para label
        label.setHorizontalTextPosition((JLabel.CENTER)); // alinhamento horizontal do texto
        label.setVerticalTextPosition(JLabel.CENTER); // alinhamento vertical do texto
        label.setFont(new Font("Sans Serif", Font.PLAIN, 20)); // fonte do texto
        label.setForeground(Color.WHITE); // cor da fonte 
        label.setBackground(new Color(34,34,34)); // cor de fundo
        label.setIconTextGap(10); // distância entre icone e imagem
        label.setOpaque(true); // mostra o background
        label.setVerticalAlignment(JLabel.CENTER); // posiciona verticalmente icone+texto dentro da label
        label.setHorizontalAlignment(JLabel.CENTER); // posiciona horizontalmente icone+texto dentro da label
        //label.setBounds(100, 100, 250, 250); // x, y + dimensoes dentro da frame
         */
 /*
        // variaveis button
        button.addActionListener(this);
        button.setBackground(new Color(248,161,31));
        //button.setText("sou um botão");
        //button.setIcon();
        //button.setIconTextGap(10); // distância entre icone e imagem
        button.setFocusable(false); // tira a marquinha que fica no texto do botão
        button.setBounds(500, 250, 20, 5);
        //button.setPreferredSize(new Dimension(60,20));
        button.setHorizontalTextPosition((JButton.CENTER)); // alinhamento horizontal do texto
        button.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        //button.add(label);
        button.setFont(new Font("Sans Serif", Font.PLAIN, 20)); // fonte do texto
        button.setForeground(Color.WHITE); // cor da fonte 
        button.setBorder(BorderFactory.createEtchedBorder()); // altera a borda do botão
        button.setEnabled(true); // ativo ou nao
         */
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoPrecisoAssistir) {
            frame.dispose(); // fecha a janela anterior (MenuPrincipal) para não ficar com duas abertas
            new MenuPrecisoAssistir();
        }
        if (e.getSource() == botaoAssistindo) {
            frame.dispose();
            new MenuAssistindo();
        }

    }

    // create one Frame
    public static void main(String[] args) {
        LoginSenha usuario = new LoginSenha();
        new PaginaLogin(LoginSenha.getLoginInfo());
        //new MenuPrincipal();
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
        if (me.getSource() == botaoPrecisoAssistir) {
            botaoPrecisoAssistir.setBackground(new Color(255, 183, 76));
        }
        if (me.getSource() == botaoAssistindo) {
            botaoAssistindo.setBackground(new Color(255, 183, 76));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoPrecisoAssistir) {
            botaoPrecisoAssistir.setBackground(new Color(248, 161, 31));
        }
        if (me.getSource() == botaoAssistindo) {
            botaoAssistindo.setBackground(new Color(248, 161, 31));
        }
    }
}
