import com.sujit.service.CoronaPOJO;
import com.sujit.service.InfoTransferMediator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfoTransferMediatorTest {
    InfoTransferMediator infoTransferMediator;
    List<CoronaPOJO> coronaPOJOList;
    File file;

    @BeforeEach
    public void setUp() {
        infoTransferMediator = new InfoTransferMediator();
        coronaPOJOList = new ArrayList<>(10);
        file = new File("./testExportedfile");
        //adding ome data
        coronaPOJOList.add(new CoronaPOJO(123,45876,97562, 7895.0F, Date.valueOf("2020-05-27")));
        coronaPOJOList.add(new CoronaPOJO(125,92876,347258, 36489.0F, Date.valueOf("2020-12-08")));
        coronaPOJOList.add(new CoronaPOJO(72,648925,94357,2135.2F,Date.valueOf("2020-10-19")));
    }

    @AfterEach
    public void destroy() {
        infoTransferMediator = null;
        coronaPOJOList = null;
        file.delete();
    }

    @Test
    public void givenListOfTypeContainingOnlyOneElement_WhenExported_ShouldWriteAllContentOnGivenFile() throws IOException {
        coronaPOJOList.add(new CoronaPOJO(123,45876,97562, 7895.0F, Date.valueOf("2020-05-27")));
        //coronaPOJOList.add(new CoronaPOJO(125,92876,347258, 36489.0F, Date.valueOf("2020-12-08")));

        infoTransferMediator.exportToFile(coronaPOJOList, file);
        String actual  = new BufferedReader(new FileReader(file)).readLine();
        assertEquals(coronaPOJOList.get(0).toString(), actual);

    }

    @Test
    public void givenListOfTypeWithMultipleElements_WhenExported_ShouldWriteAllContentOnGivenFile() throws IOException {

        infoTransferMediator.exportToFile(coronaPOJOList, file);
        BufferedReader br  = new BufferedReader(new FileReader(file));
        int i = 0;
        String actual = br.readLine();
        while (actual !=null){
            assertEquals(coronaPOJOList.get(i).toString(), actual );
            actual = br.readLine();
            i++;
        }
    }
//    @Test
//    public void givenTheFileName_ShouldReadFileContent_AndReturnListOfCoronaPOJO() throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
//        for (CoronaPOJO coronaPOJO: coronaPOJOList ) {
//            bw.write(coronaPOJO.toString());
//            bw.newLine();
//        }
//
//        assertEquals(coronaPOJOList, infoTransferMediator.importFromFile(file) );
//
//
//    }


}