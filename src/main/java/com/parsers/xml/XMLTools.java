package com.parsers.xml;

import com.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;


public class XMLTools {

    public void createXMLDocument(List<Person> personList, String path) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Create new DocumentBuilder Exception", e);
        }
        Document document = builder.newDocument();

        Element catalog = document.createElement("catalog");
        document.appendChild(catalog);

        Element notebook = document.createElement("notebook");
        catalog.appendChild(notebook);

        for (Person person : personList) {

            Element personNode = document.createElement("person");
            personNode.setAttribute("id", String.valueOf(person.getId()));

            Element nameNode = document.createElement("name");
            nameNode.setTextContent(person.getName());
            personNode.appendChild(nameNode);

            Element addressNode = document.createElement("address");
            addressNode.setTextContent(person.getAddress());
            personNode.appendChild(addressNode);

            Element cashNode = document.createElement("cash");
            cashNode.setTextContent(String.valueOf(person.getCash()));
            personNode.appendChild(cashNode);

            Element educationNode = document.createElement("education");
            educationNode.setTextContent(person.getEducation());
            personNode.appendChild(educationNode);

            notebook.appendChild(personNode);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
           Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);
        } catch ( TransformerException e) {
            throw new RuntimeException( "Transform Exception", e);
        }


    }
}
