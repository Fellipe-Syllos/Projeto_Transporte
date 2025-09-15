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
