package com.zmsoft.checkandroidstringxml.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : corresponding
 * @date : 2017/12/12 14:00.
 */
public class TextValue {

    /**
     * ""           - > 登录
     * "-zh-rTW"    - > 登錄
     * "-en"        - > Login
     */
    Map<String, String> countryMap;

    public TextValue() {
        countryMap = new HashMap<>();
    }

    public void put(String country, String value) {
        countryMap.put(country, value);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : countryMap.entrySet()) {
            stringBuilder.append("        " + entry.getKey() + " " + entry.getValue() + "\n");
        }
        return stringBuilder.toString();
    }
}
