package ufjf.dcc025.usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mateus Souza Cruz 201765554AC
 */
public class PaginaLogin implements ActionListener {

    JFrame frame = new JFrame();
    JButton botaoLogin = new JButton("Login");
    JButton botaoReset = new JButton("Limpar");
    JTextField campoIdUsuario = JTextField();
    JPasswordField campoSenhaUsuario = new JPasswordField();
    JLabel labelIdUsuario = new JLabel("Usuario:");
    JLabel labelSenhaUsuario = new JLabel("Senha:");
    JLabel labelMensagem = new JLabel("To On");

    HashMap<String, String> InfoLogin = new HashMap<String, String>();

    PaginaLogin(HashMap<String, String> InfoLoginOriginal) {
        InfoLogin = InfoLoginOriginal;

        labelIdUsuario.setBounds(50, 100, 75, 25);
        labelSenhaUsuario.setBounds(50, 100, 75, 25);

        labelMensagem.setBounds(125, 250, 250, 35);
        labelMensagem.setFont(new Font(null, Font.ITALIC, 25));
        
        botaoLogin.setBounds(125,200,100,25);
        botaoLogin.setFocusable(false);
        botaoLogin.addActionListener(this);
        
        botaoReset.setBounds(225,200,100,25);
        botaoReset.setFocusable(false);
        botaoReset.addActionListener(this);

        frame.add(labelIdUsuario);
        frame.add(labelSenhaUsuario);
        frame.add(labelMensagem);
        frame.add(labelIdUsuario);
        frame.add(labelSenhaUsuario);
        frame.add(botaoLogin);
        frame.add(botaoReset);
        
        campoIdUsuario.setBounds(125, 100, 200, 25);
        campoSenhaUsuario.setBounds(125, 150, 200, 25);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botaoReset){
            
            campoIdUsuario.setText("");
            campoSenhaUsuario.setText("");
        }
        if (e.getSource()== botaoLogin){
            
            String idUsuario = campoIdUsuario.getText();
            String senhaUsuario = String.valueOf(campoSenhaUsuario.getPassword());
            
            if (LoginSenha.containsKey(idUsuario)) {
                if (LoginSenha.get(idUsuario).equals(infoLogin)){
                    labelMensagem.setForeground(Color.green);
                    labelMensagem.setText("Logado com Sucesso");
                    frame.dispose();
                    PaginaInicial paginaInicial = new PaginaInicial(); //pagina inicial em teoria seria a interface do programa//
                }
                else {
                    labelMensagem.setForeground(Color.red);
                    labelMensagem.setText("Senha Errada");
                }
            }
            else {
                labelMensagem.setForeground(Color.red);
                labelMensagem.setText("Usuario não existente");
            }
        }
    }

    private JTextField JTextField() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
