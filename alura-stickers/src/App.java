import java.util.List;
import java.io.InputStream;
import java.net.URL;

public class App {
    public static void main(String[] args) throws Exception {

        //String url = "https://alura-filmes.herokuapp.com/conteudos";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaIMDB();

        String url = "https://api.nasa.gov/planetary/apod?api_key=wrL38mU5vcxgXL4Gt3F956jdDfbxv2U2VflsozKk&start_date=2022-06-12&end_date=2022-06-14";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();


        var http = new clienteHttp();
        String json = http.buscaDados(url);

        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        //Manipular os dados
        for (int i = 0; i< 3; i++) {
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUlrImagem()).openStream();
            var geradora = new GeradoraDeFigurinhas();

            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";
            geradora.cria(inputStream,nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
