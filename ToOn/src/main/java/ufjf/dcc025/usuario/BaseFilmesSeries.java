/*

 *
 * Guilherme Martins Couto - 202065500B
 *
 */
package ufjf.dcc025.usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import ufjf.dcc025.show.Filme;
import ufjf.dcc025.show.ListaAssistindo;
import ufjf.dcc025.show.ListaAssistir;
import ufjf.dcc025.show.Serie;

/**
 *
 * @author guilherme
 */
public class BaseFilmesSeries {

    private ListaAssistir listaAssistir = new ListaAssistir();
    private ListaAssistindo listaAssistindo = new ListaAssistindo();

    public BaseFilmesSeries() {
    }

    public ListaAssistir getListaAssistir() {
        return listaAssistir;
    }

    public ListaAssistindo getListaAssistindo() {
        return listaAssistindo;
    }

    public void carregaBaseDados(String nomeUsuarioAtivo) {

        BufferedReader br = null;
        try {
            // Cria o objeto para o arquivo
            File arqv = new File("BaseFilmesSeries.txt");

            // Cria BufferedReader para ajudar na leitura do arquivo
            br = new BufferedReader(new FileReader(arqv));

            // para ler cada linha do arquivo
            String linha = null;

            while ((linha = br.readLine()) != null) {

                String[] infos = linha.split(";"); // separa a linha quando encontrar ;
                String username = infos[0].trim();

                // checar se a linha corresponde a um show do usuario ativo
                if (username.equals(nomeUsuarioAtivo)) {

                    if (infos.length == 6) { //a linha indica um filme
                        Filme f = new Filme();
                        f.cadastro(infos[1], infos[2], infos[3], infos[5], infos[4]);

                        if (infos[5].equals("assistir")) {
                            listaAssistir.adicionarFilme(f);
                        } else {
                            listaAssistindo.adicionarFilme(f);
                        }
                    } else if (infos.length == 7) { //a linha indica uma serie
                        Serie s = new Serie();
                        s.cadastro(infos[1], infos[2], infos[3], infos[6], infos[4]);
                        s.editarEpisodios(Integer.parseInt(infos[5]));
                        if (infos[6].equals("assistir")) {
                            listaAssistir.adicionarSerie(s);
                        } else {
                            listaAssistindo.adicionarSerie(s);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO NO CONSTRUTOR DE BASE FILMES SERIES");

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                };
            }
        }
    }
    
    //a ação de apagar funciona reescrevendo o arquivo em um auxiliar, excluindo o que se pretende apagar,
    //depois apga o arquivo antigo e, por fim, troca o nome do auxiliar para o nome do antigo
    public void apagarShow(String usuarioAtivo, String tituloShow, String filmeOUserie) {
        String arqvAux = "temporario.txt";
        File arqvAntigo = new File("BaseFilmesSeries.txt");
        File arqvNovo = new File(arqvAux);
        try {
            arqvNovo.createNewFile();
        } catch (IOException e) {
            System.out.println("ERRO AO CRIAR ARQV");
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(arqvAux, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            BufferedReader br = new BufferedReader(new FileReader("BaseFilmesSeries.txt"));

            // para ler cada linha do arquivo
            String linha = null;

            while ((linha = br.readLine()) != null) {

                String[] infos = linha.split(";"); // separa a linha quando encontrar ;

                String username = "";
                String titulo = "";
                String categoria = "";

                if (infos.length == 6) {
                    username = infos[0].trim();
                    titulo = infos[1].trim();
                    categoria = "filme";
                } else if (infos.length == 7) {
                    username = infos[0].trim();
                    titulo = infos[1].trim();
                    categoria = "serie";
                }

                // caso não seja o usuario e o show que estamos procurando, copiamos a linha para o novo arquivo
                if (!username.equals(usuarioAtivo) || !titulo.equals(tituloShow) || !categoria.equals(filmeOUserie)) {
                    pw.println(linha);
                }
            }

            pw.flush();
            pw.close();
            fw.close();
            bw.close();
            br.close();

            //apaga o arquivo antigo e renomeia o arquvio novo, que está sem os dados que apagamos
            arqvAntigo.delete();
            File criador = new File("BaseFilmesSeries.txt");
            arqvNovo.renameTo(criador);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO NO METODO APAGAR SHOW");
        }
    }

    //a edição funciona reescrevendo o arquivo em um auxiliar, acrescentando o que se pretende mudar, 
    //depois apga o arquivo antigo e, por fim, troca o nome do auxiliar para o nome do antigo
    public void editarOndeParouShow(String usuarioAtivo, String tituloShow, String novoOndeParou, String filmeOUserie) {
        String arqvAux = "temporario.txt";
        File arqvAntigo = new File("BaseFilmesSeries.txt");
        File arqvNovo = new File(arqvAux);
        try {
            arqvNovo.createNewFile();
        } catch (IOException e) {
            System.out.println("ERRO AO CRIAR ARQV");
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(arqvAux, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            BufferedReader br = new BufferedReader(new FileReader("BaseFilmesSeries.txt"));

            // para ler cada linha do arquivo
            String linha = null;

            while ((linha = br.readLine()) != null) {

                String[] infos = linha.split(";"); // separa a linha quando encontrar ;

                System.out.print(" infos0: " + infos[0]);
                String username = "";
                String titulo = "";
                String categoria = "";

                if (infos.length == 6) {
                    username = infos[0].trim();
                    titulo = infos[1].trim();
                    categoria = "filme";
                } else if (infos.length == 7) {
                    username = infos[0].trim();
                    titulo = infos[1].trim();
                    categoria = "serie";
                }

                // se for a linha do show que se busca editar, altera a linha
                if (username.equals(usuarioAtivo) && titulo.equals(tituloShow) && categoria.equals(filmeOUserie)) {
                    if (categoria.equals("filme")) {
                        pw.println(infos[0] + ";" + infos[1] + ";" + infos[2] + ";" + infos[3] + ";"
                                + infos[4] + ";" + "onde parou: " + novoOndeParou);
                    } else if (categoria.equals("serie")) {
                        pw.println(infos[0] + ";" + infos[1] + ";" + infos[2] + ";" + infos[3] + ";"
                                + infos[4] + ";" + infos[5] + ";" + "onde parou: " + novoOndeParou);
                    }
                } else { //senao, apenas copia para o novo arquivo
                    pw.println(linha);
                }
            }

            pw.flush();
            pw.close();
            fw.close();
            bw.close();
            br.close();

            //apaga o arquivo antigo e renomeia o arquvio novo, que está sem os dados que apagamos
            arqvAntigo.delete();
            File criador = new File("BaseFilmesSeries.txt");
            arqvNovo.renameTo(criador);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO NO METODO EDITAR ONDE PAROU SHOW");
        }
    }

    //a edição funciona reescrevendo o arquivo em um auxiliar, acrescentando o que se pretende mudar, 
    //depois apga o arquivo antigo e, por fim, troca o nome do auxiliar para o nome do antigo
    public void editarStatus(String usuarioAtivo, String tituloShow, String novoStatus, String filmeOUserie) {
        String arqvAux = "temporario.txt";
        File arqvAntigo = new File("BaseFilmesSeries.txt");
        File arqvNovo = new File(arqvAux);
        try {
            arqvNovo.createNewFile();
        } catch (IOException e) {
            System.out.println("ERRO AO CRIAR ARQV");
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(arqvAux, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            BufferedReader br = new BufferedReader(new FileReader("BaseFilmesSeries.txt"));

            // para ler cada linha do arquivo
            String linha = null;

            while ((linha = br.readLine()) != null) {

                String[] infos = linha.split(";"); // separa a linha quando encontrar ;

                System.out.print(" infos0: " + infos[0]);
                String username = "";
                String titulo = "";
                String categoria = "";

                if (infos.length == 6) {
                    username = infos[0].trim();
                    titulo = infos[1].trim();
                    categoria = "filme";
                } else if (infos.length == 7) {
                    username = infos[0].trim();
                    titulo = infos[1].trim();
                    categoria = "serie";
                }

                // se for a linha do show que se busca editar, altera a linha
                if (username.equals(usuarioAtivo) && titulo.equals(tituloShow) && categoria.equals(filmeOUserie)) {
                    if (categoria.equals("filme")) {
                        pw.println(infos[0] + ";" + infos[1] + ";" + infos[2] + ";" + infos[3] + ";"
                                + infos[4] + ";" + novoStatus);
                    } else if (categoria.equals("serie")) {
                        pw.println(infos[0] + ";" + infos[1] + ";" + infos[2] + ";" + infos[3] + ";"
                                + infos[4] + ";" + infos[5] + ";" + novoStatus);
                    }
                } else { //senao, apenas copia para o novo arquivo
                    pw.println(linha);
                }
            }

            pw.flush();
            pw.close();
            fw.close();
            bw.close();
            br.close();

            //apaga o arquivo antigo e renomeia o arquvio novo, que está sem os dados que apagamos
            arqvAntigo.delete();
            File criador = new File("BaseFilmesSeries.txt");
            arqvNovo.renameTo(criador);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO NO METODO EDITAR STATUS SHOW");
        }
    }
}
