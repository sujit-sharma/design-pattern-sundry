package com.sujit.service.fileoperation;

import com.sujit.service.CoronaPOJO;

import java.io.File;
import java.util.List;

public interface FileExporter {
    public void writeCoronaInfo(List<CoronaPOJO> listOfData , File filename );
}
