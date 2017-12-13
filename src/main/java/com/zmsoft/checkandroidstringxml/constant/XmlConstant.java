package com.zmsoft.checkandroidstringxml.constant;

/**
 * @author : corresponding
 * @date : 2017/12/12 14:00.
 */
public interface XmlConstant {

    interface READER {
        String RES_DIR_NAME = "res";
        String VALUES_DIR_SUFFIX = "values";
        String STRING_FILE_NAME = "strings.xml";
    }

    interface STRINGS_XML {
        String ATTRIBUTE_KEY = "name";      // <string name="save">保存</string>  其中的name
    }

    interface TEXT_VALUE {
        interface TYPE {
            String ZH = "values";
            String TW = "values-zh-rTW";
            String EN = "values-en";
        }
    }
}
