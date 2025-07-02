package com.openclassrooms.bobapp.data;


import com.openclassrooms.bobapp.model.Joke;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JsonReaderIT {

    @Autowired
    private JsonReader jsonReader;

    @Test
    void jsonReaderBean_shouldLoadAndReturnJokes() {
        List<Joke> jokes = jsonReader.getJokes();

        assertThat(jokes).isNotEmpty();

        Joke joke = jokes.get(0);
        assertThat(joke.getJoke()).isNotBlank();
        assertThat(joke.getResponse()).isNotBlank();
    }
}
