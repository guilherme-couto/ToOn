/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * Guilherme Martins Couto - 202065500B
 *
 */
package ufjf.dcc025.usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import ufjf.dcc025.show.Filme;
import ufjf.dcc025.show.ListaAssistindo;
import ufjf.dcc025.show.ListaAssistir;
import ufjf.dcc025.show.Serie;

/**
 *
 * @author guilherme
 */
public class BaseFilmesSeries {

    ListaAssistir listaAssistir = new ListaAssistir();
    ListaAssistindo listaAssistindo = new ListaAssistindo();

    public BaseFilmesSeries(String nomeUsuarioAtivo, boolean assistindo) {

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
                        f.cadastro(infos[1], infos[2], infos[3], assistindo, infos[4]);
                         
                        if(infos[5].equals("assistindo")){
                            listaAssistindo.adicionarFilme(f);
                        }
                        else{
                            listaAssistir.adicionarFilme(f);
                        }
                    }
                    else if(infos.length == 7) { //a linha indica uma serie
                        Serie s = new Serie();
                        s.cadastro(infos[1], infos[2], infos[3], assistindo, infos[4]);
                        if(infos[6].equals("assistindo")){
                            listaAssistindo.adicionarSerie(s);
                        }
                        else{
                            listaAssistir.adicionarSerie(s);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                };
            }
        }
    }
    
    public ListaAssistir getListaAssistir(){
        return listaAssistir;
    }
    
    public ListaAssistindo getListaAssistindo(){
        return listaAssistindo;
    }

}
