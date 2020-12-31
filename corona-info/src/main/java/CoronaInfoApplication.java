import com.sujit.service.InfoTransferMediator;
import com.sujit.service.impl.CoronaInfoRandomDataGenerator;
import com.sujit.service.CoronaPOJO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class CoronaInfoApplication {

    private Properties properties;

    public Properties propertiesLoader(){
        properties = new Properties();
        try (InputStream input = new FileInputStream("." + File.separator + "corona-info"
                + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                + File.separator + "config.properties")) {
            // load a properties file
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;

    }

    public static void main(String[] args) throws Exception {
        InfoTransferMediator infoTransferMediator = new InfoTransferMediator();
        CoronaInfoApplication coronaInfoApplication = new CoronaInfoApplication();
        Properties properties = coronaInfoApplication.propertiesLoader();

        infoTransferMediator.exportToFile(new CoronaInfoRandomDataGenerator().generate(), new File(properties.getProperty("outputFile")));

        List<CoronaPOJO> testread =  infoTransferMediator.importFromFile(new File(properties.getProperty("outputFile")));

        infoTransferMediator.exportToFile(testread, new File(properties.getProperty("outputFile.v2")));

    }

}
