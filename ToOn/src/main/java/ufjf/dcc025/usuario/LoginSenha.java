/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author mateu
 */
public class LoginSenha {

    static HashMap<String, String> infoLogin = new HashMap<String, String>();

    public LoginSenha() {

        BufferedReader br = null;

        try {

            File file = new File("LoginSenha.txt"); // Cria o objeto para o arquivo

            br = new BufferedReader(new FileReader(file)); // Cria BufferedReader para ajudar na leitura do arquivo

            String linha = null;

            while ((linha = br.readLine()) != null) {

                String[] infos = linha.split(";"); // separa a linha quando encontrar ;

                String username = infos[0].trim();
                String senha = infos[1].trim();

                if (!username.equals("") && !senha.equals("")) {
                    infoLogin.put(username, senha); // insere no HashMap
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Always close the BufferedReader 
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
