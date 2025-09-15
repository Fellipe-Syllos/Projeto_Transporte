# Sistema de Gerenciamento de Transportes
## Documentação do Projeto de Programação Orientada a Objetos

---

### **Dados do Projeto**
- **Disciplina:** Programação Orientada a Objetos
- **Linguagem:** Java
- **Tema:** Sistema de Gerenciamento de Transportes com Herança
- **Data:** Setembro de 2025

---

## **1. INTRODUÇÃO**

### **1.1 Importância da Programação Orientada a Objetos**

A Programação Orientada a Objetos (POO) representa um paradigma fundamental no desenvolvimento de software moderno, oferecendo uma abordagem estruturada e intuitiva para modelar problemas do mundo real através de conceitos computacionais.

**Principais benefícios da POO:**

- **Modularidade:** Permite dividir problemas complexos em componentes menores e gerenciáveis
- **Reutilização de Código:** Facilita o reaproveitamento de soluções já desenvolvidas
- **Manutenibilidade:** Torna o código mais fácil de modificar e atualizar
- **Escalabilidade:** Possibilita o crescimento controlado do sistema
- **Modelagem Natural:** Aproxima a estrutura do código da realidade que está sendo representada

### **1.2 Importância da Herança**

A herança é um dos pilares fundamentais da POO, permitindo que classes compartilhem características comuns através de uma hierarquia bem definida.

**Vantagens da herança:**

- **Eliminação de Redundância:** Evita duplicação de código ao centralizar atributos e métodos comuns
- **Hierarquia Lógica:** Cria uma estrutura organizacional clara e intuitiva
- **Facilidade de Manutenção:** Alterações na superclasse se propagam automaticamente para as subclasses
- **Extensibilidade:** Permite adicionar novas funcionalidades sem modificar código existente
- **Polimorfismo:** Habilita o tratamento uniforme de objetos de diferentes tipos

### **1.3 Objetivo do Projeto**

Este projeto demonstra a implementação prática dos conceitos de POO em Java, criando um sistema de gerenciamento de transportes que utiliza herança, polimorfismo, encapsulamento e tratamento de exceções para gerenciar uma frota composta por aviões e navios.

---

## **2. CONTEÚDO**

### **2.1 Diagrama Hierárquico de Classes (UML)**

```
                    ┌─────────────────────┐
                    │     <<abstract>>    │
                    │     Transporte      │
                    │                     │
                    │ # capacidadeTanque  │
                    │ # numeroPassageiros │
                    │ # preco             │
                    │                     │
                    │ + getters/setters   │
                    │ + imprimir()        │
                    │ + entrada()         │
                    └──────────┬──────────┘
                               │
                    ┌──────────┴──────────┐
                    │                     │
                    ▼                     ▼
        ┌─────────────────────┐  ┌─────────────────────┐
        │       Aviao         │  │       Navio         │
        │                     │  │                     │
        │ - prefixo           │  │ - nome              │
        │ - dataRevisao       │  │ - numeroTripulantes │
        │                     │  │ - dataLancamento    │
        │ + getters/setters   │  │                     │
        │ + reajustarPreco()  │  │ + getters/setters   │
        │ + imprimir()        │  │ + passageirosPor    │
        │ + entrada()         │  │   Tripulantes()     │
        └─────────────────────┘  │ + imprimir()        │
                                 │ + entrada()         │
                                 └─────────────────────┘
                                           ▲
                                           │
                                    ┌─────────────┐
                                    │  Aplicacao  │
                                    │             │
                                    │ - scanner   │
                                    │ - vetor[20] │
                                    │             │
                                    │ + main()    │
                                    └─────────────┘
```

**Legenda:**
- `<<abstract>>`: Classe abstrata
- `#`: Atributo protected
- `-`: Atributo private
- `+`: Método público
- `▼`: Herança (extends)
- `▲`: Dependência (uses)

---

### **2.2 Código da Superclasse**

#### **Transporte.java**

