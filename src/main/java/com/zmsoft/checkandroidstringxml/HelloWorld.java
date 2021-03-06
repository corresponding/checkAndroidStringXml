package com.zmsoft.checkandroidstringxml;

import com.zmsoft.checkandroidstringxml.compare.Comparer;

/**
 * @author : corresponding
 * @date : 2017/12/12 14:00.
 */
public class HelloWorld {

    private static final String INPUT_FILE_DIR = "D:\\work\\gitlab_2dfire\\CloudCashDesk\\app"; // \app\src\main\res
    private static final String CSV_INPUT_FILE_PATH = "D:\\work\\record\\2017\\12\\app_string.csv";

    public static void main(String[] args) {

//        XmlDirReader dirReader = new XmlDirReader(INPUT_FILE_DIR);
//        System.out.println(dirReader.toString());

//        CsvReader csvReader = new CsvReader(CSV_INPUT_FILE_PATH);
//        System.out.println(csvReader.toString());

        Comparer comparer = new Comparer(INPUT_FILE_DIR, CSV_INPUT_FILE_PATH);
        System.out.println(comparer.toString());
    }
}
