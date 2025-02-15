# 📌 Projeto: Sistema de Conta Bancária - Terminal Interativo  

Este projeto consiste em um **sistema de conta bancária simples**, desenvolvido em **Java**, que permite ao usuário inserir suas informações bancárias e visualizar os dados formatados corretamente. A aplicação simula a criação de uma conta bancária, coletando **nome do cliente, número da agência e número da conta**, e exibindo um resumo das informações ao final.  

## 🎯 Objetivo  
O objetivo deste projeto é praticar conceitos fundamentais de **Programação Orientada a Objetos (POO) em Java**, incluindo:  
📌 **Manipulação de classes e objetos** | 
📌 **Encapsulamento com métodos `get` e `set`** | 
📌 **Uso do `Scanner` para entrada de dados** | 
📌 **Validação de formato de entrada (exemplo: agência no formato XXX-X)** | 
📌 **Formatação de saída com `String.format()`**  

## 🚀 Funcionalidades  
✅ Entrada de dados do usuário: Nome do cliente, número da agência (com validação do formato "XXX-X") e número da conta. ✅ **Validação da Agência**: O sistema verifica se a entrada segue o formato correto ("XXX-X") e exibe um erro caso contrário. ✅ **Exibição dos Dados**: No final, o sistema imprime um resumo da conta bancária do usuário com nome, agência, número da conta e saldo inicial fixo de **R$ 1526,33**.  

## 💻 Tecnologias Utilizadas  
🔹 **Java SE 8+** | 
🔹 **Scanner para entrada de dados** | 
🔹 **Programação Orientada a Objetos (POO)** | 
🔹 **Expressões regulares para validação de entrada**  

## 📂 Estrutura do Projeto  
📦 **ContaBancaria** →  📜 `ContaTerminal.java` (Classe principal que interage com o usuário) | 
                        📜 `ContaBanco.java` (Classe que armazena os dados da conta e validações) | 
                        📜 `README.md` (Documentação do projeto)  

## ▶️ Como Executar o Projeto  
1️⃣ **Clone o repositório:** `git clone https://github.com/italospina/Java-Projetos/tree/main/conta-banco` | 
2️⃣ **Acesse a pasta do projeto:** `cd ContaBancaria` | 
3️⃣ **Compile os arquivos Java:** `javac ContaTerminal.java ContaBanco.java` | 
4️⃣ **Execute o programa:** `java ContaTerminal`  

## 🔄 Exemplo de Entrada e Saída  
Digite seu nome:
João Silva

Digite sua agência (formato XXX-X):
123-4

Digite seu número de conta:
56789


## 📌 Possíveis Melhorias Futuras  
🔄 Implementação de operações bancárias como **saque, depósito e transferência** | 🔄 Armazenamento de dados usando **arquivos ou banco de dados** | 🔄 Interface gráfica para melhor experiência do usuário  

## 📜 Licença  
Este projeto está sob a licença MIT - sinta-se livre para modificá-lo e distribuí-lo. 📌 **Desenvolvido por [Italo Spina](https://github.com/italospina)** 🚀  

