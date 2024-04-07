import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        lerArquivo(produtos);

        Carrinho carrinho = new Carrinho(10);


        int cod = 0;
        while(cod != 99999){
            System.out.println("Digite o código do produto que deseja adicionar no carrinho");
            cod = scanner.nextInt();
            scanner.nextLine();

            for(Produto produto : produtos) {
                if (produto.getCodigo() == cod) {
                    System.out.println("Digite a quantidade do item");
                    int qtd = scanner.nextInt();
                    ItemCompra item = new ItemCompra(produto.getDescricao(), qtd, produto.getPreco());
                    item.mostraItem();
                    carrinho.addListaItens(item);
                    break;
                }
            }
        }

        exibeCarrinho(carrinho);
    }


    public static void lerArquivo(List<Produto> produtos){

        try(BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream("PRODUTOS.txt")))) {
            String linha;
            while ((linha = buf.readLine()) != null) {

                String [] produtoVetor = linha.split(";");

                Produto produto = new Produto(Integer.parseInt(produtoVetor[0]),produtoVetor[1], Double.parseDouble(produtoVetor[2]));
                produtos.add(produto);
            }

            System.out.println("Fim da leitura do arquivo!");
        }catch(FileNotFoundException erro){
            System.out.println(">> Arquivo não encontrado");
        }catch(IOException erro){
            System.out.println(">> Erro na leitura");
        }
    }


    public static void exibeCarrinho(Carrinho carrinho){
        String linha = repeat("-", 80);
        double valores = carrinho.somaValores();
        String desconto = String.format("%.2f", carrinho.calcDesconto());
        String valorAPagar = String.format("%.2f", carrinho.getValorPagar());

        System.out.println(linha);
        System.out.println(String.format("|%-40s|%-10s|%-15s|%-10s|", "Item","Preço","Quantidade", "Subtotal"));
        System.out.println(linha);
        carrinho.mostraCarrinho();
        System.out.println(linha);
        System.out.println(String.format("|%-51s %-15s %-10s|","Subtotal"," ","R$"+valores));
        System.out.println(String.format("|%-51s %-15s %-10s|","Descontos"," ","R$"+desconto));
        System.out.println(linha);
        System.out.println(String.format("|%-51s %-15s %-10s|","Total"," ","R$"+valorAPagar));
        System.out.println(linha);
    }
    public static String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }

}