```java
import java.util.Scanner;

/**
 * Superclasse que representa um meio de transporte genérico
 * Contém os atributos comuns às subclasses Aviao e Navio
 */
public abstract class Transporte {
    // Atributos protegidos para permitir acesso pelas subclasses
    protected int capacidadeTanque;
    protected int numeroPassageiros;
    protected double preco;
    
    // Construtor vazio
    public Transporte() {
        this.capacidadeTanque = 0;
        this.numeroPassageiros = 0;
        this.preco = 0.0;
    }
    
    // Construtor com parâmetros
    public Transporte(int capacidadeTanque, int numeroPassageiros, double preco) {
        this.capacidadeTanque = capacidadeTanque;
        this.numeroPassageiros = numeroPassageiros;
        this.preco = preco;
    }
    
    // Getters e Setters para os atributos comuns
    public int getCapacidadeTanque() {
        return capacidadeTanque;
    }
    
    public void setCapacidadeTanque(int capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }
    
    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }
    
    public void setNumeroPassageiros(int numeroPassageiros) {
        this.numeroPassageiros = numeroPassageiros;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    // Métodos abstratos que devem ser implementados pelas subclasses
    public abstract void imprimir();
    public abstract void entrada(Scanner scanner);
}
```

---

### **2.3 Código das Subclasses**

#### **Aviao.java**

```java
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Classe Aviao que herda de Transporte
 * Representa um avião com atributos específicos
 */
public class Aviao extends Transporte {
    // Atributos específicos da classe Aviao
    private String prefixo;
    private String dataRevisao;
    
    // Construtor vazio
    public Aviao() {
        super(); // Chama o construtor vazio da superclasse
        this.prefixo = "";
        this.dataRevisao = "";
    }
    
    // Construtor com parâmetros
    public Aviao(String prefixo, int capacidadeTanque, int numeroPassageiros, 
                 double preco, String dataRevisao) {
        super(capacidadeTanque, numeroPassageiros, preco); // Chama construtor da superclasse
        this.prefixo = prefixo;
        this.dataRevisao = dataRevisao;
    }
    
    // Getters e Setters específicos
    public String getPrefixo() {
        return prefixo;
    }
    
    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
    
    public String getDataRevisao() {
        return dataRevisao;
    }
    
    public void setDataRevisao(String dataRevisao) {
        this.dataRevisao = dataRevisao;
    }
    
    // Método para reajustar preço
    public void reajustarPreco(double percentual) {
        this.preco = this.preco + (this.preco * percentual / 100);
    }
    
    // Implementação do método imprimir
    @Override
    public void imprimir() {
        System.out.println("===== DADOS DO AVIÃO =====");
        System.out.println("Prefixo: " + prefixo);
        System.out.println("Capacidade do Tanque: " + capacidadeTanque + " litros");
        System.out.println("Número de Passageiros: " + numeroPassageiros);
        System.out.println("Preço: R$ " + String.format("%.2f", preco));
        System.out.println("Data da Revisão: " + dataRevisao);
        System.out.println("==========================");
    }
    
    // Implementação do método entrada com tratamento de exceções
    @Override
    public void entrada(Scanner scanner) {
        boolean entradaValida = false;
        
        System.out.println("===== ENTRADA DE DADOS DO AVIÃO =====");
        
        // Leitura do prefixo
        System.out.print("Digite o prefixo do avião: ");
        this.prefixo = scanner.nextLine();
        
        // Leitura da capacidade do tanque com tratamento de exceção
        while (!entradaValida) {
            try {
                System.out.print("Digite a capacidade do tanque (litros): ");
                this.capacidadeTanque = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros para a capacidade do tanque!");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        
        // Leitura do número de passageiros com tratamento de exceção
        entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite o número de passageiros: ");
                this.numeroPassageiros = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros para o número de passageiros!");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        
        // Leitura do preço com tratamento de exceção
        entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite o preço (R$): ");
                this.preco = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números para o preço!");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        
        // Limpa o buffer antes de ler a próxima string
        scanner.nextLine();
        
        // Leitura da data de revisão
        System.out.print("Digite a data da revisão (dd/mm/aaaa): ");
        this.dataRevisao = scanner.nextLine();
        
        System.out.println("Dados do avião inseridos com sucesso!");
    }
}
```

#### **Navio.java**

