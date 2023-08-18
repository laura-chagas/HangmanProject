package Service;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {
    public static String convertJsonToString(BufferedReader buffereReader) throws IOException {
        String response, jsonString = "";
        while ((response = buffereReader.readLine()) != null) {
            jsonString += response;
        }
        return jsonString;
    }
}