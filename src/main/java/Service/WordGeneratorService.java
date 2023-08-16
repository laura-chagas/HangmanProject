package Service;

import Domain.Entity.WordClass;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WordGeneratorService {

    static int codigoSucesso = 200;

    public static WordClass generatorWord() throws Exception {

        try {
            URL url = new URL("https://random-word-api.vercel.app/api?words=1");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestProperty("accept", "application/json");
            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();
            WordClass newWord = gson.fromJson(jsonEmString, WordClass.class);

            return newWord;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}