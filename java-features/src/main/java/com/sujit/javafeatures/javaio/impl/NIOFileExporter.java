package com.sujit.javafeatures.javaio.impl;

import com.sujit.javafeatures.javaio.FileExportor;
import com.sujit.javafeatures.javaio.Item;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class NIOFileExporter implements FileExportor {

    @Override
    public void writeInFile(List<Item> items, File fileName) {
        try(FileOutputStream fout = new FileOutputStream(fileName)){
            FileChannel outputChannel = fout.getChannel();

            for (Item item: items ) {
                ByteBuffer buffer = ByteBuffer.wrap(item.convertToCSV().getBytes(StandardCharsets.UTF_8));
                outputChannel.write(buffer);

            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }

    }
}
