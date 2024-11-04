package com.example.pokemonapp.api;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class PokemonService {
    private PokemonAPI pokemonAPI = new PokemonAPI();

    @WebMethod
    public String getPokemons(int offset, int limit) {
        try {
            return pokemonAPI.fetchPokemons(offset, limit);
        } catch (Exception e) {
            return "Error fetching data: " + e.getMessage();
        }
    }
}