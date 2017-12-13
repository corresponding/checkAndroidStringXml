package com.zmsoft.checkandroidstringxml.data;

import com.zmsoft.checkandroidstringxml.constant.XmlConstant;

/**
 * @author : corresponding
 * @date : 2017/12/12 14:00.
 */
public class TextValue {

    private String zh;  // 默认values
    private String en;  // values-en
    private String tw;  // values-zh-rTW


    public void setValue(String type, String value) {
        if (XmlConstant.TEXT_VALUE.TYPE.ZH.equals(type)) {
            zh = value;
        } else if (XmlConstant.TEXT_VALUE.TYPE.TW.equals(type)) {
            en = value;
        } else if (XmlConstant.TEXT_VALUE.TYPE.EN.equals(type)) {
            tw = value;
        }
    }

    @Override
    public String toString() {
        return "TextValue{" +
                "zh='" + zh + '\'' +
                ", en='" + en + '\'' +
                ", tw='" + tw + '\'' +
                '}' + '\n';
    }
}
