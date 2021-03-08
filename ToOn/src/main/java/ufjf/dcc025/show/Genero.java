package ufjf.dcc025.show;

import java.io.StreamTokenizer;

public class Genero {
    private String genero;
    private String subGenero;

    public Genero (){
    }

    public void cadastrarGenero(String genero, String subGenero){
        this.genero = genero;
        this.subGenero = subGenero;
    }
}
