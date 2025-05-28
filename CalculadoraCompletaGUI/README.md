# 📟 Calculadora com Interface Gráfica em Java

Este projeto implementa uma calculadora completa com interface gráfica (GUI) utilizando Java Swing. A aplicação permite realizar operações matemáticas básicas, visualizar um histórico de cálculos e modificar o tema (modo claro/escuro) e fonte da interface. A estrutura segue os princípios da Programação Orientada a Objetos (POO), com separação entre a lógica de negócio e a interface.

---

## 🎯 Objetivo

Este projeto tem como propósito aplicar conceitos de Java, POO, tratamento de eventos com `ActionListener` e `KeyListener`, além de recursos de GUI como `JFrame`, `JPanel`, `JButton`, `JTextField` e `JTextArea`.

---

## 🚀 Funcionalidades

* ✅ Realiza as operações básicas: `+`, `-`, `*`, `/`, `%`
* ✅ Teclado funcional para digitação dos números e operações
* ✅ Botões arredondados com layout responsivo (GridBagLayout)
* ✅ Caixa de histórico com as operações realizadas
* ✅ Botões `C` (limpar) e `CE` (apagar um caractere)
* ✅ Suporte a modo escuro e claro via menu suspenso
* ✅ Permite alterar tipo e tamanho da fonte via menu suspenso

---

## 💻 Tecnologias Utilizadas

* 🔹 Java SE 8+
* 🔹 Java Swing (interface gráfica)
* 🔹 Programação Orientada a Objetos (POO)

---

## 📂 Estrutura do Projeto

```
📦 CalculadoraJava
├── 📜 TelaCalculadora.java      -> Interface principal com Swing
├── 📜 ServicosDaCalculadora.java -> Classe com lógica das operações matemáticas
├── 📜 Main.java                 -> Ponto de entrada da aplicação
├── 📜 README.md                 -> Documentação do projeto
```

---

## ▶️ Como Executar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/italospina/Java-Projetos.git
```

2. Acesse a pasta do projeto:

```bash
cd Java-Projetos/CalculadoraJava
```

3. Compile os arquivos Java:

```bash
javac TelaCalculadora.java ServicosDaCalculadora.java Main.java
```

4. Execute o programa:

```bash
java Main
```

---

## 🔄 Exemplo de Saída Visual

* Interface moderna com botões arredondados
* Histórico exibido acima do campo de resultado
* Mudança de tema em tempo real
* Funcionalidades acessíveis tanto por mouse quanto teclado

---

## 📌 Melhorias Futuras

* 🔄 Implementar teclas de atalho com Ctrl, Shift, etc.
* 🔄 Exportar histórico de cálculos em arquivo .txt ou .csv
* 🔄 Implementar suporte a expressões compostas (ex: `1 + 2 * 3`)
* 🔄 Adicionar interface responsiva com JavaFX

---

## 📜 Licença

Este projeto está sob a licença MIT - sinta-se à vontade para modificar e distribuir.

---

## 👨‍💻 Desenvolvido por

**[Italo Spina](https://github.com/italospina)** 🚀
