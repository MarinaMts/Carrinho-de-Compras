import java.util.List;

public class ItemCompra {
    private String descricao;
    private int quantidade;
    private double preco;

    public ItemCompra(String descricao, int quantidade, double preco) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemCompra(Produto p) {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void mostraItem(){
        System.out.println(String.format("%-40s %-11s %-12s %-17s", getDescricao(), "R$"+getPreco(), getQuantidade(), "R$"+calcSubtotal()));
    }
    public double calcSubtotal(){
        return this.quantidade * this.preco;
    }

}