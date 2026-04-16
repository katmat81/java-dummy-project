package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceGeneratedAiTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Service service;

    @BeforeEach
    public void setUp() {
        service = new Service();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void highComplexityMethod_whenAllInputsArePositive_shouldPrintCorrectMessages() {
        // GIVEN
        int a = 1;
        int b = 2;
        int c = 3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        assertEquals("a is non-positive\nb is non-positive\nc is non-positive\n", outContent.toString());
    }

    @Test
    public void highComplexityMethod_whenAIsPositiveAndBIsPositiveAndCIsNonPositive_shouldPrintCorrectMessages() {
        // GIVEN
        int a = 1;
        int b = 2;
        int c = -3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        assertEquals("a is non-positive\nb is non-positive\nc is positive\n", outContent.toString());
    }

    @Test
    public void highComplexityMethod_whenAIsPositiveAndBAndCAreNonPositive_shouldPrintCorrectMessages() {
        // GIVEN
        int a = 1;
        int b = -2;
        int c = -3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        assertEquals("a is non-positive\nb is positive\nc is positive\n", outContent.toString());
    }

    @Test
    public void highComplexityMethod_whenAIsNegativeAndBIsPositiveAndCIsNonPositive_shouldPrintCorrectMessages() {
        // GIVEN
        int a = -1;
        int b = 2;
        int c = -3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        assertEquals("a is positive\nb is non-positive\nc is positive\n", outContent.toString());
    }

    @Test
    public void highComplexityMethod_whenAIsNegativeAndBAndCArePositive_shouldPrintCorrectMessages() {
        // GIVEN
        int a = -1;
        int b = 2;
        int c = 3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        assertEquals("a is positive\nb is non-positive\nc is non-positive\n", outContent.toString());
    }

    @Test
    public void highComplexityMethod_whenAIsNegativeAndBAndCAreNonPositive_shouldPrintCorrectMessages() {
        // GIVEN
        int a = -1;
        int b = -2;
        int c = -3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        assertEquals("a is positive\nb is positive\nc is positive\n", outContent.toString());
    }

    @Test
    public void highComplexityMethod_whenAIsZeroAndBAndCArePositive_shouldPrintCorrectMessages() {
        // GIVEN
        int a = 0;
        int b = 2;
        int c = 3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        assertEquals("a is positive\nb is non-positive\nc is non-positive\n", outContent.toString());
    }

    @Test
    public void highComplexityMethod_whenAIsZeroAndBIsZeroAndCIsPositive_shouldPrintCorrectMessages() {
        // GIVEN
        int a = 0;
        int b = 0;
        int c = 3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        assertEquals("a is positive\nb is positive\nc is non-positive\n", outContent.toString());
    }

    @Test
    public void highComplexityMethod_whenAllInputsAreZero_shouldPrintCorrectMessages() {
        // GIVEN
        int a = 0;
        int b = 0;
        int c = 0;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        assertEquals("a is positive\nb is positive\nc is positive\n", outContent.toString());
    }

    @Test
    public void isEven_whenNumberIsEven_shouldReturnTrue() {
        // GIVEN
        int number = 4;

        // WHEN
        boolean result = service.isEven(number);

        // THEN
        assertEquals(true, result);
    }

    @Test
    public void isEven_whenNumberIsOdd_shouldReturnFalse() {
        // GIVEN
        int number = 3;

        // WHEN
        boolean result = service.isEven(number);

        // THEN
        assertEquals(false, result);
    }
}
