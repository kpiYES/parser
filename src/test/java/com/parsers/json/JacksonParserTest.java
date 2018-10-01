package com.parsers.json;

import com.Currency;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JacksonParserTest {

    private static final String RESOURCE_PATH = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    // insert service to test
    private JacksonParser jacksonParser = new JacksonParser();

    private List<Currency> currencyList = new ArrayList<>(Arrays.asList(
            new Currency(643, "Російський рубль", 0.43101, "RUB", "01.10.2018"),
            new Currency(840, "Долар США", 28.269931, "USD", "01.10.2018"),
            new Currency(978, "Євро", 32.725272, "EUR", "01.10.2018")));

    @Test
    public void shouldParse() {
        // given

        // when
        List<Currency> resultList = jacksonParser.parse(RESOURCE_PATH);

        // then
        assertThat(resultList.isEmpty(), is(false));
        assertThat(resultList, is(currencyList));
    }
}
