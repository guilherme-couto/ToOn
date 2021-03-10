package ufjf.dcc025.show;

import java.util.ArrayList;

public class ListaAssistindo {
    private ArrayList <String> assistindo = new ArrayList<>();

    public ListaAssistindo(){

    }

    public void adicionarSerie(Serie serie){
        assistindo.add(serie.listarAssistindo());
    }

    public void adicionarFilme(Filme filme){
        assistindo.add(filme.listarAssistindo());
    }

    public int getSize(){
        return assistindo.size();
    }

    public String getPorIndice(int indice){
        return assistindo.get(indice);
    }
}
