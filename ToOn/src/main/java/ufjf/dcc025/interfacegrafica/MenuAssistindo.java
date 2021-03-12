/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ufjf.dcc025.show.ListaAssistindo;
import ufjf.dcc025.usuario.BaseFilmesSeries;

/**
 *
 * @author guilherme
 */
public class MenuAssistindo implements ActionListener, MouseListener, ListSelectionListener {

    public String[] padrao = {"Você não está assistindo a nada agora. Adicione mais filmes e séries a sua lista!"};

    private ImageIcon plus = new ImageIcon("src/main/java/imagens/plus_icon.png");
    private ImageIcon home = new ImageIcon("src/main/java/imagens/home_icon.png");
    private ImageIcon homeBranca = new ImageIcon("src/main/java/imagens/home_icon_branca.png");

    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JList lista = new JList();
    private JScrollPane scrollPane = new JScrollPane();
    private JButton botaoAddFilme = new JButton();
    private JButton botaoAddSerie = new JButton();
    private JButton botaoHome = new JButton();
    private JCheckBox check = new JCheckBox();

    private FrameToOn frame = new FrameToOn();

    private String usuarioAtivo;
    private ListaAssistindo listaAssistindo;
    private BaseFilmesSeries baseDados = new BaseFilmesSeries();

    public MenuAssistindo(String nomeUsuario) {

        // pega as informaçoes atualizadas da base de dados
        usuarioAtivo = nomeUsuario;
        baseDados.carregaBaseDados(usuarioAtivo);
        listaAssistindo = baseDados.getListaAssistindo();

        // botoes
        botaoAddFilme.addActionListener(this);
        botaoAddFilme.setBackground(new Color(248, 161, 31));
        botaoAddFilme.setText("Filme");
        botaoAddFilme.setIcon(plus);
        botaoAddFilme.setIconTextGap(10);
        botaoAddFilme.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoAddFilme.setPreferredSize(new Dimension(120, 30));
        botaoAddFilme.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoAddFilme.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoAddFilme.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoAddFilme.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAddFilme.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAddFilme.setForeground(Color.WHITE); // cor da fonte 
        botaoAddFilme.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoAddFilme.setSize(60, 20);
        botaoAddFilme.setToolTipText("Clique para adicionar um Filme");
        botaoAddFilme.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoAddFilme.addMouseListener(this);

        botaoAddSerie.addActionListener(this);
        botaoAddSerie.setBackground(new Color(248, 161, 31));
        botaoAddSerie.setText("Série");
        botaoAddSerie.setIcon(plus);
        botaoAddSerie.setIconTextGap(10);
        botaoAddSerie.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoAddSerie.setPreferredSize(new Dimension(120, 30));
        botaoAddSerie.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoAddSerie.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoAddSerie.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoAddSerie.setForeground(Color.WHITE); // cor da fonte 
        botaoAddSerie.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoAddSerie.setToolTipText("Clique para adicionar uma Série");
        botaoAddSerie.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoAddSerie.addMouseListener(this);

        botaoHome.addActionListener(this);
        botaoHome.setBackground(new Color(30, 29, 29));
        botaoHome.setOpaque(true);
        botaoHome.setIcon(home);
        botaoHome.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoHome.setPreferredSize(new Dimension(20, 20));
        botaoHome.setHorizontalTextPosition((JButton.CENTER)); // alinhamento horizontal do texto
        botaoHome.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoHome.setBorder(BorderFactory.createEmptyBorder()); // altera a borda do botão
        botaoHome.setToolTipText("Clique para voltar para o Menu Principal");
        botaoHome.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoHome.addMouseListener(this);

        //checkbox
        check.setText("Mostrar Assistidos");
        check.setFocusable(false);
        check.setFont(new Font("Sans Serif", Font.BOLD, 15));
        check.setBackground(new Color(30, 29, 29));
        check.setForeground(new Color(115, 115, 115));
        
        // panel                
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 0));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        panel2.setBackground(new Color(30, 29, 29)); // muda a cor de fundo
        panel2.add(botaoAddFilme);
        panel2.add(botaoAddSerie);

        panel3.setBorder(BorderFactory.createEmptyBorder(40, 0, 30, 25));
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel3.setBackground(new Color(30, 29, 29)); // muda a cor de fundo
        panel3.add(botaoHome);

        panel.setBorder(BorderFactory.createEmptyBorder());
        panel.setLayout(new GridLayout(0, 2, 0, 0));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo
        panel.setPreferredSize(new Dimension(100, 90));
        panel.add(panel2);
        panel.add(panel3);

        //list
        if (listaAssistindo.getSize() == 0) {
            lista.setListData(padrao);
            lista.setFont(new Font("Sans Serif", Font.ITALIC, 20));
            lista.setForeground(new Color(115, 115, 115));
        } else {
            lista.setListData(listaAssistindo.getLista().toArray());
            lista.setFont(new Font("Sans Serif", Font.PLAIN, 20));
            lista.setForeground(Color.WHITE);
        }
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setSize(630, 490);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(-1);
        lista.setBackground(new Color(34, 34, 34));
        lista.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        lista.addListSelectionListener(this);

        // scroll pane
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 13, 13, 13));
        //scrollPane.setViewportBorder(BorderFactory.createEmptyBorder(0, 13, 13, 13));
        scrollPane.setOpaque(true);
        scrollPane.setBackground(new Color(30, 29, 29));
        scrollPane.setVisible(true);
        scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(lista);
        scrollPane.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // frame
        frame.setTitle("Tô On - Menu Assistindo");
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botaoAddFilme) {
            new AdicionarFilme(usuarioAtivo, "assistindo");
            frame.dispose();
        }
        if (ae.getSource() == botaoAddSerie) {
            new AdicionarSerie(usuarioAtivo, "assistindo");
            frame.dispose();
        }

        if (ae.getSource() == botaoHome) {
            frame.dispose();
            new MenuPrincipal(usuarioAtivo);
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
        if (me.getSource() == botaoAddFilme) {
            botaoAddFilme.setBackground(new Color(255, 183, 76));
        }
        if (me.getSource() == botaoAddSerie) {
            botaoAddSerie.setBackground(new Color(255, 183, 76));
        }
        if (me.getSource() == botaoHome) {
            botaoHome.setIcon(homeBranca);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoAddFilme) {
            botaoAddFilme.setBackground(new Color(248, 161, 31));
        }
        if (me.getSource() == botaoAddSerie) {
            botaoAddSerie.setBackground(new Color(248, 161, 31));
        }
        if (me.getSource() == botaoHome) {
            botaoHome.setIcon(home);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        int index = lista.getSelectedIndex();
        if (index != -1) {
            String s = listaAssistindo.getPorIndice(index);
            String divisor = "   -   ";
            String [] infos = s.split(divisor);
            
            String categoria = infos[0].substring(1, 6); //nome da categoria
            categoria = categoria.toLowerCase();
            System.out.println("categoria: " + categoria);
            String titulo = infos[0].substring(10); //titulo do show
            System.out.println("titulo: " + titulo);
            
            new ExcluirAtualizar(usuarioAtivo, titulo, categoria);
            frame.dispose();
           
        }
    }
}
