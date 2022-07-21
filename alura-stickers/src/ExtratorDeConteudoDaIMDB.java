import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaIMDB implements ExtratorDeConteudo{
    public List<Conteudo> extraiConteudos(String json){
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String imagem = atributos.get("image")
                .replaceAll("(@+)(.*).jpg$", "$1.jpg");
            var conteudo = new Conteudo (titulo, imagem);

            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
