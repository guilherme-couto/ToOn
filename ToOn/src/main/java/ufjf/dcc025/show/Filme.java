package ufjf.dcc025.show;

public class Filme extends Show {
    private String duracao;

    public Filme (){
    }

    @Override
    public void cadastro(String titulo, Genero genero, String plataforma, boolean assistindo, String td) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.assistindo = assistindo;
        duracao = td;
    }

    public void editarOndeParou(int hora, int min, int seg){
        ondeParou = hora + ":" + min + ":" + seg;
    }

    public String getDuracao() {
        return duracao;
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
