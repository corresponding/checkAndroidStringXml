package com.zmsoft.checkandroidstringxml;

import com.zmsoft.checkandroidstringxml.reader.DirReader;

public class HelloWorld {

    private static final String INPUT_FILE_DIR = "D:\\work\\gitlab_2dfire\\CloudCashDesk"; // \app\src\main\res
    private static final String OUTPUT_FILE_PATH = "D:\\work\\record\\2017\\12\\1.xml";

    public static void main(String[] args) {

        DirReader dirReader = new DirReader(INPUT_FILE_DIR);
        System.out.println(dirReader.toString());
    }
}
