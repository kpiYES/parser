package com.parsers.xml;

import com.Person;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DOMParserTest {

//    @Before
//    public void setUp() throws Exception {
//        List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1, "Bob", "Kiev", 10000, "university"),
//                new Person(2, "Inna", "New York", 2220000, "school"),
//                new Person(3, "Izolda", "Odessa", 1100, "university")));
//        String path = "C:\\Users\\Misha\\Desktop\\test.xml";
//    }
//
//    @Test
//    public void shouldParse() {
//        DOMParser domParser = new DOMParser();
//        Document document;
//        try {
//            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            document = documentBuilder.parse(path);
//        } catch (ParserConfigurationException | IOException | SAXException e) {
//            throw new RuntimeException("Parse Exception", e);
//        }
//
//        Node catalogNode = document.getDocumentElement();
//        NodeList notebookNodeList = catalogNode.getChildNodes();
//        NodeList personNodeList = notebookNodeList.item(0).getChildNodes();
//        for (int i = 0; i < personNodeList.getLength(); i++) {
//            Node personNode = personNodeList.item(i);
////            personList.add(domParser.getPerson(personNode));
//        }
//
//
//    }
}
