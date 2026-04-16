package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ClientGeneratedAiTests {

    private Service mockService;
    private Client client;

    @BeforeEach
    void setUp() {
        mockService = mock(Service.class);
        client = new Client(mockService);
    }

    @Test
    void greeting_whenNameIsValidAndLengthIsEven_shouldReturnUppercaseGreeting() {
        // GIVEN
        String name = "Alice";
        when(mockService.isEven(name.length())).thenReturn(true);

        // WHEN
        String result = client.greeting(name);

        // THEN
        assertThat(result).isEqualTo("HELLO, ALICE");
        verify(mockService).isEven(name.length());
    }

    @Test
    void greeting_whenNameIsValidAndLengthIsOdd_shouldReturnNormalGreeting() {
        // GIVEN
        String name = "Bob";
        when(mockService.isEven(name.length())).thenReturn(false);

        // WHEN
        String result = client.greeting(name);

        // THEN
        assertThat(result).isEqualTo("Hello, Bob");
        verify(mockService).isEven(name.length());
    }

    @Test
    void greeting_whenNameIsNull_shouldThrowIllegalArgumentException() {
        // GIVEN
        String name = null;

        // WHEN & THEN
        assertThatThrownBy(() -> client.greeting(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("'name' must not be null or empty");
    }

    @Test
    void greeting_whenNameIsBlank_shouldThrowIllegalArgumentException() {
        // GIVEN
        String name = "   ";

        // WHEN & THEN
        assertThatThrownBy(() -> client.greeting(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("'name' must not be null or empty");
    }

    @Test
    void greeting_whenNameIsEmpty_shouldThrowIllegalArgumentException() {
        // GIVEN
        String name = "";

        // WHEN & THEN
        assertThatThrownBy(() -> client.greeting(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("'name' must not be null or empty");
    }
}
