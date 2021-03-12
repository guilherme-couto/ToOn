/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 *  Guilherme Martins Couto - 202065500B
 */
package ufjf.dcc025.usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Guilherme Martins Couto - 202065500B
 *
 * @author mateu
 */
public class LoginSenha {

    private static HashMap<String, String> infoLogin = new HashMap<String, String>();

    public LoginSenha() {

        BufferedReader br = null;

        try {

            // Cria o objeto para o arquivo
            File arqv = new File("LoginSenha.txt");

            // Cria BufferedReader para ajudar na leitura do arquivo
            br = new BufferedReader(new FileReader(arqv));

            // para ler cada linha do arquivo
            String linha = null;

            while ((linha = br.readLine()) != null) {

                String[] infos = linha.split(";"); // separa a linha quando encontrar ;

                String username = infos[0].trim();
                String senha = infos[1].trim();

                if (!username.equals("") && !senha.equals("")) {
                    // insere no HashMap
                    infoLogin.put(username, senha);
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

    public static HashMap getLoginInfo() {
        return infoLogin;
    }

}
