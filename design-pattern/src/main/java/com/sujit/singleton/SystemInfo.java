package com.sujit.singleton;

import java.io.Serializable;

public class SystemInfo implements Serializable {

    private static volatile  SystemInfo systemInfo;

    private SystemInfo() {
        if(systemInfo != null){
            throw new SingletonRuleViolationException("This Singleton Class is already initialized. Use getInstance Method instead");
        }
        }


    public static SystemInfo getInstance(){
        if(systemInfo == null)
        {
            synchronized (SystemInfo.class){
                if (systemInfo == null ) systemInfo = new SystemInfo();
            }
        }
        return systemInfo;
    }

    protected SystemInfo readResolve() {
        return getInstance();
    }


    // Other function of this class

    public long totalMemoryAllocatedToJVM(){
        return Runtime.getRuntime().totalMemory();

    }

    public int availableProcessors(){
        return Runtime.getRuntime().availableProcessors();
    }

}
