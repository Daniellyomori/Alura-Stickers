public class Conteudo {
    
    private final String titulo;
    private final String ulrImagem;

    public Conteudo(String titulo, String urlImagem){
        this.titulo = titulo;
        this.ulrImagem = urlImagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUlrImagem() {
        return ulrImagem;
    }

}
