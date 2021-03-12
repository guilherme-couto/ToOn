package ufjf.dcc025.show;

import java.util.ArrayList;

public class Serie extends Show{
    private int temporadas;
    private int episodios;

    public Serie (){
        
    }

    @Override
    public void cadastro(String titulo, String genero, String plataforma, String status,  String td) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.status = status;
        temporadas = Integer.parseInt(td);
    }

    public void editarTemporadas(int temporadas){
        this.temporadas = temporadas;
    }

    public void editarEpisodios( int episodios){
        this.episodios=episodios;
    }

    public void editarOndeParou(String onde){
        ondeParou = onde;
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

    public String getStatus() {
        return status;
    }

    public String getOndeParou() {
        return ondeParou;
    }

    public int getEpisodios(){
        return episodios;
    }
    
    public String listarAssistindo(){
        if(status.equals("assistindo")){
            return ("[SERIE]   " + titulo + "   -   "  + plataforma + "   -   clique para atualizar onde parou");
        }
        return ("[SERIE]   " + titulo + "   -   "  + plataforma + "   -   " + status);
    }

    public String listarAssistir(){
        return ("[SERIE]   " + titulo + "   -   " + genero + "   -   " + plataforma + "   -   T: " + temporadas + "   EPs: " + episodios);
    }
    
    
}
