package src.main.java;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import cipherPrograms.MorseCodeStrategy;
import models.CipherAnswerMessage;
import models.CipherMessage;

public class Main {

    private static final String MORSE_CODE_QUESTION_URL = "https://thecodingchallenge.com/.netlify/functions/challengeContent";
    private static final String MORSE_CODE_ANSWER_URL = "https://thecodingchallenge.com/.netlify/functions/challengeContentCheckAnswer?answer=YourAnswerHere";

    public static void main(String[] args) throws Exception {
        MorseCodeStrategy decrypt = new MorseCodeStrategy();
        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpCipherRequestClient = HttpClient.newHttpClient();
        HttpRequest cipherGetCipherRequest = HttpRequest.newBuilder()
                .uri(new URI(MORSE_CODE_QUESTION_URL))
                .GET()
                .build();
        
        JsonFactory jsonFactory = new JsonFactory();
        HttpResponse<String> cipherGetCipherResponse = httpCipherRequestClient.send(cipherGetCipherRequest, BodyHandlers.ofString());

        CipherMessage morseCipherMessage = objectMapper.readValue(cipherGetCipherResponse.body(), CipherMessage.class);
        String message = decrypt.decrypt(morseCipherMessage);
        System.out.println(message);


        HttpClient httpCipherAnswerClient = HttpClient.newHttpClient();
        HttpRequest cipherGetCipherAnswerRequest = HttpRequest.newBuilder()
                .uri(new URI(MORSE_CODE_ANSWER_URL))
                .GET()
                .build();
        
        HttpResponse<String> cipherGetCipherAnswerResponse = httpCipherAnswerClient.send(cipherGetCipherAnswerRequest, BodyHandlers.ofString());

        CipherAnswerMessage morseCipherAnswerMessage = objectMapper.readValue(cipherGetCipherAnswerResponse.body(), CipherAnswerMessage.class);
        System.out.println(morseCipherAnswerMessage.getIsCorrect());


    }
}
