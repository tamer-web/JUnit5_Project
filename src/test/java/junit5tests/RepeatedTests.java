package junit5tests;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class RepeatedTests {

    @RepeatedTest(5)
    void firstRepeatedMethod() {
        System.out.println("We are repeating this test");
    }

    //Repeated Method to show our defined custom name in the console
    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}." +
            " Total is: {totalRepetitions}")
    void secondRepeatedMethod() {
        System.out.println("We are repeating a new test");
    }
    @RepeatedTest(3)
    void thirdRepeatedMethod(RepetitionInfo repetitionInfo) {
        System.out.println("This code will run at each repetition");
        assumingThat(repetitionInfo.getCurrentRepetition() == 3,
                () -> System.out.println("This code only runs for repetition " +
                        "3"));
    }
}

