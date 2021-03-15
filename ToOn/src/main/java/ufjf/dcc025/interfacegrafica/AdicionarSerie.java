/*

 */
 /*
 *  Guilherme Martins Couto - 202065500B
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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author guilherme
 */
public class AdicionarSerie implements ActionListener, MouseListener {

    private JPanel panel = new JPanel();

    private JButton botaoAdicionar = new JButton();
    private JButton botaoVoltar = new JButton();
    private JLabel mensagem = new JLabel();
    private JTextField titulo = new JTextField();
    private JTextField genero = new JTextField();
    private JTextField plataforma = new JTextField();
    private JTextField numTemporadas = new JTextField();
    private JTextField numEpisodios = new JTextField();
    private JTextField obrigatorio = new JTextField();
    private TitledBorder descricao;

    private FrameToOn frame = new FrameToOn();

    private String usuarioAtivo;
    private String situacao;

    public AdicionarSerie(String nomeUsuario, String status) {

        usuarioAtivo = nomeUsuario;
        situacao = status;

        // caixas de texto
        titulo.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        titulo.setBackground(new Color(30, 29, 29));
        titulo.setForeground(Color.white);
        titulo.setCaretColor(Color.white);
        titulo.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Título*");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        titulo.setBorder(descricao);
        titulo.setPreferredSize(new Dimension(250, 50));
        titulo.setToolTipText("Título da série");

        genero.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        genero.setBackground(new Color(30, 29, 29));
        genero.setForeground(Color.white);
        genero.setCaretColor(Color.white);
        genero.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Gênero*");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        genero.setBorder(descricao);
        genero.setPreferredSize(new Dimension(250, 50));
        genero.setToolTipText("Gênero da série");

        plataforma.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        plataforma.setBackground(new Color(30, 29, 29));
        plataforma.setForeground(Color.white);
        plataforma.setCaretColor(Color.white);
        plataforma.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Plataforma*");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        plataforma.setBorder(descricao);
        plataforma.setPreferredSize(new Dimension(250, 50));
        plataforma.setToolTipText("Plataforma da série");

        numTemporadas.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        numTemporadas.setBackground(new Color(30, 29, 29));
        numTemporadas.setForeground(Color.white);
        numTemporadas.setCaretColor(Color.white);
        numTemporadas.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Número de Temporadas*");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        numTemporadas.setBorder(descricao);
        numTemporadas.setPreferredSize(new Dimension(250, 50));
        numTemporadas.setToolTipText("Número de Temporadas da série");

        numEpisodios.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        numEpisodios.setBackground(new Color(30, 29, 29));
        numEpisodios.setForeground(Color.white);
        numEpisodios.setCaretColor(Color.white);
        numEpisodios.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Número de Episódios*");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        numEpisodios.setBorder(descricao);
        numEpisodios.setPreferredSize(new Dimension(250, 50));
        numEpisodios.setToolTipText("Número de Episódios da série");

        obrigatorio.setFont(new Font("Sans Serif", Font.ITALIC, 13));
        obrigatorio.setBackground(new Color(30, 29, 29));
        obrigatorio.setForeground(new Color(115, 115, 115));
        obrigatorio.setBorder(BorderFactory.createEmptyBorder());
        obrigatorio.setText("* Campo obrigatório");
        obrigatorio.setEditable(false);
        obrigatorio.setEnabled(false);
        obrigatorio.setPreferredSize(new Dimension(500, 20));
        obrigatorio.setHorizontalAlignment(JTextField.CENTER);

        mensagem.setFont(new Font("Sans Serif", Font.ITALIC, 13));
        mensagem.setBackground(new Color(30, 29, 29));
        mensagem.setForeground(Color.white);
        mensagem.setBorder(BorderFactory.createEmptyBorder());
        mensagem.setText("");
        mensagem.setPreferredSize(new Dimension(500, 35));
        mensagem.setHorizontalAlignment(JTextField.CENTER);

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

        botaoVoltar.addActionListener(this);
        botaoVoltar.setBackground(new Color(30, 29, 29));
        botaoVoltar.setText("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(800, 30));
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
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 100, 100));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo  
        panel.add(titulo);
        panel.add(genero);
        panel.add(plataforma);
        panel.add(numTemporadas);
        panel.add(numEpisodios);
        panel.add(obrigatorio);
        panel.add(mensagem);
        panel.add(botaoAdicionar);
        panel.add(botaoVoltar);

        // frame
        frame.setTitle("Tô On - Adicionar Série");
        frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
        frame.setSize(780, 520);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botaoAdicionar) {
            System.out.println(titulo.getText());

            String tituloSerie = titulo.getText();
            String generoSerie = genero.getText();
            String plataformaSerie = plataforma.getText();
            String numTemporadasSerie = numTemporadas.getText();
            String numEpisodiosSerie = numEpisodios.getText();

            if (tituloSerie.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Título não pode estar em branco");
            } else if (generoSerie.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Gênero não pode estar em branco");
            } else if (plataformaSerie.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Plataforma não pode estar em branco");
            } else if (numTemporadasSerie.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Temporadas não pode estar em branco");
            } else if (numEpisodiosSerie.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Episodios não pode estar em branco");
            } else {
                try {
                    FileWriter fw = new FileWriter("BaseFilmesSeries.txt", true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(usuarioAtivo + ";" + tituloSerie + ";" + generoSerie
                            + ";" + plataformaSerie + ";" + numTemporadasSerie + ";" + numEpisodiosSerie + ";"
                            + situacao);
                    fw.close();
                    pw.close();
                    System.out.println("Serie adicionada com sucesso");
                } catch (IOException e) {
                    System.out.println("Erro ocorreu ao tentar adicionar filme");
                    e.printStackTrace();
                }
                if (situacao.equals("assistir")) {
                    frame.dispose();
                    new MenuPrecisoAssistir(usuarioAtivo);
                } else if (situacao.equals("assistindo")) {
                    frame.dispose();
                    new MenuAssistindo(usuarioAtivo);
                }
            }
        } else if (ae.getSource() == botaoVoltar) {
            if (situacao.equals("assistir")) {
                frame.dispose();
                new MenuPrecisoAssistir(usuarioAtivo);
            } else if (situacao.equals("assistindo")) {
                frame.dispose();
                new MenuAssistindo(usuarioAtivo);
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
