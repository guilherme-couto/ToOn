package ufjf.dcc025.show;

import java.util.ArrayList;

public class Serie extends Show{
    private int temporadas;
    private int episodios;

    public Serie (){
        
    }

    @Override
    public void cadastro(String titulo, String genero, String plataforma, boolean assistindo,  String td) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.assistindo = assistindo;
        temporadas = Integer.parseInt(td);
    }

    public void editarTemporadas(int temporadas){
        this.temporadas = temporadas;
    }

    public void editarEpisodios( int episodios){
        this.episodios=episodios;
    }

    public void editarOndeParou(int temporada, int episodio){
        ondeParou = "T: " + temporada + ", Ep: " + episodio;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public boolean isAssistindo() {
        return assistindo;
    }

    public String getOndeParou() {
        return ondeParou;
    }

    public int getEpisodios(){
        return episodios;
    }
    
    public String listarAssistindo(){
        return titulo + " | " + genero + " | " + plataforma + " | " + temporadas + " | " + episodios + " | " + ondeParou;
    }

    public String listarAssistir(){
        return titulo + " | " + genero + " | " + plataforma + " | " + temporadas + " | " + episodios;
    }
    
    
}
