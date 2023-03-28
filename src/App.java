
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Conexão Http
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
       

        //Extrair/parciar dados
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        //System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(0));
        
        //Exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[37m \u001b[44m FullTitle: \u001b[m" + filme.get("fullTitle"));
            System.out.println("---------");
            System.out.println("\u001b[37m \u001b[44m Image: \u001b[m" + filme.get("image"));
            System.out.println("---------");
            System.out.println("\u001b[37m \u001b[44m Rating: \u001b[m" + filme.get("imDbRating"));
            System.out.println("---------");
        }
    }
}
