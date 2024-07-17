/**
 * 
 */
package com.amk.cucumber.utility;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.File;

/**
 * @author Mahesh.Kurnool
 *
 */
public class StringToXml {

	public static void main(String[] args) {
		final String xmlStr = "<employees>" + " <employee id=\"101\">" + "    <name>Lokesh Gupta</name>"
				+ "     <title>Author</title>" + " </employee>" + " <employee id=\"102\">"
				+ "    <name>Brian Lara</name>" + "     <title>Cricketer</title>" + " </employee>" + "</employees>";

		// Use method to convert XML string content to XML Document object
		Document doc = convertStringToXMLDocument(xmlStr);

		// Verify XML document is build correctly
		System.out.println(doc.getFirstChild().getNodeName());

		final String xmlFilePath = "employees.xml";

		// Use method to convert XML string content to XML Document object
		Document docs = convertXMLFileToXMLDocument(xmlFilePath);
	}

	private static Document convertStringToXMLDocument(String xmlString) {
		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try {
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Document convertXMLFileToXMLDocument(String filePath) {
		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try {
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new File(filePath));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
