package com.openclassrooms.bobapp.data;

import com.openclassrooms.bobapp.model.Joke;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonReaderTest {

    @Test
    void getJokes_shouldReturnListOfJokes() {
        // Récupère l'instance singleton
        JsonReader jsonReader = JsonReader.getInstance();

        // Appel de la méthode
        List<Joke> jokes = jsonReader.getJokes();

        // Vérifie que la liste n'est pas vide
        assertThat(jokes).isNotEmpty();

        // Vérifie que chaque blague contient bien du texte
        Joke joke = jokes.get(0);
        assertThat(joke.getJoke()).isNotBlank();
        assertThat(joke.getResponse()).isNotBlank();
    }
}
