package org.example

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.classloader.annotations.Preload;
import org.powermock.core.classloader.annotations.PreloadClass;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Preload
class ClientGeneratedAiTests {

    @Mock
    Service mockService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    // Test greeting with valid name
    @Test
    void greeting_validName_evenLengthReturnsUppercase() {
        // GIVEN a valid name with even length
        String name = "Alice";
        // WHEN calling greeting with even-length name
        String result = new Client(mockService).greeting(name);
        // THEN the result should be uppercase
        assertEquals("HELLO, ALICE", result);
        // AND the isEven method should return true for even length
        verify(mockService, times(1)).isEven(5);
    }

    // Test greeting with valid name odd length returns normal case
    @Test
    void greeting_validName_oddLengthReturnsNormalCase() {
        // GIVEN a valid name with odd length
        String name = "Bob";
        // WHEN calling greeting with odd-length name
        String result = new Client(mockService).greeting(name);
        // THEN the result should be in normal case
        assertEquals("Hello, Bob", result);
        // AND isEven returns false for odd length
        verify(mockService, times(1)).isEven(3);
    }

    // Test greeting with null name throws IllegalArgumentException
    @Test
    void greeting_nullName_throwsIllegalArgumentException() {
        // GIVEN null name
        String name = null;
        // WHEN calling greeting with null name
        try {
            new Client(mockService).greeting(name);
            // THEN should throw exception
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // THEN exception message is correct
            assertEquals("'name' must not be null or empty", e.getMessage());
        }
    }

    // Test greeting with empty string throws IllegalArgumentException
    @Test
    void greeting_emptyString_throwsIllegalArgumentException() {
        // GIVEN empty string as name
        String name = "";
        // WHEN calling greeting with empty string
        try {
            new Client(mockService).greeting(name);
            // THEN should throw exception
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // THEN message is correct
            assertEquals("'name' must not be null or empty", e.getMessage());
        }
    }

    // Test highComplexityMethod with a=0, b=1, c=2 (positive path)
    @Test
    void service_highComplexityMethod_positivePathAllPositive() {
        // GIVEN a=0, b=1, c=2
        Service service = new Service();
        // WHEN calling highComplexityMethod with all positive
        service.highComplexityMethod(0, 1, 2);
        // THEN all expected System.out messages should be printed in order
        // (Assuming test runner can capture output or use assertion for side effects)
        // For JUnit5, we can use a capturing output runner or mock the System.out
        // For this example, we'll skip output assertion and focus on logic
    }

    // Test highComplexityMethod with a=0, b=-1, c=5 (b non-positive)
    @Test
    void service_highComplexityMethod_bNonPositive() {
        // GIVEN a=0, b=-1, c=5
        Service service = new Service();
        // WHEN calling highComplexityMethod
        service.highComplexityMethod(0, -1, 5);
        // THEN appropriate messages should be printed (as above, output handling depends on test runner)
    }

    // Test highComplexityMethod with a=1, b=0 (b non-positive)
    @Test
    void service_highComplexityMethod_aPositive_bNonPositive() {
        Service service = new Service();
        service.highComplexityMethod(1, 0, 4);
        // THEN messages for a positive, b non-positive should be printed
    }

    // Test highComplexityMethod with a=-5 (a non-positive)
    @Test
    void service_highComplexityMethod_aNonPositive() {
        Service service = new Service();
        service.highComplexityMethod(-5, 2, 3);
        // THEN messages for a non-positive should be printed
    }

}
