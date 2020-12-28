package com.sujit.javafeatures.javaio.impl;

import com.sujit.javafeatures.javaio.FileImporter;
import com.sujit.javafeatures.javaio.Item;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class NIOFileImporter implements FileImporter {
    @Override
    public List<Item> readFile(File inputFile) {
        List<Item> items = new ArrayList<>();
        Item item;

        try(FileInputStream fin = new FileInputStream(inputFile)){
            FileChannel inChannle = fin.getChannel();
            long filesize = inChannle.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) filesize);
            inChannle.read(buffer);
            buffer.flip();
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < filesize; i++){
                //CharBuffer charBuffer = buffer.asCharBuffer();
                byte onebyte = buffer.get(i);
                if(onebyte ==  10 ){
                    item = Helper.extractItemAttributeBySplitingLineData(line.toString());
                    line.delete(0,line.length());
                    items.add(item);
                }
                line.append((char) onebyte);
            }

        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }

        return items;
    }
}
