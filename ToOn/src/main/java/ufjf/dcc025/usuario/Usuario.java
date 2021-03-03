/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.usuario;

import java.util.Scanner;

/**
 *
 * @author Mateus S. Cruz (201765554AC)
 */
public class Usuario {

    private String senha;

    private int id;

    //public Lista lista;   ||| Mais pra frente, emplementar uma classe ou função Lista, pra armazenar os shows do usuario.
    public String login;

    private void setSenha() {
        this.senha = senha;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    private void setId() {
        this.id = id;
    }

    private String getSenha() {
        return this.senha;
    }

    private int getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }

    public void Exibir() {
        System.out.printf("Login: %s /n Senha: %d /n ID: %.2f /n", getLogin(), getSenha(), getId());
    }  // função pra testes. Apagar depois

    public static void cadastro() {
        
        //Scanner scan = new Scanner (new File("the\\dir\\myFile.extension"));
        Scanner input = new Scanner(System.in);

        String novo_login;
        String nova_senha;

        System.out.println("Cadastro /n");
        System.out.println("usuario: ");
        novo_login = input.next();

        System.out.println("senha: ");
        nova_senha = input.next();
        
          
        Usuario novo_usuario;
        
        
    }

}
