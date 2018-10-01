package com;

import com.parsers.json.JSONTools;
import com.parsers.json.JacksonParser;
import com.parsers.xml.DOMParser;
import com.parsers.xml.SAXParser;
import com.parsers.xml.XMLTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String xmlPath = "C:\\Users\\Mykhailo_Popov\\Desktop\\test.xml";
        String newXMLPath = "C:\\Users\\Mykhailo_Popov\\Desktop\\10000$.xml";
        String newJSONPath = "C:\\Users\\Mykhailo_Popov\\Desktop\\test.txt";
        String JSONUrl = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

        XMLTools xmlTools = new XMLTools();
        SAXParser saxParser = new SAXParser();
        DOMParser domParser = new DOMParser();
        JSONTools jsonTools = new JSONTools();
        JacksonParser jacksonParser = new JacksonParser();

        List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1, "Bob", "Kiev", 10000, "university"),
                new Person(2, "Inna", "New York", 2220000, "school"),
                new Person(3, "Izolda", "Odessa", 1100, "university")));

        xmlTools.createXMLDocument(personList, xmlPath);

//        SAXParsing
        List<Person> saxParseList = saxParser.parse(xmlPath);

//        DOMParsing
        List<Person> domParseList = domParser.parse(xmlPath);


        List<Person> newPersonList = new ArrayList<>();
        for (Person person : saxParseList) {
            if (person.getCash() >= 10000) {
                newPersonList.add(person);
            }
        }

        xmlTools.createXMLDocument(newPersonList, newXMLPath);

        jsonTools.writeToFile(newJSONPath, jacksonParser.parse(JSONUrl));

    }
}
