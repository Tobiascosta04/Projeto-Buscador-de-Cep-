package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Endereco;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void salvarJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String nomeArquivo = endereco.getCep() + ".json";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))){
            writer.write(gson.toJson(endereco));
            System.out.println("Arquivo gerado: " + nomeArquivo);
        } catch (IOException e){
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
        }

    }
}