```java
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Classe Navio que herda de Transporte
 * Representa um navio com atributos específicos
 */
public class Navio extends Transporte {
    // Atributos específicos da classe Navio
    private String nome;
    private int numeroTripulantes;
    private String dataLancamento;
    
    // Construtor 1: vazio
    public Navio() {
        super(); // Chama o construtor vazio da superclasse
        this.nome = "";
        this.numeroTripulantes = 0;
        this.dataLancamento = "";
    }
    
    // Construtor 2: apenas com nome
    public Navio(String nome) {
        super();
        this.nome = nome;
        this.numeroTripulantes = 0;
        this.dataLancamento = "";
    }
    
    // Construtor 3: nome e número de tripulantes
    public Navio(String nome, int numeroTripulantes) {
        super();
        this.nome = nome;
        this.numeroTripulantes = numeroTripulantes;
        this.dataLancamento = "";
    }
    
    // Construtor 4: nome, número de tripulantes e data de lançamento
    public Navio(String nome, int numeroTripulantes, String dataLancamento) {
        super();
        this.nome = nome;
        this.numeroTripulantes = numeroTripulantes;
        this.dataLancamento = dataLancamento;
    }
    
    // Construtor 5: todos os parâmetros
    public Navio(String nome, int capacidadeTanque, int numeroPassageiros, 
                 int numeroTripulantes, double preco, String dataLancamento) {
        super(capacidadeTanque, numeroPassageiros, preco); // Chama construtor da superclasse
        this.nome = nome;
        this.numeroTripulantes = numeroTripulantes;
        this.dataLancamento = dataLancamento;
    }
    
    // Getters e Setters específicos
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getNumeroTripulantes() {
        return numeroTripulantes;
    }
    
    public void setNumeroTripulantes(int numeroTripulantes) {
        this.numeroTripulantes = numeroTripulantes;
    }
    
    public String getDataLancamento() {
        return dataLancamento;
    }
    
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    
    // Método passageirosPorTripulantes
    public double passageirosPorTripulantes() {
        if (numeroTripulantes == 0) {
            return 0.0; // Evita divisão por zero
        }
        return (double) numeroPassageiros / numeroTripulantes;
    }
    
    // Implementação do método imprimir
    @Override
    public void imprimir() {
        System.out.println("===== DADOS DO NAVIO =====");
        System.out.println("Nome: " + nome);
        System.out.println("Capacidade do Tanque: " + capacidadeTanque + " litros");
        System.out.println("Número de Passageiros: " + numeroPassageiros);
        System.out.println("Número de Tripulantes: " + numeroTripulantes);
        System.out.println("Preço: R$ " + String.format("%.2f", preco));
        System.out.println("Data de Lançamento: " + dataLancamento);
        System.out.println("Passageiros por Tripulante: " + String.format("%.2f", passageirosPorTripulantes()));
        System.out.println("==========================");
    }
    
    // Implementação do método entrada com tratamento de exceções
    @Override
    public void entrada(Scanner scanner) {
        boolean entradaValida = false;
        
        System.out.println("===== ENTRADA DE DADOS DO NAVIO =====");
        
        // Leitura do nome
        System.out.print("Digite o nome do navio: ");
        this.nome = scanner.nextLine();
        
        // Leitura da capacidade do tanque com tratamento de exceção
        while (!entradaValida) {
            try {
                System.out.print("Digite a capacidade do tanque (litros): ");
                this.capacidadeTanque = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros para a capacidade do tanque!");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        
        // Leitura do número de passageiros com tratamento de exceção
        entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite o número de passageiros: ");
                this.numeroPassageiros = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros para o número de passageiros!");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        
        // Leitura do número de tripulantes com tratamento de exceção
        entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite o número de tripulantes: ");
                this.numeroTripulantes = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros para o número de tripulantes!");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        
        // Leitura do preço com tratamento de exceção
        entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite o preço (R$): ");
                this.preco = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números para o preço!");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        
        // Limpa o buffer antes de ler a próxima string
        scanner.nextLine();
        
        // Leitura da data de lançamento
        System.out.print("Digite a data de lançamento (dd/mm/aaaa): ");
        this.dataLancamento = scanner.nextLine();
        
        System.out.println("Dados do navio inseridos com sucesso!");
    }
}
```

---

### **2.4 Código da Classe de Aplicação**

