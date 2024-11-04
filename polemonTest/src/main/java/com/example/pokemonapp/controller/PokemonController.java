package com.example.pokemonapp.controller;

import com.example.pokemonapp.api.PokemonAPI;
import com.example.pokemonapp.api.PokemonDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PokemonController {
    private final PokemonAPI pokemonAPI;

    public PokemonController() {
        this.pokemonAPI = new PokemonAPI();
    }

    public List<PokemonDTO> getPokemons(int offset, int limit) throws Exception {
        String jsonResponse = pokemonAPI.fetchPokemons(offset, limit);
        return parsePokemons(jsonResponse);
    }

    private List<PokemonDTO> parsePokemons(String jsonResponse) {
        List<PokemonDTO> pokemons = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray results = jsonObject.getJSONArray("results");

        for (int i = 0; i < results.length(); i++) {
            JSONObject pokemon = results.getJSONObject(i);
            String name = pokemon.getString("name");
            String url = pokemon.getString("url");
            pokemons.add(new PokemonDTO(name, url));
        }
        return pokemons;
    }
}