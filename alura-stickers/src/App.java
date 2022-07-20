import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class App {
    public static void main(String[] args) throws Exception {

        //Conexão HTTP com API
        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI endereco = URI.create(url);
        var client =  HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        //Extrair dados pertinentes
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        //Manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            var geradora = new GeradoraDeFigurinhas();

            String nomeArquivo = "saida/" + titulo + ".png";
            geradora.cria(inputStream,nomeArquivo);

            System.out.println(titulo);
            System.out.println();
        }
    }
}
