package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

    // one parameter value method
    @ParameterizedTest(name = ("Run:{index} - value:{arguments}"))
    @ValueSource(ints = {1,4,5})
    void intsValue(int theParam){
        System.out.println("theParam = " + theParam);

    }
    // one parameter value method
    @ParameterizedTest(name=("Run:{index} - value:{arguments}"))
    @NullSource  // to pass in Null string only used when we have only one parameter "theParam"
    @EmptySource // to pass in empty string
    @ValueSource(strings={"firstString","secondString"})

    void stringValues(String theParam){
        System.out.println("theParam = " + theParam);
    }
    // Two parameter value method
    @ParameterizedTest
    @CsvSource(value = {"steve,rogers","captain,marvel","captain,jack"})

    void csvSource_stringString(String param1, String param2){

        System.out.println("param1 = " + param1 + ", param2 = " + param2);

    }

    // several parameterized method
    @ParameterizedTest
    @CsvSource(value = {"steve,32,true","tamer,38,false","liran,47,true"})
    void csvSource_StringIntBoolean(String param1 ,int param2, boolean param3 ){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);

    }
    @ParameterizedTest
    @CsvSource(value = {"captain america,'steve,rogers'", "winter soldier,'bucky,barnes'"})
    void csvSource_StringWithComma(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    void csvSource_StringWithDiffDelimiter(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    // reading values from a csv file with default delimiter and two files
    @ParameterizedTest
    @CsvFileSource(files ={"src/test/resources/params/shoppinglist.csv","src/test/resources/params/shoppinglist2.csv"},numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString (String name,Double price,int qty,String uom ,String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);

    }
    // reading values from a csv file with specified delimiter and one files
    @ParameterizedTest
    @CsvFileSource(files ="src/test/resources/params/shoppinglist3.csv",numLinesToSkip = 1,delimiterString = "__")
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter (String name,Double price,int qty,String uom ,String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);

    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1) {
        System.out.println("param1 = " + param1);

    }
    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StringStream(String param1) {
        System.out.println("param1 = " + param1);
    }
    // This kind of methods should be static if are used in a different class
    List<String> sourceString()  {
        //processing done here
        return Arrays.asList("tomato", "carrot", "cabbage");
    }
    Stream<String> sourceStringAsStream() {
        //processing
        return Stream.of("beetroot", "apple", "pear");
    }
   // More than one argument method

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }


    List<Arguments> sourceList_StringDouble() {
        //processing
        return Arrays.asList(arguments("tomato", 2.0),
                arguments("carrot", 4.5), arguments(
                        "cabbage", 7.8));
    }


}
