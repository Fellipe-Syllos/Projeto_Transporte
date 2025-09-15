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
