package com.sujit.javafeatures.javaio;

import java.io.File;
import java.util.List;

public interface FileExportor {

    public void writeInFile(List<Item> items, File fileName);
}
