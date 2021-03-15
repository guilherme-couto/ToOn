/*
    Guilherme Martins Couto - 202065500B
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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import ufjf.dcc025.usuario.BaseFilmesSeries;

/**
 *
 * @author guilherme
 */
public class PaginaEditarShow implements ActionListener, MouseListener {

    private JPanel panel = new JPanel();

    private JLabel titulo = new JLabel();
    private JLabel mensagem = new JLabel();
    private JTextField ondeParou = new JTextField();
    private JButton botaoAtualizar = new JButton();
    private JButton botaoVoltar = new JButton();
    private TitledBorder descricao;

    private FrameToOn frame = new FrameToOn();

    private String usuarioAtivo;
    private String tituloS;
    private String categoria;
    private BaseFilmesSeries baseDados = new BaseFilmesSeries();

    public PaginaEditarShow(String nomeUsuario, String tituloShow, String filmeOUserie) {
        
        usuarioAtivo = nomeUsuario;
        tituloS = tituloShow;
        categoria = filmeOUserie;
        
        //labels
        titulo.setFont(new Font("Sans Serif", Font.BOLD, 26));
        titulo.setBackground(new Color(30, 29, 29));
        titulo.setForeground(Color.white);
        titulo.setBorder(BorderFactory.createEmptyBorder());
        titulo.setText("Atualizar " + tituloS);
        titulo.setPreferredSize(new Dimension(220, 120));
        titulo.setHorizontalAlignment(JTextField.CENTER);

        mensagem.setFont(new Font("Sans Serif", Font.ITALIC, 13));
        mensagem.setBackground(new Color(30, 29, 29));
        mensagem.setForeground(Color.white);
        mensagem.setBorder(BorderFactory.createEmptyBorder());
        mensagem.setText("");
        mensagem.setPreferredSize(new Dimension(220, 35));
        mensagem.setHorizontalAlignment(JTextField.CENTER);

        // caixa de texto
        ondeParou.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        ondeParou.setBackground(new Color(30, 29, 29));
        ondeParou.setForeground(Color.white);
        ondeParou.setCaretColor(Color.white);
        ondeParou.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Onde parou");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        ondeParou.setBorder(descricao);
        ondeParou.setPreferredSize(new Dimension(200, 50));
        ondeParou.setToolTipText("Digite onde você parou");

        //botão
        botaoAtualizar.addActionListener(this);
        botaoAtualizar.setBackground(new Color(248, 161, 31));
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoAtualizar.setPreferredSize(new Dimension(160, 30));
        botaoAtualizar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoAtualizar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoAtualizar.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoAtualizar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAtualizar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAtualizar.setForeground(Color.WHITE); // cor da fonte 
        botaoAtualizar.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoAtualizar.setToolTipText("Clique para atualizar");
        botaoAtualizar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoAtualizar.addMouseListener(this);

        botaoVoltar.addActionListener(this);
        botaoVoltar.setBackground(new Color(30, 29, 29));
        botaoVoltar.setText("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(200, 30));
        botaoVoltar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoVoltar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoVoltar.setFont(new Font("Sans Serif", Font.ITALIC, 17)); // fonte do texto
        botaoVoltar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoVoltar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoVoltar.setForeground(new Color(115, 115, 115)); // cor da fonte 
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder()); // altera a borda do botão
        botaoVoltar.setToolTipText("Clique para voltar");
        botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoVoltar.addMouseListener(this);

        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(15, 35, 35, 35));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo  
        panel.add(titulo);
        panel.add(ondeParou);
        panel.add(mensagem);
        panel.add(botaoAtualizar);
        panel.add(botaoVoltar);

        // frame
        frame.setTitle("Tô On - Página Atualizar");
        frame.setSize(450, 550);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botaoAtualizar) {
            String onde = ondeParou.getText();
            //chama os metodos de edição da base de dados, que vai reescrever o arquivo
            if (!onde.equals("")) {
                baseDados.editarOndeParouShow(usuarioAtivo, tituloS, onde, categoria);
                frame.dispose();
                new MenuAssistindo(usuarioAtivo); //é preciso dar um new, pois assim a página "recarrega" com as infos novas
            } else {
                mensagem.setForeground(Color.red);
                mensagem.setText("Onde parou não pode estar em branco");
            }
        } else if (ae.getSource() == botaoVoltar){
            frame.dispose();
            new MenuAssistindo(usuarioAtivo); //é preciso dar um new, pois assim a página "recarrega" com as infos novas
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
        if (me.getSource() == botaoAtualizar) {
            botaoAtualizar.setBackground(new Color(255, 183, 76));
        } else if (me.getSource() == botaoVoltar) {
            botaoVoltar.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoAtualizar) {
            botaoAtualizar.setBackground(new Color(248, 161, 31));
        } else if (me.getSource() == botaoVoltar) {
            botaoVoltar.setForeground(new Color(115, 115, 115));
        }
    }

}
