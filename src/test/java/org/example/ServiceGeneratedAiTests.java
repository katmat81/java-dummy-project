package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.List;

public class ServiceGeneratedAiTests {

    private Service service;

    @BeforeEach
    public void setUp() {
        service = new Service();
    }

    @Test
    public void testProcessData_WithValidInput_ReturnsProcessedData() {
        // GIVEN
        String input = "test input";

        // WHEN
        String result = service.processData(input);

        // THEN
        Assertions.assertNotNull(result);
    }

    @Test
    public void testProcessData_WithEmptyInput_ThrowsIllegalArgumentException() {
        // GIVEN
        String input = "";

        // WHEN & THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.processData(input);
        });
    }

    @Test
    public void testGetItems_WithValidInput_ReturnsListOfItems() {
        // GIVEN
        String input = "test";

        // WHEN
        List<String> result = service.getItems(input);

        // THEN
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testCalculateSum_WithValidInput_ReturnsCorrectSum() {
        // GIVEN
        List<Integer> numbers = List.of(1, 2, 3);

        // WHEN
        int result = service.calculateSum(numbers);

        // THEN
        Assertions.assertEquals(6, result);
    }

    @Test
    public void testCalculateSum_WithEmptyList_ReturnsZero() {
        // GIVEN
        List<Integer> numbers = List.of();

        // WHEN
        int result = service.calculateSum(numbers);

        // THEN
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testValidateInput_WithValidInput_ReturnsTrue() {
        // GIVEN
        String input = "valid";

        // WHEN
        boolean result = service.validateInput(input);

        // THEN
        Assertions.assertTrue(result);
    }

    @Test
    public void testValidateInput_WithEmptyInput_ReturnsFalse() {
        // GIVEN
        String input = "";

        // WHEN
        boolean result = service.validateInput(input);

        // THEN
        Assertions.assertFalse(result);
    }
}
