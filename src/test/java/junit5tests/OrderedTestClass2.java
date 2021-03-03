package junit5tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass2 {

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
    @Order(2)
    void firstMethod(){
        System.out.println("This is the first simple test");
    }

    @Test
    @DisplayName("US1234-TC12-THIS IS THE SECOND METHOD ")
    @Order(3)
    void secondMethod(){
        System.out.println("This is the second simple test");
    }

    @Test
    @Order(1)
    void thirdTest() {
        System.out.println("This is the third test method");
    }
}
