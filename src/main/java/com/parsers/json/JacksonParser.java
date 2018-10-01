package com.parsers.json;

import com.Currency;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonParser {

    public List<Currency> parse(String path) {
        JSONTools jsonTools = new JSONTools();
        ObjectMapper objectMapper = new ObjectMapper();
        Currency[] currencies;
        try {
            currencies = objectMapper.readValue(jsonTools.readUrl(path), Currency[].class);
        } catch (IOException e) {
            throw new RuntimeException("Object mapper reading Exception", e);
        }
        List<Currency> currencyList = new ArrayList<>();
        for (Currency currency : currencies) {
            String cc = currency.getCc();
            if (cc.equals("RUB") || cc.equals("USD") || cc.equals("EUR")) {
                currencyList.add(currency);
            }
        }
        return currencyList;
    }
}
