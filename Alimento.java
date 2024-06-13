import java.util.Date;

public class Alimento extends Produto {
    private Date dataValidade;
    private double peso;

    public Alimento(int id, String nome, double preco, Date dataValidade, double peso) {
        super(id, nome, preco);
        this.dataValidade = dataValidade;
        this.peso = peso;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Alimento [ID=" + id + ", Nome=" + nome + ", " +
                "Preço=" + preco + ", Data de Validade=" + dataValidade + ", Peso=" + peso + "]");
    }
}
