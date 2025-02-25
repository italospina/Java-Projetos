```md
# 🚀 Desafio Controle de Fluxo

Este projeto, **DesafioControleFluxo**, é um exercício prático para manipulação de exceções e controle de fluxo em Java. O objetivo é solicitar dois números ao usuário e exibir uma sequência numérica entre eles. Caso o primeiro número seja maior que o segundo, uma exceção personalizada será lançada.

## 📂 Estrutura do Projeto

```
DesafioControleFluxo/
│── src/
│   ├── Contador.java
│   ├── ParametrosInvalidosException.java
│── README.md
```

## 📌 Funcionalidades

✅ Solicita dois números ao usuário.
✅ Exibe a sequência numérica entre os dois números informados.
✅ Lança uma exceção personalizada caso o primeiro número seja maior que o segundo.

## 🔹 Como Funciona

1. O usuário insere dois números.
2. Se o primeiro número for **menor ou igual** ao segundo, o programa exibe todos os números no intervalo.
3. Se o primeiro número for **maior** que o segundo, uma exceção `ParametrosInvalidosException` é lançada e tratada.

## 🛠 Como Executar o Programa

1. Clone este repositório:
   ```sh
   git clone https://github.com/italospina/Java-Projetos.git
   ```

2. Navegue até a pasta do projeto:
   ```sh
   cd Java-Projetos/DesafioControleFluxo
   ```

3. Compile o código:
   ```sh
   javac Contador.java
   ```

4. Execute o programa:
   ```sh
   java Contador
   ```

## 📄 Código Explicado

### **1️⃣ Classe `Contador`**
Esta classe contém o método `main()` que solicita os números ao usuário e executa a lógica do programa.

```java
public class Contador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int primeiroNumero = scanner.nextInt();
        System.out.print("Digite o segundo número: ");
        int segundoNumero = scanner.nextInt();

        try {
            analisarParametros(primeiroNumero, segundoNumero);
        } catch (ParametrosInvalidosException e) {
            System.out.println("Erro: O segundo parâmetro deve ser maior que o primeiro.");
        }
    }

    static void analisarParametros(int primeiroNumero, int segundoNumero) throws ParametrosInvalidosException {
        if (primeiroNumero > segundoNumero) {
            throw new ParametrosInvalidosException();
        }
        for (int i = primeiroNumero; i <= segundoNumero; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}
```

### **2️⃣ Classe `ParametrosInvalidosException`**
Esta classe define uma exceção personalizada que é lançada quando o primeiro número é maior que o segundo.

```java
public class ParametrosInvalidosException extends Exception {}
```

## 📌 Exemplo de Saída no Terminal

```
--------------------Contador--------------------
Digite o primeiro número: 5
Digite o segundo número: 10
Imprimindo o número 5
Imprimindo o número 6
Imprimindo o número 7
Imprimindo o número 8
Imprimindo o número 9
Imprimindo o número 10
```

Caso o primeiro número seja maior que o segundo:

```
--------------------Contador--------------------
Digite o primeiro número: 10
Digite o segundo número: 5
-------------------------------
ParametrosInvalidosException: O segundo parâmetro deve ser maior que o primeiro
-------------------------------
```

## 🚀 Melhorias Futuras

- ✅ Melhor tratamento de exceções com mensagens personalizadas.
- ✅ Implementação de testes unitários para validar a lógica.
- ✅ Possibilidade de aceitar entrada de números decimais.

## 📜 Licença

Este repositório está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
Criado por [Italo Spina](https://github.com/italospina).


