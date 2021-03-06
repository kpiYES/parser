package com.parsers.xml;

import com.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {

    private static final Integer PERSON_LIST_INDEX = 0;

    public List<Person> parse(String path) {
        List<Person> personList = new ArrayList<>();

        Document document = buildDocument(path);

        Node catalogNode = document.getDocumentElement();
        NodeList notebookNodeList = catalogNode.getChildNodes();
        NodeList personNodeList = notebookNodeList.item(PERSON_LIST_INDEX).getChildNodes();
        for (int i = 0; i < personNodeList.getLength(); i++) {
            Node personNode = personNodeList.item(i);
            personList.add(getPerson(personNode));
        }
        return personList;
    }

    private Document buildDocument(String path) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return documentBuilder.parse(path);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException("Parse Exception", e);
        }
    }

    private Person getPerson(Node personNode) {
        Person person = new Person();
        if (personNode.getNodeType() == Node.ELEMENT_NODE) {
            Element personElement = (Element) personNode;
            person.setName(getTagValue("name", personElement));
            person.setAddress(getTagValue("address", personElement));
            person.setCash(Integer.parseInt(getTagValue("cash", personElement)));
        }
        return person;
    }

    private String getTagValue(String tagName, Element element) {
        NodeList nodeList = element.getElementsByTagName(tagName).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
