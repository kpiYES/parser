package com.parsers.json;

import com.Currency;
import org.json.simple.JSONArray;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class JSONTools {

    public String readUrl(String urlString) throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder builder = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                builder.append(chars, 0, read);
            return builder.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public void writeToFile(String path, List<Currency> currencyList) {
        JSONArray array = new JSONArray();
        array.addAll(currencyList);
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(array.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException("Write to file exception", e);
        }
    }
}
