import com.sujit.service.CoronaPOJO;
import com.sujit.service.impl.CoronaInfoRandomDataGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CoronaInfoRandomDataGeneratorTest {
    List<CoronaPOJO> coronaPOJOList;
    CoronaInfoRandomDataGenerator dataGenerator;

    @BeforeEach
    public void setUP(){
        dataGenerator = new CoronaInfoRandomDataGenerator();
        coronaPOJOList = dataGenerator.generate();

    }


    @Test
    public void whenGeneratedCountryIdThenValueShouldLessThen250(){
        List<Integer> countryIdList  = coronaPOJOList.stream().map(coronaPOJO -> coronaPOJO.getCountryID()).filter(countryId -> countryId > 250).collect(Collectors.toList());
        assertFalse(countryIdList.size() > 0);

    }

    @Test
    public void whenGeneratedPositiveDataThenValueShouldLessThen99999999(){
        assertFalse( coronaPOJOList.stream().filter(coronaPOJO -> coronaPOJO.getPositive() > 99999999 ).count() > 0  );

    }
    @Test
    public void whenGeneratedNegativeDataThenValueShouldBeLessThen99999999() {
        assertFalse(coronaPOJOList.stream().filter(coronaPOJO -> coronaPOJO.getNegative() > 99999999 ).count() > 0);
    }

    @Test
    public void whenGeneratedRateShouldHaveFloatLessThen9999999() {
        List<Float> countryIdList  = coronaPOJOList.stream().map(coronaPOJO -> coronaPOJO.getRate()).filter(rate -> rate > 9999999 ).collect(Collectors.toList());
        assertFalse(countryIdList.size() > 0);

    }
    @Test
    public void whenGeneratedDateYearShouldEqualTo2020(){
       List<Date> testedDateList =  coronaPOJOList.stream().filter(coronaPOJO -> coronaPOJO.getDate()
               .before(Date.valueOf("2019-12-30")) || coronaPOJO.getDate().after(Date.valueOf("2020-12-30")))
                .map(coronaPOJO -> coronaPOJO.getDate()).collect(Collectors.toList());
       assertFalse(testedDateList.size() > 0);
    }

}