#### **Aplicacao.java**

```java
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Classe principal da aplicação
 * Gerencia um vetor com 10 aviões e 10 navios
 */
public class Aplicacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criando vetor único para armazenar todos os objetos de transporte
        Transporte[] transportes = new Transporte[20];
        
        // Instanciando 10 aviões usando construtor vazio
        for (int i = 0; i < 10; i++) {
            transportes[i] = new Aviao();
        }
        
        // Instanciando 10 navios usando construtor vazio
        for (int i = 10; i < 20; i++) {
            transportes[i] = new Navio();
        }
        
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE TRANSPORTES ===");
        System.out.println("Este sistema permite cadastrar 10 aviões e 10 navios.");
        System.out.println();
        
        // Preenchendo dados dos aviões
        System.out.println("===== CADASTRO DOS AVIÕES =====");
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Avião " + (i + 1) + " ---");
            boolean entradaComSucesso = false;
            
            while (!entradaComSucesso) {
                try {
                    transportes[i].entrada(scanner);
                    entradaComSucesso = true;
                } catch (Exception e) {
                    System.out.println("Erro inesperado ao inserir dados do avião: " + e.getMessage());
                    System.out.println("Tente novamente.");
                }
            }
        }
        
        // Preenchendo dados dos navios
        System.out.println("\n===== CADASTRO DOS NAVIOS =====");
        for (int i = 10; i < 20; i++) {
            System.out.println("\n--- Navio " + (i - 9) + " ---");
            boolean entradaComSucesso = false;
            
            while (!entradaComSucesso) {
                try {
                    transportes[i].entrada(scanner);
                    entradaComSucesso = true;
                } catch (Exception e) {
                    System.out.println("Erro inesperado ao inserir dados do navio: " + e.getMessage());
                    System.out.println("Tente novamente.");
                }
            }
        }
        
        // Perguntando se deseja aplicar reajuste nos aviões
        System.out.println("\n===== REAJUSTE DE PREÇOS DOS AVIÕES =====");
        boolean aplicarReajuste = false;
        double percentualReajuste = 0.0;
        
        try {
            System.out.print("Deseja aplicar reajuste nos preços dos aviões? (s/n): ");
            String resposta = scanner.nextLine();
            
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                aplicarReajuste = true;
                boolean percentualValido = false;
                
                while (!percentualValido) {
                    try {
                        System.out.print("Digite o percentual de reajuste (ex: 10 para 10%): ");
                        percentualReajuste = scanner.nextDouble();
                        percentualValido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Digite apenas números para o percentual!");
                        scanner.nextLine(); // Limpa o buffer
                    }
                }
                
                // Aplicando reajuste nos aviões
                for (int i = 0; i < 10; i++) {
                    if (transportes[i] instanceof Aviao) {
                        ((Aviao) transportes[i]).reajustarPreco(percentualReajuste);
                    }
                }
                
                System.out.println("Reajuste de " + percentualReajuste + "% aplicado com sucesso aos aviões!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar reajuste: " + e.getMessage());
        }
        
        // Exibindo todos os objetos
        System.out.println("\n\n===== RELATÓRIO COMPLETO DE TRANSPORTES =====");
        
        // Exibindo aviões
        System.out.println("\n***** AVIÕES CADASTRADOS *****");
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Avião " + (i + 1) + " ---");
            transportes[i].imprimir();
        }
        
        // Exibindo navios
        System.out.println("\n***** NAVIOS CADASTRADOS *****");
        for (int i = 10; i < 20; i++) {
            System.out.println("\n--- Navio " + (i - 9) + " ---");
            transportes[i].imprimir();
        }
        
        // Estatísticas gerais
        System.out.println("\n\n===== ESTATÍSTICAS GERAIS =====");
        
        // Calculando estatísticas dos aviões
        double somaPrecoAvioes = 0;
        int totalPassageirosAvioes = 0;
        for (int i = 0; i < 10; i++) {
            somaPrecoAvioes += transportes[i].getPreco();
            totalPassageirosAvioes += transportes[i].getNumeroPassageiros();
        }
        
        // Calculando estatísticas dos navios
        double somaPrecoNavios = 0;
        int totalPassageirosNavios = 0;
        int totalTripulantes = 0;
        for (int i = 10; i < 20; i++) {
            somaPrecoNavios += transportes[i].getPreco();
            totalPassageirosNavios += transportes[i].getNumeroPassageiros();
            if (transportes[i] instanceof Navio) {
                totalTripulantes += ((Navio) transportes[i]).getNumeroTripulantes();
            }
        }
        
        System.out.println("Aviões:");
        System.out.println("  - Total de aviões: 10");
        System.out.println("  - Preço médio: R$ " + String.format("%.2f", somaPrecoAvioes / 10));
        System.out.println("  - Total de passageiros: " + totalPassageirosAvioes);
        System.out.println("  - Média de passageiros por avião: " + String.format("%.1f", (double)totalPassageirosAvioes / 10));
        
        System.out.println("\nNavios:");
        System.out.println("  - Total de navios: 10");
        System.out.println("  - Preço médio: R$ " + String.format("%.2f", somaPrecoNavios / 10));
        System.out.println("  - Total de passageiros: " + totalPassageirosNavios);
        System.out.println("  - Total de tripulantes: " + totalTripulantes);
        System.out.println("  - Média de passageiros por navio: " + String.format("%.1f", (double)totalPassageirosNavios / 10));
        System.out.println("  - Média de tripulantes por navio: " + String.format("%.1f", (double)totalTripulantes / 10));
        
        System.out.println("\nGeral:");
        System.out.println("  - Total de transportes: 20");
        System.out.println("  - Valor total da frota: R$ " + String.format("%.2f", somaPrecoAvioes + somaPrecoNavios));
        System.out.println("  - Total geral de passageiros: " + (totalPassageirosAvioes + totalPassageirosNavios));
        
        System.out.println("\n===== FIM DO PROGRAMA =====");
        System.out.println("Obrigado por usar o Sistema de Gerenciamento de Transportes!");
        
        scanner.close();
    }
}
```

