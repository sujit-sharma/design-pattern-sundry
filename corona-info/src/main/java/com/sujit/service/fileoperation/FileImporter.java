package com.sujit.service.fileoperation;

import com.sujit.service.CoronaPOJO;

import java.io.File;
import java.util.List;

public interface FileImporter {

    public List<CoronaPOJO> readFile(File fileName);
}
