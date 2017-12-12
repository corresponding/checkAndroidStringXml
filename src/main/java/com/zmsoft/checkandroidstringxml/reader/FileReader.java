package com.zmsoft.checkandroidstringxml.reader;

import com.zmsoft.checkandroidstringxml.TextValue;
import com.zmsoft.checkandroidstringxml.XmlConstant;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class FileReader {


    /**
     *
     * @param inputXml
     * @param textValueMap
     * @param country
     */
    public static void parseXml(File inputXml, Map<String, TextValue> textValueMap, String country) {
        Element rootElement = getRootElement(inputXml);
        if (null == rootElement) {
            return;
        }

        for (Iterator i = rootElement.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            String key = element.attributeValue(XmlConstant.ATTRIBUTE_KEY);
            String value = element.getText();
            if (!textValueMap.containsKey(key)) {
                TextValue textValue = new TextValue();
                textValue.put(country, value);
                textValueMap.put(key, textValue);
            } else {
                TextValue textValue = textValueMap.get(key);
                textValue.put(country, value);
            }
        }
    }


    /**
     * 解析文件，生成根元素
     * @param inputXml
     * @return
     */
    private static Element getRootElement(File inputXml) {
        Element rootElement = null;
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputXml);
            rootElement = document.getRootElement();
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return rootElement;
    }
}
