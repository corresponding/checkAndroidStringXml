package com.zmsoft.checkandroidstringxml.reader.csv;

import com.zmsoft.checkandroidstringxml.constant.XmlConstant;
import com.zmsoft.checkandroidstringxml.data.TextValue;

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : corresponding
 * @date : 2017/12/13 10:01.
 */
public class CsvReader {

    /**
     * key  :   String.xml中key，例如"login"
     * value:   TextValue，每个国家对于一个value
     */
    private TreeMap<String, TextValue> textValueMap;

    public CsvReader(String fileName) {
        textValueMap = new TreeMap<>(String::compareTo);
        parseCsvFile(fileName);
    }

    private void parseCsvFile(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), XmlConstant.ENCODE.UTF_8);
            reader = new BufferedReader(isr);
            String originText = null;
            while ((originText = reader.readLine()) != null) {
                String[] originTextArray = originText.split(XmlConstant.CSV.SPILT_PUNCTUATION);
                if (XmlConstant.CSV.SPILT_LENGTH != originTextArray.length) {
                    continue;
                }
                String key = originTextArray[XmlConstant.CSV.SPILT_INDEX.KEY];
                String valueZh = originTextArray[XmlConstant.CSV.SPILT_INDEX.ZH];
                String valueEn = originTextArray[XmlConstant.CSV.SPILT_INDEX.EN];
                if (!textValueMap.containsKey(key)) {
                    TextValue textValue = new TextValue();
                    textValue.setValue(XmlConstant.TEXT_VALUE.TYPE.ZH_1, valueZh);
                    textValue.setValue(XmlConstant.TEXT_VALUE.TYPE.EN, valueEn);
                    textValueMap.put(key, textValue);
                } else {
                    TextValue textValue = textValueMap.get(key);
                    textValue.setValue(XmlConstant.TEXT_VALUE.TYPE.ZH_1, valueZh);
                    textValue.setValue(XmlConstant.TEXT_VALUE.TYPE.EN, valueEn);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //================================================================================
    // property
    //================================================================================
    public TreeMap<String, TextValue> getTextValueMap() {
        return textValueMap;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, TextValue> entry : textValueMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(" ").append(entry.getValue().toString());
        }
        return stringBuilder.toString();
    }
}
