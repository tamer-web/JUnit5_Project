package junit5tests;

import org.junit.jupiter.api.*;
// To run method test in alphanumerically order

@TestMethodOrder(MethodOrderer.MethodName.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass1 {

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
    void firstMethod(){
        System.out.println("This is the first simple test");
    }

    @Test
    @DisplayName("US1234-TC12-THIS IS THE SECOND METHOD ")
    void secondMethod(){
        System.out.println("This is the second simple test");
    }

    @Test
    @DisplayName("A Display name ")
    void thirdTest() {
        System.out.println("This is the third test method");
    }
}
