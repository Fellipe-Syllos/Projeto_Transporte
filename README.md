# Sistema de Gerenciamento de Transportes

Este projeto foi desenvolvido em Java seguindo os conceitos de **Programação Orientada a Objetos** com herança, vetores de objetos e tratamento de exceções.

## 📋 Descrição do Projeto

O sistema permite gerenciar uma frota de transportes composta por **10 aviões** e **10 navios**, oferecendo funcionalidades para cadastro, armazenamento e exibição dos dados.

## 🏗️ Estrutura do Projeto

### Classes Implementadas

1. **Transporte (Superclasse abstrata)**
   - Atributos comuns: `capacidadeTanque`, `numeroPassageiros`, `preco`
   - 2 construtores (vazio e com parâmetros)
   - Métodos abstratos: `imprimir()` e `entrada()`

2. **Aviao (Subclasse)**
   - Atributos específicos: `prefixo`, `dataRevisao`
   - 2 construtores (vazio e com parâmetros)
   - Método específico: `reajustarPreco(double percentual)`

3. **Navio (Subclasse)**
   - Atributos específicos: `nome`, `numeroTripulantes`, `dataLancamento`
   - 5 construtores com diferentes combinações de parâmetros
   - Método específico: `passageirosPorTripulantes()`

4. **Aplicacao (Classe principal)**
   - Gerencia vetor único com 20 objetos de transporte
   - Implementa tratamento robusto de exceções
   - Gera relatórios e estatísticas completas

## ⚙️ Funcionalidades

- ✅ **Herança**: Aviao e Navio herdam de Transporte
- ✅ **Encapsulamento**: Atributos protected/private com getters/setters
- ✅ **Polimorfismo**: Métodos sobrescritos (imprimir, entrada)
- ✅ **Tratamento de Exceções**: InputMismatchException para entradas inválidas
- ✅ **Vetores de Objetos**: Array único para 20 transportes
- ✅ **Relatórios**: Exibição detalhada e estatísticas gerais

## 🚀 Como Executar

### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior
- Terminal/Prompt de comando

### Instruções

1. **Compilar o projeto:**
   ```bash
   javac *.java
   ```

2. **Executar a aplicação:**
   ```bash
   java Aplicacao
   ```

3. **Seguir as instruções na tela:**
   - Cadastrar dados dos 10 aviões
   - Cadastrar dados dos 10 navios
   - Opcionalmente aplicar reajuste de preços nos aviões
   - Visualizar relatório completo com estatísticas

## 📊 Funcionalidades do Sistema

### Durante a Execução:
1. **Cadastro de Aviões** (10 unidades)
   - Prefixo
   - Capacidade do tanque (litros)
   - Número de passageiros
   - Preço (R$)
   - Data da revisão

2. **Cadastro de Navios** (10 unidades)
   - Nome
   - Capacidade do tanque (litros)
   - Número de passageiros
   - Número de tripulantes
   - Preço (R$)
   - Data de lançamento

3. **Reajuste de Preços**
   - Aplicação opcional de percentual de reajuste nos aviões

4. **Relatórios Automáticos**
   - Dados detalhados de cada transporte
   - Estatísticas por categoria (aviões/navios)
   - Estatísticas gerais da frota

## 🛡️ Tratamento de Exceções

O sistema implementa tratamento robusto para:
- **InputMismatchException**: Quando o usuário digita texto onde esperado número
- **Exception genérica**: Captura outros erros inesperados
- **Validação de divisão por zero**: No cálculo de passageiros por tripulantes

## 📈 Relatórios Gerados

### Estatísticas dos Aviões:
- Total de aviões
- Preço médio
- Total e média de passageiros

### Estatísticas dos Navios:
- Total de navios
- Preço médio
- Total e média de passageiros
- Total e média de tripulantes

### Estatísticas Gerais:
- Total de transportes
- Valor total da frota
- Total geral de passageiros

## 🎯 Conceitos de POO Aplicados

- **Herança**: Reutilização de código através da superclasse Transporte
- **Polimorfismo**: Diferentes implementações dos métodos abstrátos
- **Encapsulamento**: Proteção dos dados com modificadores de acesso
- **Abstração**: Classe abstrata define interface comum

## 👨‍💻 Estrutura dos Arquivos

```
ProjetoTransporte/
├── Transporte.java    # Superclasse abstrata
├── Aviao.java         # Subclasse para aviões
├── Navio.java         # Subclasse para navios
├── Aplicacao.java     # Classe principal
└── README.md          # Este arquivo
```

## 📝 Observações Técnicas

- Todos os atributos da superclasse são **protected** para permitir acesso pelas subclasses
- Uso de **Scanner** para entrada de dados com tratamento de exceções
- Implementação de múltiplos construtores conforme especificação
- Formatação monetária usando `String.format()` para valores em reais
- Limpeza adequada do buffer do Scanner para evitar problemas de entrada

---

**Desenvolvido seguindo rigorosamente os requisitos de Programação Orientada a Objetos em Java.**
