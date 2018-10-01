package com.parsers.json;

import com.Currency;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class JSONToolsTest {

    private static final String RESOURCE_PATH = "C:\\Users\\Mykhailo_Popov\\Desktop\\test.txt";

    // insert service to test
    private JSONTools jsonTools = new JSONTools();

    private List<Currency> currencyList = new ArrayList<>(Arrays.asList(
            new Currency(643, "Російський рубль", 0.43101, "RUB", "01.10.2018"),
            new Currency(840, "Долар США", 28.269931, "USD", "01.10.2018"),
            new Currency(978, "Євро", 32.725272, "EUR", "01.10.2018")));

    @Test
    public void shouldWriteToFile() {
        // given

        // when
        jsonTools.writeToFile(RESOURCE_PATH, currencyList);

        // then
        File file = new File(RESOURCE_PATH);
        assertTrue(file.exists());
    }
}