---

## **3. DOCUMENTAÇÃO DO PROJETO**

### **3.1 Análise da Estrutura Hierárquica**

O projeto implementa uma hierarquia de classes bem estruturada que demonstra claramente os conceitos fundamentais da POO:

#### **Superclasse Transporte**
- **Tipo:** Classe abstrata
- **Responsabilidade:** Centralizar atributos e comportamentos comuns
- **Atributos Comuns:** 
  - `capacidadeTanque` (int)
  - `numeroPassageiros` (int) 
  - `preco` (double)
- **Métodos Abstratos:** `imprimir()` e `entrada(Scanner scanner)`

#### **Subclasse Aviao**
- **Herança:** Estende Transporte
- **Atributos Específicos:**
  - `prefixo` (String)
  - `dataRevisao` (String)
- **Métodos Específicos:**
  - `reajustarPreco(double percentual)`
- **Construtores:** 2 variações

#### **Subclasse Navio**  
- **Herança:** Estende Transporte
- **Atributos Específicos:**
  - `nome` (String)
  - `numeroTripulantes` (int)
  - `dataLancamento` (String)
- **Métodos Específicos:**
  - `passageirosPorTripulantes()`
- **Construtores:** 5 variações

### **3.2 Conceitos de POO Implementados**

#### **3.2.1 Herança**
- Reutilização eficiente de código através da superclasse `Transporte`
- Hierarquia lógica: Transporte → {Aviao, Navio}
- Uso correto de `super()` nos construtores das subclasses

#### **3.2.2 Encapsulamento**
- Atributos `protected` na superclasse para acesso controlado pelas subclasses
- Atributos `private` nas subclasses para proteção total
- Métodos getters e setters para acesso controlado aos dados

#### **3.2.3 Polimorfismo**
- Implementação diferenciada dos métodos abstratos `imprimir()` e `entrada()`
- Tratamento uniforme de objetos diferentes através da referência da superclasse
- Uso de `instanceof` para verificação de tipos específicos

#### **3.2.4 Abstração**
- Classe `Transporte` define interface comum sem implementação concreta
- Métodos abstratos forçam implementação nas subclasses
- Modelagem conceitual clara da realidade

### **3.2.5 Tratamento de Exceções**
- `InputMismatchException` para validação de entrada de dados
- `Exception` genérica para captura de erros inesperados
- Validação de divisão por zero no método `passageirosPorTripulantes()`

