package Service;

import Domain.Entity.WordClass;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WordGeneratorService {

    static int sucessCode = 200;

    public static WordClass generatorWord() throws Exception {

        try {
            URL url = new URL("https://random-word-api.vercel.app/api?words=1&length=5");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            if (connection.getResponseCode() != sucessCode)
                throw new RuntimeException("HTTP error code : " + connection.getResponseCode());

            BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            String jsonEmString = Util.convertJsonToString(response);

            Gson gson = new Gson();
            String[] words = gson.fromJson(jsonEmString, String[].class);
            WordClass newWord = new WordClass();
            newWord.setWord(words[0]);

            return newWord;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}