# Lazy Initialization — Java

Mini projeto desenvolvido para praticar o conceito de **Lazy Initialization (Inicialização Tardia)** em Java puro, antes de aplicar o conceito em frameworks como Spring.

O projeto simula um pequeno sistema de geração de relatórios e demonstra como objetos podem ser criados **somente quando realmente forem necessários**.

## Objetivo

Praticar na prática:

* Classes e objetos
* Encapsulamento
* Separação de responsabilidades
* Service
* Generator
* Lazy Initialization
* Criação e reutilização de objetos
* Injeção manual de dependência
* Noções de gerenciamento do ciclo de vida de objetos

## Estrutura

```text
src/
└── main/
    └── java/
        └── org.example/
            ├── Main.java
            ├── service/
            │   └── RelatorioService.java
            ├── generator/
            │   └── RelatorioGenerator.java
            └── model/
                └── Relatorio.java
```

### Responsabilidade das classes

**`Relatorio`**

Representa o relatório e possui as informações necessárias para sua geração.

**`RelatorioGenerator`**

Responsável por executar a geração do relatório.

**`RelatorioService`**

Coordena o processo e controla a criação dos objetos utilizando Lazy Initialization.

**`Main`**

Responsável apenas por iniciar e utilizar o sistema.

## Lazy Initialization

Lazy Initialization significa **adiar a criação de um objeto até o momento em que ele realmente seja necessário**.

No projeto, o `Relatorio` começa como:

```java
private Relatorio relatorio;
```

Nesse momento, nenhuma instância foi criada.

Quando o método é chamado:

```java
public Relatorio getRelatorio() {

    if (relatorio == null) {
        relatorio = new Relatorio("vendas");
    }

    return relatorio;
}
```

O objeto somente é criado na primeira utilização.

Depois disso, o mesmo objeto é reutilizado.

O mesmo conceito foi aplicado ao `RelatorioGenerator`:

```java
if (generator == null) {
    generator = new RelatorioGenerator();
}
```

## Fluxo

Na primeira execução:

```text
gerarRelatorio()
       ↓
generator == null
       ↓
cria RelatorioGenerator
       ↓
getRelatorio()
       ↓
relatorio == null
       ↓
cria Relatorio
       ↓
generator.gerar(relatorio)
```

Na segunda execução:

```text
gerarRelatorio()
       ↓
generator já existe
       ↓
getRelatorio()
       ↓
relatorio já existe
       ↓
reutiliza os objetos
```

Dessa forma, os objetos não são recriados desnecessariamente.

## Conceito principal

A ideia pode ser resumida como:

> **"Não crie agora o que talvez só seja necessário depois."**

Lazy Initialization pode ser útil quando determinado recurso possui uma inicialização mais custosa ou quando existe a possibilidade de ele nunca ser utilizado.

Exemplos de situações onde o conceito pode aparecer:

* Recursos pesados
* Clientes de serviços externos
* Processadores de arquivos
* Geradores de relatórios
* Cache
* Alguns recursos relacionados a banco de dados
* Componentes que possuem inicialização custosa

## Relação com Spring

Este projeto foi desenvolvido propositalmente **sem Spring** para entender o conceito antes de deixar o framework cuidar do ciclo de vida dos objetos.

No Spring, conceitos relacionados aparecem através do container de IoC/DI e de configurações de inicialização dos beans.

A ideia deste projeto é entender primeiro:

```text
Java puro
   ↓
Eu controlo a criação
   ↓
Entendo o ciclo de vida
   ↓
Depois aplico Spring
```

## Conclusão

Este projeto foi criado como um exercício prático para entender **Lazy Initialization em Java**, implementando manualmente a lógica de criação sob demanda.

A principal lição é entender a diferença entre:

```java
new Objeto();
```

e:

```java
if (objeto == null) {
    objeto = new Objeto();
}
```

No segundo caso, a criação pode ser **adiada até o momento em que o objeto realmente for necessário**.
