package ufjf.dcc025.show;

public abstract class Show {
    protected String titulo;
    protected String genero;
    protected String plataforma;
    protected String status;
    protected String ondeParou = "onde parou: ";

    public abstract void cadastro(String titulo, String genero, String plataforma, String status, String td);
}
