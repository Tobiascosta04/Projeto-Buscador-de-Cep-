import exceptions.CepInvalidoException;
import exceptions.CepNaoEncontradoException;
import model.Endereco;
import service.ConsultarCep;
import service.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ConsultarCep consultarCep = new ConsultarCep();

        System.out.print("Digite um número de CEP para consulta: ");
        String cep = reader.nextLine();
        try {
            Endereco novoEndereco = consultarCep.buscar(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvarJson(novoEndereco);
        } catch (CepNaoEncontradoException | CepInvalidoException | IOException e){
            System.err.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}