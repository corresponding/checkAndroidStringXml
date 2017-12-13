package com.zmsoft.checkandroidstringxml.compare;

import com.zmsoft.checkandroidstringxml.constant.XmlConstant;
import com.zmsoft.checkandroidstringxml.data.TextValue;
import com.zmsoft.checkandroidstringxml.reader.csv.CsvReader;
import com.zmsoft.checkandroidstringxml.reader.xml.XmlDirReader;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : corresponding
 * @date : 2017/12/13 11:26.
 */
public class Comparer {

    private Map<String, TextValue> resComparedTextMap;      // 整合后的数据
    private Map<String, TextValue> csvExcessTextMap;        // csv中多余数据
    Map<String, TextValue> lackEnTextMap;                    // 整合后res缺少的数据


    public Comparer(String resDirName, String csvName) {
        // 初始为res所有数据
        XmlDirReader xmlDirReader = new XmlDirReader(resDirName);
        resComparedTextMap = xmlDirReader.getTextValueMap();
        // 初始为res所有数据
        CsvReader csvReader = new CsvReader(csvName);
        csvExcessTextMap = csvReader.getTextValueMap();
        // 初始为空
        lackEnTextMap = new TreeMap<>(String::compareTo);

        compareContent();
    }

    private void compareContent() {
        Iterator it = resComparedTextMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            TextValue resTextValue = (TextValue) entry.getValue();

            if (null == resTextValue) {
                continue;
            }
            String resEn = resTextValue.getEn();
            // xml中已经有对应的en
            if (null != resEn && 0 != resEn.length()) {
                continue;
            }
            // 判断csv中有对应的en
            if (csvExcessTextMap.containsKey(key)) {
                TextValue csvTextValue = csvExcessTextMap.get(key);
                String csvEn = csvTextValue.getEn();
                if (null != csvEn && 0 != csvEn.length()) {
                    resTextValue.setValue(XmlConstant.TEXT_VALUE.TYPE.EN, csvEn);
                    // 移除csv对应数据
                    csvExcessTextMap.remove(key);
                    continue;
                }
            }
            // csv中没有对应的en
            lackEnTextMap.put(key, resTextValue);
            // 移除res中对应数据
            it.remove();
        }
    }

    //================================================================================
    // property
    //================================================================================
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, TextValue> entry : lackEnTextMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(" ").append(entry.getValue().toString());
        }
        return stringBuilder.toString();
    }
}
