/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.usuario;
import java.util.HashMap;

/**
 *
 * @author mateu
 */
public class LoginSenha {

    static boolean containsKey(String idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Object get(String idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    HashMap<String,String> infoLogin = new HashMap<String, String> ();
    
    LoginSenha (){
        infoLogin.put("testeum", "teste");
        infoLogin.put ("java", "teste");
        infoLogin.put ("Mateus", "Souza");
    }
    
    protected static HashMap getLoginInfo(){
        return infoLogin;
    }
    
    
  
}
