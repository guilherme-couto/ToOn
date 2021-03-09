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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class PaginaCadastro implements ActionListener, MouseListener {

    private JPanel panel = new JPanel();

    private JLabel titulo = new JLabel();
    private JLabel mensagem = new JLabel();
    private JTextField username = new JTextField();
    private JPasswordField senha = new JPasswordField();
    private JPasswordField confirmaSenha = new JPasswordField();
    private JButton botaoCadastrar = new JButton();
    private TitledBorder descricao;

    private FrameToOn frame = new FrameToOn();

    HashMap<String, String> infoLogin = new HashMap<String, String>();

    public PaginaCadastro(HashMap<String, String> infoLoginOriginal) {
        infoLogin = infoLoginOriginal;

        //labels
        titulo.setFont(new Font("Sans Serif", Font.BOLD, 26));
        titulo.setBackground(new Color(30, 29, 29));
        titulo.setForeground(Color.white);
        titulo.setBorder(BorderFactory.createEmptyBorder());
        titulo.setText("Cadastro");
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
        username.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        username.setBackground(new Color(30, 29, 29));
        username.setForeground(Color.white);
        username.setCaretColor(Color.white);
        username.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Username");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        username.setBorder(descricao);
        username.setPreferredSize(new Dimension(200, 50));
        username.setToolTipText("Digite sua name");

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

        confirmaSenha.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        confirmaSenha.setBackground(new Color(30, 29, 29));
        confirmaSenha.setForeground(Color.white);
        confirmaSenha.setCaretColor(Color.white);
        confirmaSenha.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Confirme a senha");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        confirmaSenha.setBorder(descricao);
        confirmaSenha.setPreferredSize(new Dimension(200, 50));
        confirmaSenha.setToolTipText("Digite sua senha novamente");

        //botão
        botaoCadastrar.addActionListener(this);
        botaoCadastrar.setBackground(new Color(248, 161, 31));
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoCadastrar.setPreferredSize(new Dimension(160, 30));
        botaoCadastrar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoCadastrar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoCadastrar.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoCadastrar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoCadastrar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoCadastrar.setForeground(Color.WHITE); // cor da fonte 
        botaoCadastrar.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoCadastrar.setToolTipText("Clique para se cadastrar");
        botaoCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoCadastrar.addMouseListener(this);

        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(15, 35, 35, 35));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo  
        panel.add(titulo);
        panel.add(username);
        panel.add(senha);
        panel.add(confirmaSenha);
        panel.add(mensagem);
        panel.add(botaoCadastrar);

        // frame
        frame.setTitle("Tô On - Página de Cadastro");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setSize(450, 550);
        frame.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botaoCadastrar) {

            String nomeUsuario = username.getText();
            String senhaUsuario = String.valueOf(senha.getPassword());
            String senhaConfirmada = String.valueOf(confirmaSenha.getPassword());
            System.out.println("senha: " + senhaUsuario);
            System.out.println("confirmada: " + senhaConfirmada);
            if (nomeUsuario == null) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Username não pode estar em branco");
            } else if (infoLogin.containsKey(nomeUsuario)) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Username já está sendo utilizado");
            } else if (senhaUsuario == " ") {
                mensagem.setForeground(Color.red);
                mensagem.setText("A senha não pode estar em branco");
            }  else { //caso o username esteja disponível
                try {
                    FileWriter fw = new FileWriter("LoginSenha.txt", true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(nomeUsuario + ";" + senhaUsuario);
                    fw.close();
                    pw.close();
                    System.out.println("Cadastro realizado com sucesso");
                } catch (IOException e) {
                    System.out.println("Erro ocorreu ao tentar cadastrar");
                    e.printStackTrace();
                }
                frame.dispose();
                new MenuPrincipal();
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
        if (me.getSource() == botaoCadastrar) {
            botaoCadastrar.setBackground(new Color(255, 183, 76));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoCadastrar) {
            botaoCadastrar.setBackground(new Color(248, 161, 31));
        }
    }

}
