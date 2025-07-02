package com.openclassrooms.bobapp.controller;


import com.openclassrooms.bobapp.model.Joke;
import com.openclassrooms.bobapp.service.JokeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class JokeControllerTestUnitaire {

    private JokeService jokeService;
    private JokeController jokeController;


    @BeforeEach
    void setUp() {
        jokeService = mock(JokeService.class);
        jokeController = new JokeController(jokeService);
    }

    @Test
    void getRandomJokes_shouldReturnJokeFromService() {
        // Arrange : création d'une blague simulée
        Joke expectedJoke = new Joke("Pourquoi les devs détestent la plage ?", "Trop de bugs !");
        when(jokeService.getRandomJoke()).thenReturn(expectedJoke);

        // Act : appel du contrôleur
        ResponseEntity<?> response = jokeController.getRandomJokes();

        // Assert : vérifie que la réponse est correcte
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isInstanceOf(Joke.class);

        Joke returnedJoke = (Joke) response.getBody();
        assertThat(returnedJoke.getJoke()).isEqualTo("Pourquoi les devs détestent la plage ?");
        assertThat(returnedJoke.getResponse()).isEqualTo("Trop de bugs !");

        // Vérifie que le service a bien été appelé
        verify(jokeService, times(1)).getRandomJoke();
    }
}
