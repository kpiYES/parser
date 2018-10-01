package com.parsers.xml;

import com.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParser {

    public List<Person> parse(String path) {
        List<Person> personList = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                String currentTag;
                Person currentPerson;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    currentTag = qName;
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (currentTag.equals("name")) {
                        currentPerson = new Person();
                        currentPerson.setName(new String(ch, start, length));
                    }

                    if (currentTag.equals("address")) {
                        currentPerson.setAddress(new String(ch, start, length));
                    }

                    if (currentTag.equals("cash")) {
                        currentPerson.setCash(Integer.parseInt(new String(ch, start, length)));
                        currentPerson = null;
                    }
                }

                @Override
                public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
                    if (currentPerson != null) {
                        personList.add(currentPerson);
                    }
                    currentTag = "";
                }
            };
            saxParser.parse(path, handler);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException("Parse Exception", e);
        }
        return personList;
    }

}
