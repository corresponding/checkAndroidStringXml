package com.zmsoft.checkandroidstringxml.constant;

/**
 * @author : corresponding
 * @date : 2017/12/12 14:00.
 */
public interface XmlConstant {

    interface ENCODE {
        String UTF_8 = "UTF-8";
    }

    interface READER {
        String RES_DIR_NAME = "res";
        String VALUES_DIR_SUFFIX = "values";
        String STRING_FILE_NAME = "strings.xml";
    }

    interface STRINGS_XML {
        String ATTRIBUTE_KEY = "name";      // <string name="save">保存</string>  其中的name
    }

    interface CSV {
        String SPILT_PUNCTUATION = ",";
        int SPILT_LENGTH = 3;
        interface SPILT_INDEX {
            int KEY = 0;
            int ZH = 1;
            int EN = 2;
        }
    }


    interface TEXT_VALUE {
        interface TYPE {
            String ZH_1 = "values";
            String ZH_2 = "values-zh";
            String TW = "values-zh-rTW";
            String EN = "values-en";
        }
    }
}
