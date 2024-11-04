package com.example.pokemonapp.config;

import javax.xml.ws.Endpoint;
import com.example.pokemonapp.api.PokemonService;

public class WebServiceConfig {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/pokemonService", new PokemonService());
        System.out.println("Servicio SOAP corriendo en http://localhost:8080/pokemonService");
    }
}