package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClientTests {

    private Client client;
    private Service serviceMock;

    @BeforeEach
    void setUp() {
        serviceMock = mock(Service.class);
        client = new Client(serviceMock);
    }

    @Test
    void greeting_withEvenLengthName_returnsToUpperCase() {
        // GIVEN: Setup the mock service to return true for isEven(8)
        when(serviceMock.isEven(8)).thenReturn(true);

        // GIVEN: Setup the input name
        String name = "test";

        // WHEN: Call the greeting method
        String result = client.greeting(name);

        // THEN: Assert that the result is "HELLO, TEST"
        Assertions.assertThat(result).isEqualTo("HELLO, TEST");
    }

    @Test
    void greeting_withOddLengthName_returnsAsIs() {
        // GIVEN: Setup the mock service to return false for isEven(5)
        when(serviceMock.isEven(5)).thenReturn(false);

        // GIVEN: Setup the input name
        String name = "test";

        // WHEN: Call the greeting method
        String result = client.greeting(name);

        // THEN: Assert that the result is "Hello, test"
        Assertions.assertThat(result).isEqualTo("Hello, test");
    }

    @Test
    void greeting_withNullName_throwsIllegalArgumentException() {
        // GIVEN: Setup the mock service
        when(serviceMock.isEven(0)).thenReturn(true);

        // WHEN: Call the greeting method with a null name
        Assertions.assertThatThrownBy(() -> client.greeting(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("name must not be null or empty");
    }

    @Test
    void greeting_withEmptyName_throwsIllegalArgumentException() {
        // GIVEN: Setup the mock service
        when(serviceMock.isEven(0)).thenReturn(true);

        // WHEN: Call the greeting method with an empty name
        Assertions.assertThatThrownBy(() -> client.greeting(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("name must not be null or empty");
    }
}
