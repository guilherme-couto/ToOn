/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.usuario;

/**
 *
 * @author mateus 
 */

            //Idealmente vá ser substituido ou chamado por outra classe de outro pacote.

public class Main {
    public static void main(String[], args){
        
        LoginSenha usuario = new LoginSenha(); // inicia um novo usuario, para o login do mesmo.
        
        PaginaLogin paginaLogin = new PaginaLogin(LoginSenha.getLoginInfo()); // chama a pagina de login
        
        
    }
}
