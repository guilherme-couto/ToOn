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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author guilherme
 */
public class PaginaLogin implements ActionListener, MouseListener{
    
    private JPanel panel = new JPanel();
    
    private JLabel titulo = new JLabel();
    private JLabel mensagem = new JLabel();
    private JTextField userID = new JTextField();
    private JPasswordField senha = new JPasswordField();
    private JButton botaoEntrar = new JButton();
    private TitledBorder descricao;
    
    private FrameToOn frame = new FrameToOn();
    
    HashMap<String, String> infoLogin = new HashMap<String, String>();
    
    public PaginaLogin(HashMap<String, String> infoLoginOriginal) {
        infoLogin = infoLoginOriginal;
        
        //labels
        titulo.setFont(new Font("Sans Serif", Font.BOLD, 26));
        titulo.setBackground(new Color(30, 29, 29));
        titulo.setForeground(Color.white);
        titulo.setBorder(BorderFactory.createEmptyBorder());
        titulo.setText("Login");
        titulo.setPreferredSize(new Dimension(200, 70));
        titulo.setHorizontalAlignment(JTextField.CENTER);
        
        mensagem.setFont(new Font("Sans Serif", Font.ITALIC, 13));
        mensagem.setBackground(new Color(30, 29, 29));
        mensagem.setForeground(Color.white);
        mensagem.setBorder(BorderFactory.createEmptyBorder());
        mensagem.setText("");
        mensagem.setPreferredSize(new Dimension(200, 35));
        mensagem.setHorizontalAlignment(JTextField.CENTER);
       
        // caixas de texto
        userID.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        userID.setBackground(new Color(30, 29, 29));
        userID.setForeground(Color.white);
        userID.setCaretColor(Color.white);
        userID.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("User ID");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        userID.setBorder(descricao);
        userID.setPreferredSize(new Dimension(200, 50));
        userID.setToolTipText("Digite sua ID");
        
        senha.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        senha.setBackground(new Color(30, 29, 29));
        senha.setForeground(Color.white);
        senha.setCaretColor(Color.white);
        senha.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Senha");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        senha.setBorder(descricao);
        senha.setPreferredSize(new Dimension(200, 50));
        senha.setToolTipText("Digite sua senha");
        
        //botão
        botaoEntrar.addActionListener(this);
        botaoEntrar.setBackground(new Color(248, 161, 31));
        botaoEntrar.setText("Entrar");
        botaoEntrar.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoEntrar.setPreferredSize(new Dimension(120, 30));
        botaoEntrar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoEntrar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoEntrar.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoEntrar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoEntrar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoEntrar.setForeground(Color.WHITE); // cor da fonte 
        botaoEntrar.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoEntrar.setToolTipText("Clique para entrar");
        botaoEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoEntrar.addMouseListener(this);
        
        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(15, 35, 35, 35));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo  
        panel.add(titulo);
        panel.add(userID);
        panel.add(senha);
        panel.add(mensagem);
        panel.add(botaoEntrar);
        
        
        // frame
        frame.setTitle("Tô On - Página de Login");
        frame.setSize(400, 450);
        frame.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== botaoEntrar){
            
            String idUsuario = userID.getText();
            String senhaUsuario = String.valueOf(senha.getPassword());
            
            if (infoLogin.containsKey(idUsuario)) {
                if (infoLogin.get(idUsuario).equals(senhaUsuario)){
                    mensagem.setForeground(Color.green);
                    mensagem.setText("Logado com sucesso");
                    frame.dispose();
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                }
                else {
                    mensagem.setForeground(Color.red);
                    mensagem.setText("Senha incorreta");
                }
            }
            else {
                mensagem.setForeground(Color.red);
                mensagem.setText("Usuario não existe");
            }
        }
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
        if (me.getSource() == botaoEntrar) {
            botaoEntrar.setBackground(new Color(255, 183, 76));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoEntrar) {
            botaoEntrar.setBackground(new Color(248, 161, 31));
        }
    }
    
    
}
