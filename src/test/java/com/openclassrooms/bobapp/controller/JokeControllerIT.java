package com.openclassrooms.bobapp.controller;


import com.openclassrooms.bobapp.BobappApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(classes = BobappApplication.class)
@AutoConfigureMockMvc
public class JokeControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRandomJokes_shouldReturn200AndJoke() throws Exception {
        // Effectue une requête HTTP GET vers /api/joke
        mockMvc.perform(get("/api/joke"))
                .andExpect(status().isOk())
                // Vérifie que la réponse contient une chaîne non vide (personnalise selon besoin)
                .andExpect(content().string(org.hamcrest.Matchers.not(org.hamcrest.Matchers.isEmptyString())));
    }
}
