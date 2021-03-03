package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionsTest {
    @ParameterizedTest(name = ("Run:{index} - value:{arguments}"))
    @ValueSource(ints = {1,4,5})

        // Assumption with no message
    void intsValue(int theParam){
        assumeTrue(theParam>=4);
        System.out.println("theParam = " + theParam);

    }
    @ParameterizedTest
    @CsvSource(value = {"steve,rogers","captain,marvel","captain,jack"})
    // Assumption with a message to display
    void csvSource_stringString(String param1, String param2){
        assumeFalse(param1.equals("steve"), "The assumption failed for the " +
                "following param2: " + param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);

    }
    @ParameterizedTest
    @CsvSource(value = {"steve,32,true","tamer,38,false","liran,47,true"})
    void csvSource_StringIntBoolean(String param1 ,int param2, boolean param3 ){
        assumingThat(param2 > 20, () -> System.out.println("This code ran"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);

    }
}
