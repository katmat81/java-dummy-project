package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceGeneratedAiTests {

    private Service service;

    @Override
    void setUp() {
        service = new Service();
    }

    @Test
    void isEven_positiveEvenNumber_returnsTrue() {
        // GIVEN: A positive even number
        int input = 4;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be true
        assertTrue(result);
    }

    @Test
    void isEven_positiveOddNumber_returnsFalse() {
        // GIVEN: A positive odd number
        int input = 5;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be false
        assertFalse(result);
    }

    @Test
    void isEven_zero_returnsTrue() {
        // GIVEN: Zero
        int input = 0;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be true
        assertTrue(result);
    }

    @Test
    void isEven_negativeEvenNumber_returnsTrue() {
        // GIVEN: A negative even number
        int input = -4;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be true
        assertTrue(result);
    }

    @Test
    void isEven_negativeOddNumber_returnsFalse() {
        // GIVEN: A negative odd number
        int input = -5;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be false
        assertFalse(result);
    }

    @Test
    void isEven_negativeZero_returnsTrue() {
        // GIVEN: Negative zero
        int input = 0;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be true
        assertTrue(result);
    }

    @Test
    void isEven_largeNumber_returnsTrue() {
        // GIVEN: A large even number
        int input = 1000000;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be true
        assertTrue(result);
    }

    @Test
    void isEven_largeOddNumber_returnsFalse() {
        // GIVEN: A large odd number
        int input = 1000001;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be false
        assertFalse(result);
    }

    @Test
    void isEven_negativeLargeNumber_returnsTrue() {
        // GIVEN: A negative large even number
        int input = -1000000;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be true
        assertTrue(result);
    }

    @Test
    void isEven_negativeLargeOddNumber_returnsFalse() {
        // GIVEN: A negative large odd number
        int input = -1000001;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be false
        assertFalse(result);
    }
}
