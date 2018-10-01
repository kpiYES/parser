package com.parsers.xml;

import com.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SAXParserTest {

    private static final String RESOURCE_PATH = "C:\\Users\\Mykhailo_Popov\\Desktop\\test.xml";

    // insert service to test
    private SAXParser saxParser = new SAXParser();

    private List<Person> personList = new ArrayList<>(Arrays.asList(
            new Person(null, "Bob", "Kiev", 10000, null),
            new Person(null, "Inna", "New York", 2220000, null),
            new Person(null, "Izolda", "Odessa", 1100, null)));

    @Test
    public void shouldParse() {
        // given

        // when
        List<Person> resultList = saxParser.parse(RESOURCE_PATH);

        // then
        assertThat(resultList.isEmpty(), is(false));
        assertThat(resultList, is(personList));
    }
}
