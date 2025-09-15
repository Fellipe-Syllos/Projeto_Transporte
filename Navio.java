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
