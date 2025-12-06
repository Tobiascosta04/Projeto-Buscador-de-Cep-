# 📦 Consulta de Endereços via CEP (API ViaCEP)
Este projeto implementa uma aplicação Java que consulta endereços utilizando a API pública ViaCEP, converte o JSON retornado em um objeto Java utilizando Gson, e salva os dados em um arquivo .json com o nome do CEP informado.

O projeto demonstra:

Programação orientada a objetos (POO)

Consumo de API HTTP com HttpClient

Tratamento de exceções, incluindo exceções personalizadas

Serialização JSON com Gson

Organização em pacotes

Boas práticas de modularização

## 🚀 Funcionalidades
✔ Solicita ao usuário um CEP (somente números)

✔ Valida o formato do CEP

✔ Consulta a API ViaCEP

✔ Converte o JSON da resposta em um objeto Endereco

✔ Detecta CEP inexistente

✔ Salva o endereço em um arquivo JSON formatado

✔ Nome do arquivo segue o padrão:

<cep>.json

✔ Trata erros como:

CEP inválido

CEP inexistente

Falha na requisição

Erros inesperados

## 📁 Estrutura do Projeto
src/

 ├── br/com/app/cep/Main.java
 
 ├── br/com/app/cep/model/Endereco.java
 
 ├── br/com/app/cep/service/ConsultaCep.java
 
 ├── br/com/app/cep/service/GeradorDeArquivo.java
 
 ├── br/com/app/cep/exception/CepInvalidoException.java
 
 ├── br/com/app/cep/exception/CepNaoEncontradoException.java

## 🧩 Classes Principais

🔹 Endereco

Classe que representa um endereço retornado pela API.

Atributos:

cep

uf

localidade

bairro

logradouro

complemento

🔹 ConsultaCep

Responsável por:

Validar o CEP

Enviar requisições HTTP para a ViaCEP

Converter JSON → objeto Endereco

Disparar exceções personalizadas

🔹 GeradorDeArquivo

Responsável por:

Converter o objeto Endereco em JSON

Salvar em arquivo com GsonBuilder().setPrettyPrinting()

🔹 Exceções personalizadas

CepInvalidoException

CepNaoEncontradoException

🔹 Main

Fluxo principal:

Lê o CEP

Realiza a consulta

Exibe o endereço

Salva o JSON no disco

## 🔧 Tecnologias Utilizadas

Java 17+

Gson para serialização/deserialização de JSON

HttpClient (Java 11+) para chamadas HTTP

API ViaCEP: https://viacep.com.br/

## ⚠ Tratamento de erros

O programa trata:

❌ CEP fora do padrão → CepInvalidoException

❌ CEP inexistente → CepNaoEncontradoException

❌ Falhas de rede → IOException

❌ Erros inesperados → Exception geral

## 🤝 Créditos

Este projeto foi desenvolvido com forte apoio dos cursos da Alura, que forneceram a base conceitual e prática para:

Consumo de APIs

JSON com Gson

POO em Java

Boas práticas de organização

Além disso, houve reforço e complementação com auxílio de ferramentas de IA (ChatGPT) para otimização, explicações e documentação.

## 📄 Licença

Projeto livre para uso educacional e pessoal.
