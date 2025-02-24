```md
# 📌 Processo Seletivo - Simulador

Este projeto é um simulador de processo seletivo para candidatos a uma vaga de emprego. Ele permite selecionar candidatos com base em critérios pré-definidos, exibir os candidatos selecionados e realizar tentativas de contato com eles.

## 📌 Funcionalidades

✅ Selecionar candidatos com base em um critério de salário pretendido.
✅ Exibir a lista de candidatos selecionados.
✅ Realizar tentativas de contato com os candidatos selecionados.
✅ Encerrar a aplicação.

## 📂 Estrutura do Código

```
ProcessoSeletivo.java
```

## 🔹 Como Funciona

1. O usuário pode escolher entre diferentes opções no menu:
   - `1` - Selecionar candidatos automaticamente com base no salário pretendido.
   - `2` - Imprimir os candidatos selecionados.
   - `3` - Tentar entrar em contato com os candidatos.
   - `4` - Sair da aplicação.

2. O sistema seleciona até 5 candidatos aleatórios que tenham um salário pretendido menor ou igual ao salário base de `2000.0`.

3. Durante a tentativa de contato, o sistema simula chamadas com até 3 tentativas por candidato.

## 🛠 Como Executar o Programa

1. Clone este repositório:
   ```sh
   git clone https://github.com/italospina/Java-Projetos/tree/main/sitema-validacao-processo-seletivo
   ```

2. Compile o código:
   ```sh
   javac ProcessoSeletivo.java
   ```

3. Execute o programa:
   ```sh
   java ProcessoSeletivo
   ```

## 🔧 Tecnologias Utilizadas

- **Java** - Linguagem principal do projeto
- **Java Util Library** - Para manipulação de listas e geração de números aleatórios
- **Scanner** - Para entrada do usuário

## 📌 Exemplo de Saída no Terminal

```
-------------------------------------
---------Processo Seletivo-----------
-------------------------------------
Escolha uma opção:
1 - Selecionar candidatos
2 - Imprimir candidatos selecionados
3 - Entrar em contato com os candidatos
4 - Sair

Digite a opção: 1

Candidato: João
Salário pretendido: 1950.0
Candidato João foi selecionado

Contato realizado com João na tentativa número 2
```

## 🚀 Melhorias Futuras

- ✅ Implementação de um banco de dados para armazenar candidatos
- ✅ Interface gráfica para facilitar a interação do usuário
- ✅ Opção de cadastrar novos candidatos manualmente

## 📜 Licença

Este repositório está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
Criado por [Italo Spina](https://github.com/italospina).

