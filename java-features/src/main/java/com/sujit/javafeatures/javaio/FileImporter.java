package com.sujit.javafeatures.javaio;

import java.io.File;
import java.util.List;

public interface FileImporter {

    public List<Item> readFile(File inputFile);
}
