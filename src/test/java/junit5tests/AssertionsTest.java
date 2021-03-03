package junit5tests;

import Listeners.Listener;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)
public class AssertionsTest {

    @Test
    void assertEqualsTest() {
        assertEquals("firstString", "firstString", "The String " +
                "values were not equal");
    }
    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("firstString",
                "secondString", "thirdString");
        List<String> actualValues = Arrays.asList("firstString",
                "secondString","thirdString");
        assertEquals(expectedValues, actualValues);
    }
    @Test
    void assertTrueTest() {
        assertFalse(false);
        assertTrue(true, "This boolean condition did not evaluate to true");
    }
    @Test
    void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }
    @Test
    void assertAllTest() {
        //noinspection TestFailedLine
        assertAll(
                () ->  assertEquals("firstString", "firstString", "The String " +
                        "values were not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> fail("This boolean condition did not evaluate to true"));
    }

    //Hamcrest Library
    @Test
    void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, hasKey("secondKey"));
        assertThat(theMap, hasValue(1));
    }
    @Test
    void assertForList() {
        List<String> theList = Arrays.asList("firstString", "secondString",
                "thirdString");

        assertThat(theList, hasItem("thirdString"));
    }

    @Test
    void assertForAnyOf() {
        List<String> theList = Arrays.asList("firstString", "secondString",
                "thirdString");

        assertThat(theList,
                anyOf(hasItem("thirdString"), hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder() {
        List<String> theList = Arrays.asList("firstString", "secondString",
                "thirdString");

        assertThat(theList, containsInAnyOrder("firstString",
                "thirdString", "secondString"));
    }

}
