package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    String filename;
    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException
    {
        super(fileName);

        this.filename = fileName;
        check(fileName);
    }

    public void check(String fileName) throws UnsupportedFileNameException
    {
//        String[] t = fileName.split(".");
//        if(!t[t.length - 1].equals("txt")){
//            throw new UnsupportedFileNameException();
//        }
        if(!fileName.endsWith(".txt")){
            throw new UnsupportedFileNameException();
        }
    }
}

