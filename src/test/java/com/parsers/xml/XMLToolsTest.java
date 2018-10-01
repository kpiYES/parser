package com.parsers.xml;

import com.Person;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class XMLToolsTest {

    private static final String RESOURCE_PATH = "C:\\Users\\Mykhailo_Popov\\Desktop\\test.xml";
    private List<Person> personList = new ArrayList<>(Arrays.asList(
            new Person(null, "Bob", "Kiev", 10000, null),
            new Person(null, "Inna", "New York", 2220000, null),
            new Person(null, "Izolda", "Odessa", 1100, null)));

    // insert service to test
    private XMLTools xmlTools = new XMLTools();

    @Test
    public void shouldWriteToFile() {
        // given

        // when
        xmlTools.writeToFile(personList, RESOURCE_PATH);

        // then
        File file = new File(RESOURCE_PATH);
        assertTrue(file.exists());
    }
}
