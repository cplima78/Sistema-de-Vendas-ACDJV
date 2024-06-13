import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaDeVendas {
    private List<Produto> produtos;

    public SistemaDeVendas() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int id) throws Exception {
        Produto produto = encontrarProdutoPorId(id);
        if (produto != null) {
            produtos.remove(produto);
        } else {
            throw new Exception("Produto não encontrado");
        }
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            produto.exibirDetalhes();
        }
    }

    public void gerarRelatorio(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Produto produto : produtos) {
                writer.write(produto.toString());
                writer.newLine();
            }
        }
    }

    private Produto encontrarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.id == id) {
                return produto;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            SistemaDeVendas sistema = new SistemaDeVendas();

            Produto eletronico = new Eletronico(1, "Smartphone", 3700.0, "Iphone", "13 Pro Max");
            Produto roupa = new Roupa(2, "Camiseta Insider", 150.5, "GG", "Preta");
            Produto alimento = new Alimento(3, "Arroz", 10.0, new Date(), 1.0);

            sistema.adicionarProduto(eletronico);
            sistema.adicionarProduto(roupa);
            sistema.adicionarProduto(alimento);

            sistema.listarProdutos();
            sistema.gerarRelatorio("relatorio.txt");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
