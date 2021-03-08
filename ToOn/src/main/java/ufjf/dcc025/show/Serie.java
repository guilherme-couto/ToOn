package ufjf.dcc025.show;

import java.util.ArrayList;

public class Serie extends Show{
    private int temporadas;
    private ArrayList<Integer> episodios = new ArrayList();

    public Serie (){
        
    }

    @Override
    public void cadastro(String titulo, Genero genero, String plataforma, boolean assistindo,  String td) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.assistindo = assistindo;
        temporadas = Integer.parseInt(td);
    }

    public void adicionarEpisodios(int ep){
        episodios.add(ep);
    }

    public void editarTemporadas(int temporadas){
        this.temporadas = temporadas;
    }

    public void editarEpisodios(int temporada, int nEp){
        episodios.remove(temporada-1);
        episodios.add(temporada-1, nEp);
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

    public Genero getGenero() {
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
    
    
    
}
