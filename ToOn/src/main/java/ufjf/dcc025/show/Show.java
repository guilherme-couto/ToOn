package ufjf.dcc025.show;

public class Show {
    private String titulo;
    private Genero genero;
    private String plataforma;
    private boolean assistindo;
    private String ondeParou;

    public Show(String titulo, Genero genero, String plataforma, boolean assistindo) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.assistindo = assistindo;
    }

    
}
