import java.util.ArrayList;

public class Carrinho {
    private ArrayList<ItemCompra> listaItens;
    private double totalCompra;
    private double porcDesconto;
    private double valorPagar;

    public Carrinho(double porcDesconto) {
        this.porcDesconto = porcDesconto;
        this.totalCompra = 0;
        this.valorPagar = 0;
        this.listaItens = new ArrayList<>();
    }

    public void mostraCarrinho() {
        int i = 0;
        for (ItemCompra listaItem : listaItens) {
            i++;
            System.out.print(i + "  ");
            listaItem.mostraItem();
        }
    }
    public void addListaItens(ItemCompra item) {
        listaItens.add(item);
    }

    public double somaValores() {
        double somaValores = 0;
        for (ItemCompra listaItem : listaItens) {
            somaValores += listaItem.calcSubtotal();
        }
        return somaValores;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public double getPorcDesconto() {
        return porcDesconto;
    }

    public void setPorcDesconto(double porcDesconto) {
        this.porcDesconto = porcDesconto;
    }

    public double calcDesconto(){
        return (this.getPorcDesconto() / 100) * this.somaValores();
    }

    public double getValorPagar() {
        valorPagar = somaValores() - calcDesconto();
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }
}
