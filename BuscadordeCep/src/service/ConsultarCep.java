package service;

import com.google.gson.Gson;
import exceptions.CepInvalidoException;
import exceptions.CepNaoEncontradoException;
import model.Endereco;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarCep {
    public Endereco buscar(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            if (json.contains("\"erro\": true")) {
                throw new CepNaoEncontradoException(cep);
            } else if(!cep.matches("\\d{8}")){
                throw new CepInvalidoException("Cep deve conter 8 digitos numericos.");
            }


            Gson gson = new Gson();
            return gson.fromJson(json, Endereco.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
