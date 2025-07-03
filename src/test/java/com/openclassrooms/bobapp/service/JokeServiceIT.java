package com.openclassrooms.bobapp.service;

import com.openclassrooms.bobapp.model.Joke;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JokeServiceIT {

    @Autowired
    private JokeService jokeService;

    @Test
    void getRandomJoke_shouldReturnValidJoke() {
        // Act
        Joke result = jokeService.getRandomJoke();

        // Assert.
        assertThat(result).isNotNull();
        assertThat(result.getJoke()).isNotBlank();
        assertThat(result.getResponse()).isNotBlank();
    }
}
