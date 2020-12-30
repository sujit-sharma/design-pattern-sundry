package com.sujit.javafeatures.javaio.impl;

import com.sujit.javafeatures.javaio.Item;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IOFileExporterTest {
    static private IOFileExporter ioFileExporter;
    static private List<Item> itemList;
    static private File fileTestDirectory;



    @BeforeEach
    @DisplayName("Initilize Directory and Files")
    public void init() {

        ioFileExporter = new IOFileExporter();
        itemList = new ArrayList<>();

        fileTestDirectory = new File("." + File.separator + "src" + File.separator + "test" + File.separator + "TestItemOutput");
        fileTestDirectory.mkdir();
    }
    private boolean isEqual(File file ) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            for (Item item : itemList ) {
                line = reader.readLine() + "\n";
                if(!item.convertToCSV().equals(line))
                    return false;
                            }
        }
        return true;
    }

    @Test
    public void testWhetherGeneratesAppropriateFile() throws IOException {
        File generatedFile  = new File(fileTestDirectory, "momo.csv");
        itemList.add(new Item("momo","one plate", 25.0));
        ioFileExporter.writeInFile(itemList, generatedFile );

        assertEquals(true, isEqual(generatedFile));

    }

    @Test
    public void testIfReadCorrectly_fromMoreContentFile() throws IOException {
        File generatedFile  = new File(fileTestDirectory, "momo.csv");
        itemList.add(new Item("momo","one plate", 25.0));
        itemList.add(new Item("item2", "Two", 50.50));
        itemList.add(new Item("item2", "some qty", 500.25));
        ioFileExporter.writeInFile(itemList, generatedFile );

        assertEquals(true, isEqual(generatedFile));

    }

    @AfterEach
    @DisplayName("Destroying all test created files")
    public void destroyFilesCreatedByTest(){
        String[] Files =  fileTestDirectory.list();
        for(String currentFilePath : Files ){
            File currentFile  = new File(fileTestDirectory.getPath(), currentFilePath);
            currentFile.delete();
        }
        fileTestDirectory.delete();
    }


}