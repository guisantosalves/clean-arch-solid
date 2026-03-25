# Singleton

## O que é
Garante que uma classe tenha uma única instância na aplicação inteira.

## Onde aplicar no projeto
Pacote: `com.bugpet.project.singleton`

Criar uma classe `DatabaseConnectionManager` — gerenciador de conexão que só pode existir uma vez.

## Como implementar

1. Criar a classe `DatabaseConnectionManager`
2. Tornar o construtor `private`
3. Criar um atributo `private static` da própria classe
4. Criar o método `public static getInstance()` que retorna sempre a mesma instância
5. Adicionar um método `getConnection()` que simula retornar uma conexão

## Estrutura esperada

```
singleton/
  └── DatabaseConnectionManager.java
```

## O que o código precisa ter
- Construtor privado
- Atributo estático da instância
- Método getInstance() sincronizado (thread-safe)
- Um método de exemplo que use a instância (ex: getConnection)

## Como testar
- Chamar `getInstance()` duas vezes e verificar que o objeto retornado é o mesmo (`assertSame`)
- Testar em threads diferentes e garantir que continua sendo a mesma instância
