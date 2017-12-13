package com.zmsoft.checkandroidstringxml.data;

import com.zmsoft.checkandroidstringxml.constant.XmlConstant;

/**
 * @author : corresponding
 * @date : 2017/12/12 14:00.
 */
public class TextValue {

    private String zh;  // values, values-zh
    private String en;  // values-en
    private String tw;  // values-zh-rTW


    public void setValue(String type, String value) {
        if (XmlConstant.TEXT_VALUE.TYPE.ZH_1.equals(type) || XmlConstant.TEXT_VALUE.TYPE.ZH_2.equals(type)) {
            zh = value;
        } else if (XmlConstant.TEXT_VALUE.TYPE.EN.equals(type)) {
            en = value;
        } else if (XmlConstant.TEXT_VALUE.TYPE.TW.equals(type)) {
            tw = value;
        }
    }

    public String getZh() {
        return zh;
    }

    public String getEn() {
        return en;
    }

    public String getTw() {
        return tw;
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
