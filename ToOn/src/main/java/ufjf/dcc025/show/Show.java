package ufjf.dcc025.show;

public abstract class Show {
    protected String titulo;
    protected String genero;
    protected String plataforma;
    protected boolean assistindo;
    protected String ondeParou;

    public abstract void cadastro(String titulo, String genero, String plataforma, boolean assistindo, String td);
}
