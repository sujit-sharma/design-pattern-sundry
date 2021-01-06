package com.sujit.singleton;

import java.util.logging.Logger;

public class SystemAnalyzer {

    private SystemInfo systemInfo = null;

   public void analyzeMemoryInfo(){
       long totalMemory =
       SystemInfo.getInstance().totalMemoryAllocatedToJVM();
       Logger.getGlobal().info("Your JVM have " + totalMemory + " memory Available");

       if(totalMemory > 1245632){
           Logger.getGlobal().info("You have Enough Memory To run process big data structures");
       }
       else
           Logger.getGlobal().info("Sorry, You don't have memory for running memory oriented process");
   }

   public void analyzeCPUs() {
       int numberOfCpu = SystemInfo.getInstance().availableProcessors();
       Logger.getGlobal().info("Number of Processors in your System are " + numberOfCpu);
       if(numberOfCpu > 4){
           Logger.getGlobal().info("You have Enough CPUs To run process oriented task");
       }
       else
           Logger.getGlobal().info("Sorry, You don't enough CPUs to run process oriented task");

   }

    public static void main(String[] args) {
       SystemAnalyzer analyzer = new SystemAnalyzer();
       analyzer.analyzeMemoryInfo();
       analyzer.analyzeCPUs();
    }
}