### **3.3 Funcionalidades do Sistema**

#### **3.3.1 Gerenciamento de Frota**
- Vetor único para 20 objetos de transporte (10 aviões + 10 navios)
- Instanciação dinâmica usando construtores vazios
- Interface unificada para diferentes tipos de transporte

#### **3.3.2 Entrada de Dados**
- Validação robusta com tratamento de exceções
- Interface intuitiva para o usuário
- Limpeza adequada do buffer do Scanner

#### **3.3.3 Processamento de Dados**
- Reajuste automático de preços nos aviões
- Cálculo de estatísticas por categoria
- Relatórios detalhados e consolidados

#### **3.3.4 Exibição de Resultados**
- Formatação profissional dos dados
- Estatísticas completas da frota
- Interface clara e organizada

---

## **4. RESULTADOS DA EXECUÇÃO**

### **4.1 Dados de Teste Utilizados**

**Aviões Cadastrados (com reajuste de 15%):**
1. PT-ABC: 5.000L, 180 pass., R$ 172.500,00
2. PT-DEF: 4.500L, 200 pass., R$ 207.000,00  
3. PT-GHI: 6.000L, 220 pass., R$ 230.000,00
4. PT-JKL: 5.500L, 190 pass., R$ 195.500,00
5. PT-MNO: 4.800L, 210 pass., R$ 184.000,00
6. PT-PQR: 5.200L, 185 pass., R$ 201.250,00
7. PT-STU: 5.800L, 195 pass., R$ 212.750,00
8. PT-VWX: 4.700L, 175 pass., R$ 178.250,00
9. PT-YZA: 5.300L, 205 pass., R$ 218.500,00
10. PT-BCD: 4.900L, 180 pass., R$ 189.750,00

**Navios Cadastrados:**
1. Titanic II: 15.000L, 2.500 pass., 50 trip., R$ 5.000.000,00
2. Queen Mary III: 18.000L, 3.000 pass., 60 trip., R$ 7.500.000,00
3. Navigator Star: 12.000L, 1.800 pass., 40 trip., R$ 3.500.000,00
4. Ocean Explorer: 16.000L, 2.200 pass., 55 trip., R$ 4.200.000,00
5. Sea Adventure: 14.000L, 2.000 pass., 45 trip., R$ 3.800.000,00
6. Blue Horizon: 13.000L, 1.900 pass., 42 trip., R$ 3.200.000,00
7. Wave Rider: 17.000L, 2.400 pass., 58 trip., R$ 5.500.000,00
8. Deep Sea: 11.000L, 1.500 pass., 35 trip., R$ 2.800.000,00
9. Marine Princess: 19.000L, 2.800 pass., 65 trip., R$ 6.800.000,00
10. Aqua Voyager: 15.500L, 2.100 pass., 48 trip., R$ 4.000.000,00

### **4.2 Estatísticas Finais**

**Aviões:**
- Preço médio: R$ 198.950,00
- Total de passageiros: 1.940
- Média de passageiros por avião: 194,0

**Navios:**
- Preço médio: R$ 4.630.000,00
- Total de passageiros: 22.200
- Total de tripulantes: 498
- Média de passageiros por navio: 2.220,0
- Média de tripulantes por navio: 49,8

**Geral:**
- **Valor total da frota: R$ 48.289.500,00**
- **Total geral de passageiros: 24.140**

---

## **5. CONCLUSÃO**

### **5.1 Objetivos Alcançados**

O projeto Sistema de Gerenciamento de Transportes demonstrou com sucesso a aplicação prática dos conceitos fundamentais da Programação Orientada a Objetos em Java. Todos os requisitos técnicos foram atendidos de forma completa:

✅ **Herança bem estruturada** com superclasse abstrata e subclasses especializadas  
✅ **Polimorfismo efetivo** através da implementação diferenciada de métodos abstratos  
✅ **Encapsulamento adequado** com controle de acesso aos atributos  
✅ **Tratamento robusto de exceções** para validação de entrada  
✅ **Múltiplos construtores** demonstrando sobrecarga  
✅ **Vetores de objetos** para gerenciamento de coleções  
✅ **Métodos específicos** com funcionalidades únicas por classe  

