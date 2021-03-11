package ufjf.dcc025.show;

import java.util.ArrayList;

public class ListaAssistir {
    private ArrayList <String> assistir = new ArrayList<>();
    
    public ListaAssistir(){

    }

    public void adicionarSerie(Serie serie){
        assistir.add(serie.listarAssistir());
    }

    public void adicionarFilme(Filme filme){
        assistir.add(filme.listarAssistir());
    }

    public int getSize(){
        return assistir.size();
    }

    public String getPorIndice(int indice){
        return assistir.get(indice);
    }
    public ArrayList<String> getLista()
    {
        return assistir;
    }
}
