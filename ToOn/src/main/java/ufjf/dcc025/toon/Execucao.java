/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 * Guilherme Martins Couto - 202065500B
 *
 */
package ufjf.dcc025.toon;

import ufjf.dcc025.interfacegrafica.PaginaLogin;
import ufjf.dcc025.usuario.LoginSenha;

/**
 *
 * @author guilherme
 */
public class Execucao {
    
    public static void main(String[] args) {
        new LoginSenha();
        new PaginaLogin(LoginSenha.getLoginInfo());
    }       
}
