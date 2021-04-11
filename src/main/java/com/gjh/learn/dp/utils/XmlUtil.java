package com.gjh.learn.dp.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * created on 2021/4/11
 *
 * @author kevinlights
 */
public class XmlUtil {
    /**
     *
     *   design-pattern>simple-factory>type:A
     *
     * @param firstTag simple-factory
     * @param secondTag type
     * @return
     */
    public static String getValue(String firstTag, String secondTag) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(XmlUtil.class.getClassLoader().getResourceAsStream("design-pattern.xml"));
            NodeList childNodes = doc.getElementsByTagName(firstTag).item(0).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (secondTag.equals(item.getNodeName())) {
                    return item.getFirstChild().getNodeValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
