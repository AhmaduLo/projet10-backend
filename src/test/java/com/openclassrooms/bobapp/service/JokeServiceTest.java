package com.openclassrooms.bobapp.service;

import com.openclassrooms.bobapp.data.JsonReader;
import com.openclassrooms.bobapp.model.Joke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class JokeServiceTest {

    private JsonReader jsonReaderMock;
    private JokeService jokeService;

    @BeforeEach
    void setUp() {
        // Création du mock de JsonReader
        jsonReaderMock = mock(JsonReader.class);

        // Création du JokeService avec le mock
        jokeService = new JokeService(jsonReaderMock);
    }

    @Test
    void getRandomJoke_shouldReturnJokeFromList() {
        // Arrange : liste simulée de blagues
        List<Joke> fakeJokes = List.of(
                new Joke("Pourquoi les devs aiment le café ?", "Parce que Java."),
                new Joke("Pourquoi React déprime ?", "Il perd son state.")
        );

        // On simule que JsonReader renvoie cette liste
        when(jsonReaderMock.getJokes()).thenReturn(fakeJokes);

        // Act : on appelle le service
        Joke result = jokeService.getRandomJoke();

        // Assert : on vérifie que la blague retournée est dans la liste simulée
        assertThat(result).isIn(fakeJokes);

        // Vérifie que jsonReader.getJokes() a bien été appelé
        verify(jsonReaderMock, times(1)).getJokes();
    }
}
