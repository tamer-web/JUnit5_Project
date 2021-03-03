package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTestClass {

    //Setup methods
    @BeforeAll
    void beforeAll(){System.out.println("--This is the BeforeAll method--");}
    @BeforeEach
    void beforeEach(){System.out.println("--This is the BeforeEach method ");}

    //Cleanup methods
    @AfterAll
    void afterAll(){System.out.println("--This is the AfterAll method--");}
    @AfterEach
    void afterEach(){System.out.println("--This is the AfterEach method");}

    // Simple test Method
    @Test
    @Tag("sanity")
    void firstMethod(){
        System.out.println("This is the first simple test");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("US1234-TC12-THIS IS THE SECOND METHOD ")
    void secondMethod(){
        System.out.println("This is the second simple test");
    }

    @Test
    @Tag("acceptance")
    void thirdMethod(){
        System.out.println("This is the third simple test");

    }

    // one parameter value method
    @Tag("acceptance")
    @ParameterizedTest(name = ("Run:{index} - value:{arguments}"))
    @ValueSource(ints = {1,4,5})
    void intsValue(int theParam){
        System.out.println("theParam = " + theParam);

    }
}
