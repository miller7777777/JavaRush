package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{

//    private AdapterFileOutputStream adapter;
    private FileOutputStream fos;

    public AdapterFileOutputStream(FileOutputStream fos)
    {
        this.fos = fos;
    }

    @Override
    public void flush() throws IOException
    {
        this.fos.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {

        byte[] b = s.getBytes();
        this.fos.write(b);

    }

    @Override
    public void close() throws IOException
    {

        this.fos.close();

    }
}

