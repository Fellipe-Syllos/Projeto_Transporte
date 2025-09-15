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
