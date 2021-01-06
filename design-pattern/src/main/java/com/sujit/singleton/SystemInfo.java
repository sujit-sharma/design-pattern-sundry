package com.sujit.singleton;

public class SystemInfo {

    private static  SystemInfo systemInfo = null;

    private SystemInfo(){}

    public synchronized static SystemInfo getInstance(){
        if(systemInfo == null)
            systemInfo = new SystemInfo();
        return systemInfo;
    }


    // Other function of this class

    public long totalMemoryAllocatedToJVM(){
        return Runtime.getRuntime().totalMemory();

    }

    public int availableProcessors(){
        return Runtime.getRuntime().availableProcessors();
    }

}