### **5.2 Benefícios Observados**

**Manutenibilidade:** A estrutura hierárquica facilita modificações e extensões futuras. Alterações na superclasse se propagam automaticamente para as subclasses.

**Reutilização:** Os atributos comuns são definidos uma única vez na superclasse, eliminando duplicação de código.

**Extensibilidade:** Novas classes de transporte podem ser facilmente adicionadas seguindo o mesmo padrão.

**Robustez:** O tratamento de exceções garante que o sistema continue funcionando mesmo com entradas inválidas.

**Clareza:** A separação de responsabilidades torna o código mais legível e compreensível.

### **5.3 Aprendizados Técnicos**

**Herança:** Compreensão prática de como criar hierarquias eficientes e evitar redundância.

**Polimorfismo:** Experiência na implementação de comportamentos diferentes através de uma interface comum.

**Tratamento de Exceções:** Habilidade para criar sistemas resilientes a erros de entrada.

**Design de Classes:** Conhecimento sobre como estruturar classes de forma coesa e com baixo acoplamento.

**Scanner Management:** Técnicas para gerenciar adequadamente o buffer de entrada e evitar conflitos.

### **5.4 Aplicações Práticas**

Os conceitos demonstrados neste projeto são fundamentais para o desenvolvimento de software empresarial moderno:

- **Sistemas de Gestão:** Estruturas similares são usadas em ERPs e CRMs
- **Jogos:** Hierarquias de personagens e objetos
- **Aplicações Web:** Modelos de dados com herança
- **APIs:** Estruturas de resposta polimórficas
- **Frameworks:** Base para compreensão de Spring, Hibernate, etc.

### **5.5 Considerações Finais**

O projeto comprovou que a Programação Orientada a Objetos oferece uma abordagem natural e eficiente para modelar problemas complexos. A herança, quando bem aplicada, não apenas reduz a quantidade de código, mas também cria uma arquitetura mais limpa e profissional.

A experiência prática com tratamento de exceções reforçou a importância de desenvolver software robusto e confiável, características essenciais em sistemas de produção.

O domínio destes conceitos representa um passo fundamental na formação de um desenvolvedor Java competente, preparado para enfrentar os desafios do desenvolvimento de software moderno.

---

## **6. BIBLIOGRAFIA**

### **6.1 Livros de Referência**

1. **DEITEL, Paul; DEITEL, Harvey.** *Java: Como Programar*. 10ª ed. São Paulo: Pearson Prentice Hall, 2017.

2. **SIERRA, Kathy; BATES, Bert.** *Use a Cabeça! Java*. 2ª ed. Rio de Janeiro: Alta Books, 2007.

3. **HORSTMANN, Cay S.; CORNELL, Gary.** *Core Java Volume I - Fundamentals*. 11ª ed. Boston: Addison-Wesley, 2019.

4. **BLOCH, Joshua.** *Java Efetivo*. 3ª ed. São Paulo: Alta Books, 2018.

### **6.2 Documentação Oficial**

5. **ORACLE.** *Java SE Documentation*. Disponível em: https://docs.oracle.com/en/java/javase/. Acesso em: setembro 2025.

6. **ORACLE.** *Java Language Specification*. Disponível em: https://docs.oracle.com/javase/specs/. Acesso em: setembro 2025.

### **6.3 Artigos Acadêmicos**

7. **GAMMA, Erich et al.** *Design Patterns: Elements of Reusable Object-Oriented Software*. Boston: Addison-Wesley, 1995.

8. **MARTIN, Robert C.** *Clean Code: A Handbook of Agile Software Craftsmanship*. Boston: Prentice Hall, 2008.

### **6.4 Recursos Online**

9. **BAELDUNG.** *Java Tutorials*. Disponível em: https://www.baeldung.com/. Acesso em: setembro 2025.

10. **ORACLE.** *Java Code Conventions*. Disponível em: https://www.oracle.com/java/technologies/javase/codeconventions-contents.html. Acesso em: setembro 2025.

---

**Documento gerado em:** Setembro de 2025  
**Versão:** 1.0  
**Formato:** Markdown (conversível para PDF)  
**Licença:** Uso Educacional
