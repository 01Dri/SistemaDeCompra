package repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entities.Product;

public class Products {

    private List<Product> produtos = new ArrayList<>();

    public Products(Product... produtos) {
        this.produtos = new ArrayList<>(Arrays.asList(produtos));

    }

    public void addProdutos(Product produto) {
        produtos.add(produto);

    }

    public void getProdutos() {
        for (Product prod : produtos) {
            System.out.println(prod.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("LISTA DE PRODUTOS");
        System.out.println("");
        for (Product prod : produtos) {
            sb.append("\n");
            sb.append("NOME: " + prod.getName() + "\n" + "PREÇO: " + prod.getPrice() + "\n" + "QUANTIDADE: "
                    + prod.getQuantity() + "\n");
        }
        return sb.toString();
    }

    public Product listarProdutos(String nomeProduto) {
        for (Product prod : produtos) {
            if (prod.getName().equalsIgnoreCase(nomeProduto)) {
                return prod;
            }
        }
        return null;
    }

    public void removerItemZero(Product produto) {
        produtos.remove(produto);
    }
}
