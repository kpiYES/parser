package com.parsers.xml;

import com.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DOMParserTest {

    private static final String RESOURCE_PATH = "src\\test\\resources\\test.xml";
    // insert service to test
    private DOMParser domParser = new DOMParser();

    private List<Person> personList = new ArrayList<>(Arrays.asList(
            new Person(1, "Bob", "Kiev", 10000, "university"),
            new Person(2, "Inna", "New York", 2220000, "school"),
            new Person(3, "Izolda", "Odessa", 1100, "university")));

    @Test
    public void shouldParse() {
        // given

        // when
        List<Person> resultList = domParser.parse(RESOURCE_PATH);

        // then
        assertThat(resultList.isEmpty(), is(false));
        assertThat(resultList, is(personList));
    }
}
