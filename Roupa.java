public class Roupa extends Produto {
    private String tamanho;
    private String cor;

    public Roupa(int id, String nome, double preco, String tamanho, String cor) {
        super(id, nome, preco);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Roupa [ID=" + id + ", Nome=" + nome + ", " +
                "Preço=" + preco + ", Tamanho=" + tamanho + ", Cor=" + cor + "]");
    }
}

