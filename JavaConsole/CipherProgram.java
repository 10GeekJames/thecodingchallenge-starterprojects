import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CipherProgram {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest cipherGetCipherRequest = HttpRequest.newBuilder()
                .uri(new URI("https://thecodingchallenge.com/.netlify/functions/challengeContent"))
                .GET()
                .build();

        HttpResponse<String> cipherGetCipherResponse = httpClient.send(cipherGetCipherRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Get Cipher Code: " + cipherGetCipherResponse.statusCode());
        System.out.println("Get Cipher Body: " + cipherGetCipherResponse.body());

        HttpRequest cipherSetAnswerRequest = HttpRequest.newBuilder()
                .uri(new URI("https://thecodingchallenge.com/.netlify/functions/challengeContentCheckAnswer?answer=YourAnswerHere"))
                .GET()
                .build();

        HttpResponse<String> cipherSetAnswerResponse = httpClient.send(cipherSetAnswerRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Set Answer Code: " + cipherSetAnswerResponse.statusCode());
        System.out.println("Set Answer Body: " + cipherSetAnswerResponse.body());
    }
}
