package com.parsers.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GSONParser {

    public static List<String> parse(String path) {
        JSONTools jsonTools = new JSONTools();
        List<String> list = new ArrayList<>();
        String json;
        try {
            json = jsonTools.readUrl(path);
        } catch (IOException e) {
            throw new RuntimeException("Object mapper reading Exception", e);
        }
        JsonElement jsonDocument = new JsonParser().parse(json);
        JsonArray jsonArray = jsonDocument.getAsJsonArray();
        for (JsonElement jsonCurrencyElement : jsonArray) {
            JsonObject jsonCurrencyObject = jsonCurrencyElement.getAsJsonObject();
            String cc = jsonCurrencyObject.get("cc").getAsString();
            if (cc.equals("RUB") ||
                    cc.equals("USD") ||
                    cc.equals("EUR")) {
                list.add(jsonCurrencyElement.toString());
            }
        }
        return list;
    }
}
