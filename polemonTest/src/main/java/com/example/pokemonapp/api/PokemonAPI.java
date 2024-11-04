package com.example.pokemonapp.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PokemonAPI {
    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon?offset=%d&limit=%d";

    public String fetchPokemons(int offset, int limit) throws Exception {
        URL url = new URL(String.format(API_URL, offset, limit));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}