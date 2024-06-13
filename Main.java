import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeVendas sistema = new SistemaDeVendas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Vendas de Produtos");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Remover Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Gerar Relatório");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    adicionarProduto(sistema, scanner);
                    break;
                case 2:
                    removerProduto(sistema, scanner);
                    break;
                case 3:
                    sistema.listarProdutos();
                    break;
                case 4:
                    gerarRelatorio(sistema, scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void adicionarProduto(SistemaDeVendas sistema, Scanner scanner) {
        System.out.println("Adicionar Produto");
        System.out.println("1. Eletrônico");
        System.out.println("2. Roupa");
        System.out.println("3. Alimento");
        System.out.print("Escolha o tipo de produto: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();  // Consumir a nova linha

        switch (tipo) {
            case 1:
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();
                Produto eletronico = new Eletronico(id, nome, preco, marca, modelo);
                sistema.adicionarProduto(eletronico);
                break;
            case 2:
                System.out.print("Tamanho: ");
                String tamanho = scanner.nextLine();
                System.out.print("Cor: ");
                String cor = scanner.nextLine();
                Produto roupa = new Roupa(id, nome, preco, tamanho, cor);
                sistema.adicionarProduto(roupa);
                break;
            case 3:
                System.out.print("Data de Validade (dd/MM/yyyy): ");
                String dataValidadeStr = scanner.nextLine();
                Date dataValidade = new Date(); // Suponha que a data seja válida
                System.out.print("Peso: ");
                double peso = scanner.nextDouble();
                scanner.nextLine();  // Consumir a nova linha
                Produto alimento = new Alimento(id, nome, preco, dataValidade, peso);
                sistema.adicionarProduto(alimento);
                break;
            default:
                System.out.println("Tipo de produto inválido.");
        }
    }

    private static void removerProduto(SistemaDeVendas sistema, Scanner scanner) {
        System.out.print("ID do produto a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        try {
            sistema.removerProduto(id);
            System.out.println("Produto removido com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void gerarRelatorio(SistemaDeVendas sistema, Scanner scanner) {
        System.out.print("Nome do arquivo de relatório: ");
        String nomeArquivo = scanner.nextLine();

        try {
            sistema.gerarRelatorio(nomeArquivo);
            System.out.println("Relatório gerado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
}

