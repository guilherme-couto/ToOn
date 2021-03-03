package ufjf.dcc025.show;

public class Filme extends Show {
    private String duracao;

    public Filme (String titulo, Genero genero, String plataforma, boolean assistindo, String duracao){
        super(titulo, genero, plataforma, assistindo);
        this.duracao = duracao;
    }
}
