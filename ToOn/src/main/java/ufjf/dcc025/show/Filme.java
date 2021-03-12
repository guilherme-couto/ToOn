package ufjf.dcc025.show;

public class Filme extends Show {
    private String duracao;

    public Filme (){
    }

    @Override
    public void cadastro(String titulo, String genero, String plataforma, String status, String td) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.status = status;
        duracao = td;
    }

    public void editarOndeParou(String onde){
        ondeParou = onde;
    }

    public String getDuracao() {
        return duracao;
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
    
    public String listarAssistindo(){
        if(status.equals("assistindo")){
            return ("[FILME]   " + titulo + "   -   "  + plataforma + "   -   clique para atualizar onde parou");
        }
        return ("[FILME]   " + titulo + "   -   "  + plataforma + "   -   " + status);
    }

    public String listarAssistir(){
        return ("[FILME]   " + titulo + "   -   " + genero + "   -   " + plataforma + "   -   " + duracao);
    }
}
