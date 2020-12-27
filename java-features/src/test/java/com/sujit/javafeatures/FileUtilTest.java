package com.sujit.javafeatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
void canTestBigFileName(){
    String actual = new FileUtil().fileName(55);
    assertEquals("I am a big file", actual);
}
    @Test
    void canTestSmallFileName(){
        String actual = new FileUtil().fileName(20);
        assertEquals("I am a small file", actual);
    }

}