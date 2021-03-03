package ufjf.dcc025.show;

import java.util.ArrayList;

public class Serie extends Show{
    private int temporadas;
    private ArrayList<int> episodios = new ArrayList();

    public Serie (String titulo, Genero genero, String plataforma, boolean assistindo, int temporadas){
        super(titulo, genero, plataforma, assistindo);
        this.temporadas = temporadas;
    }
    
}
