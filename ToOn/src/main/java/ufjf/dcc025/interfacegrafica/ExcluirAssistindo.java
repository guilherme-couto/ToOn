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
import ufjf.dcc025.usuario.BaseFilmesSeries;

/**
 *
 * @author guilherme
 */
public class ExcluirAssistindo implements ActionListener, MouseListener {

    private JPanel panel = new JPanel();

    private JLabel titulo = new JLabel();
    private JButton botaoExcluir = new JButton();
    private JButton botaoAssistindo = new JButton();
    private JButton botaoVoltar = new JButton();

    private FrameToOn frame = new FrameToOn();

    private String usuarioAtivo;
    private String tituloS;
    private String categoria;
    private BaseFilmesSeries baseDados = new BaseFilmesSeries();

    public ExcluirAssistindo(String nomeUsuario, String tituloShow, String filmeOUserie) {

        usuarioAtivo = nomeUsuario;
        tituloS = tituloShow;
        categoria = filmeOUserie;

        //labels
        titulo.setFont(new Font("Sans Serif", Font.BOLD, 26));
        titulo.setBackground(new Color(30, 29, 29));
        titulo.setForeground(Color.white);
        titulo.setBorder(BorderFactory.createEmptyBorder());
        titulo.setText(tituloS);
        titulo.setPreferredSize(new Dimension(220, 120));
        titulo.setHorizontalAlignment(JTextField.CENTER);

        //botão
        botaoExcluir.addActionListener(this);
        botaoExcluir.setBackground(new Color(248, 161, 31));
        botaoExcluir.setText("Excluir");
        botaoExcluir.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoExcluir.setPreferredSize(new Dimension(160, 30));
        botaoExcluir.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoExcluir.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoExcluir.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoExcluir.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoExcluir.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoExcluir.setForeground(Color.WHITE); // cor da fonte 
        botaoExcluir.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoExcluir.setToolTipText("Clique para excluir");
        botaoExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoExcluir.addMouseListener(this);

        botaoAssistindo.addActionListener(this);
        botaoAssistindo.setBackground(new Color(248, 161, 31));
        botaoAssistindo.setText("Assistindo");
        botaoAssistindo.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoAssistindo.setPreferredSize(new Dimension(160, 30));
        botaoAssistindo.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoAssistindo.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoAssistindo.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoAssistindo.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAssistindo.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAssistindo.setForeground(Color.WHITE); // cor da fonte 
        botaoAssistindo.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoAssistindo.setToolTipText("Clique para colocar na lista de Assistindo");
        botaoAssistindo.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoAssistindo.addMouseListener(this);

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
        panel.setBorder(BorderFactory.createEmptyBorder(35, 35, 35, 35));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo  
        panel.add(titulo);
        panel.add(botaoExcluir);
        panel.add(botaoAssistindo);
        panel.add(botaoVoltar);

        // frame
        frame.setTitle("Tô On - Excluir ou Lista Assistindo");
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botaoAssistindo) {
            baseDados.editarOndeParouShow(usuarioAtivo, tituloS, "assistindo", categoria);
            frame.dispose();
            new MenuPrecisoAssistir(usuarioAtivo);
        } else if (ae.getSource() == botaoVoltar) {
            frame.dispose();
            new MenuPrecisoAssistir(usuarioAtivo);
        } else if (ae.getSource() == botaoExcluir) {
            
            //apaga o show chamando o metodo da base de dados de shows
            baseDados.apagarShow(usuarioAtivo, tituloS, categoria);
            frame.dispose();
            new MenuPrecisoAssistir(usuarioAtivo);
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
        if (me.getSource() == botaoAssistindo) {
            botaoAssistindo.setBackground(new Color(255, 183, 76));
        } else if (me.getSource() == botaoVoltar) {
            botaoVoltar.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoAssistindo) {
            botaoAssistindo.setBackground(new Color(248, 161, 31));
        } else if (me.getSource() == botaoVoltar) {
            botaoVoltar.setForeground(new Color(115, 115, 115));
        }
    }
}
