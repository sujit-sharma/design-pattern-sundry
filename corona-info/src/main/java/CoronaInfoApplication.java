import com.sujit.Utils;
import com.sujit.database.CoronaInfoDAO;
import com.sujit.database.CoronaInfoH2Impl;
import com.sujit.service.InfoTransferMediator;
import com.sujit.service.impl.CoronaInfoRandomDataGenerator;
import com.sujit.service.CoronaPOJO;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class CoronaInfoApplication {



    public static void main(String[] args) throws Exception {
        InfoTransferMediator infoTransferMediator = new InfoTransferMediator();
        CoronaInfoApplication coronaInfoApplication = new CoronaInfoApplication();
        Properties properties = Utils.propertiesLoader();
        CoronaInfoDAO db = new CoronaInfoH2Impl();
        //creating Database Table
        db.createTable();
        Logger.getGlobal().info("Database Created");

        //generate random data and export to file corona.data
        infoTransferMediator.exportToFile(new CoronaInfoRandomDataGenerator().generate(), new File(properties.getProperty("outputFile")));
        Logger.getGlobal().info("Data inserted to file corona.data");
        //import Data from file System corona.data
        List<CoronaPOJO> coronaInfoList =  infoTransferMediator.importFromFile(new File(properties.getProperty("outputFile")));
        Logger.getGlobal().info("Data read from file corona.data");
        Logger.getGlobal().info("Inserting Data to Database ................");
        coronaInfoList.stream().forEach(row -> db.insert(row));
        Logger.getGlobal().info(" All Data inserted successfully");

        //updating data on database
        Logger.getGlobal().info("Updating Database With new Data ..............");
        db.updateAll(new CoronaInfoRandomDataGenerator().generate());
        Logger.getGlobal().info("Database Updated Successfully");
        
        //storing Updated data on another File corona.data.v2
        Logger.getGlobal().info("Exporting Updated Data to File corona.data.v2");
        List<CoronaPOJO> updatedData = db.getAllPaginatedCovidInfo(10000);
        infoTransferMediator.exportToFile(updatedData, new File(properties.getProperty("outputFile.v2")));
        Logger.getGlobal().info("Updated data Exported To File ");

        //remove items from database
        Logger.getGlobal().info("Removing Items From Database .............");
        int affectedRows  = db.remove(10);
        Logger.getGlobal().info("Removed " +affectedRows + " From Database");


        //Finally exporting data to file
        Logger.getGlobal().info("Selecting Paginated data from database  .................");
        List<CoronaPOJO> filteredData = db.getAllPaginatedCovidInfo(50);
        Logger.getGlobal().info("All data accessed from database ");
        Logger.getGlobal().info("Exporting selected data to file corona.data.v3 ............");
        infoTransferMediator.exportToFile(filteredData, new File(properties.getProperty("outputFile.v3")));
        Logger.getGlobal().info("Data Export from Database to corona.data.v3 File successfully");
        Logger.getGlobal().info("All Operation Successfully Completed");



//

    }

}
