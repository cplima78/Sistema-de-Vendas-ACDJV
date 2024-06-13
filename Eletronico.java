public class Eletronico extends Produto{
    private String marca;
    private String modelo;

    public Eletronico(int id, String nome, double preco, String marca, String modelo) {
        super(id, nome, preco);
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Eletronico [ID = " + id + ", Nome = " + nome + ", Preco = "
                + preco + ", Marca = " + marca + ", Modelo = " + modelo + "]");
    }
}
