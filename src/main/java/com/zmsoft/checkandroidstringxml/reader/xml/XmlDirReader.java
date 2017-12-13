package com.zmsoft.checkandroidstringxml.reader.xml;

import com.zmsoft.checkandroidstringxml.data.TextValue;
import com.zmsoft.checkandroidstringxml.constant.XmlConstant;

import java.io.File;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : corresponding
 * @date : 2017/12/12 14:00.
 */
public class XmlDirReader {


    private File dirFile;
    /**
     * key  :   String.xml中key，例如"login"
     * value:   TextValue，每个国家对于一个value
     */
    private TreeMap<String, TextValue> textValueMap;

    public XmlDirReader(String dirName) {
        dirFile = new File(dirName);
        textValueMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        parseDir(dirFile);
    }

    //================================================================================
    // build map
    //================================================================================
    private void parseDir(File dirFile) {
        if (!dirFile.isDirectory()) {
            return;
        }
        File[] subFileList = dirFile.listFiles();
        if (null == subFileList) {
            return;
        }

        for (int i = 0; i < subFileList.length; i++) {
            File subFile = subFileList[i];
            if (subFile.isDirectory()) {
                String subFileName = subFile.getName();
                // 处理res文件夹
                if (XmlConstant.READER.RES_DIR_NAME.equals(subFileName)) {
                    parseResDir(subFile);
                } else {
                    parseDir(subFile);
                }
            }
        }
    }

    private void parseResDir(File dirFile) {
        if (!dirFile.isDirectory()) {
            return;
        }
        File[] subFileList = dirFile.listFiles();
        if (null == subFileList) {
            return;
        }

        for (int i = 0; i < subFileList.length; i++) {
            File subFile = subFileList[i];
            if (subFile.isDirectory()) {
                String subFileName = subFile.getName();
                if (subFileName.startsWith(XmlConstant.READER.VALUES_DIR_SUFFIX)) {
                    parseValuesDir(subFile, subFileName);
                }
            }
        }
    }

    private void parseValuesDir(File dirFile, String country) {
        if (!dirFile.isDirectory()) {
            return;
        }
        File[] subFileList = dirFile.listFiles();
        if (null == subFileList) {
            return;
        }

        for (int i = 0; i < subFileList.length; i++) {
            File subFile = subFileList[i];
            if (subFile.isDirectory()) {
                return;
            }
            String subFileName = subFile.getName();
            if (XmlConstant.READER.STRING_FILE_NAME.equals(subFileName)) {
                XmlFileReader.parseXml(subFile, textValueMap, country);
            }
        }
    }

    //================================================================================
    // toString
    //================================================================================
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, TextValue> entry : textValueMap.entrySet()) {
            stringBuilder.append(entry.getKey() + " " + entry.getValue().toString());
        }
        return stringBuilder.toString();
    }
}
