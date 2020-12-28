package com.sujit.javafeatures;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class FileUtil {

    public String fileName(int size){
        if(size> 50)
            return "I am a big file";
        return "I am a small file";

    }

}
