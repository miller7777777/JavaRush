package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imageType)
    {

        ImageReader reader;

        if (imageType == ImageTypes.JPG)
        {
            reader = new JpgReader();

        }else

        if (imageType == ImageTypes.BMP)
        {
            reader = new BmpReader();

        }else

        if (imageType == ImageTypes.PNG)
        {
            reader = new PngReader();

        }else{
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        return reader;


    }
}
