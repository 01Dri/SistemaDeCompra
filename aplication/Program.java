package aplication;

import java.text.DecimalFormat;
import java.util.Scanner;

import entities.Product;
import repositories.Products;

public class Program {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Product tv = new Product("TV", 1000, 4);
            Product carro = new Product("CARRO", 3000, 10);
            
            Products produtos = new Products(tv, carro);

            System.out.println("FAÇA SUA COMPRA:");
            System.out.println("");
            System.out.println("Produtos disponiveis!");
            produtos.getProdutos();

            System.out.print("Digite o nome do produto para comprar: ");
            String nomeProdutoUser = sc.nextLine();
            Product produtoUser = produtos.listarProdutos(nomeProdutoUser);

            if (produtoUser != null) {
                DecimalFormat formatador = new DecimalFormat("###.###");
                String precoFormatado = formatador.format(produtoUser.getPrice());
                System.out.println("Seu valor é " + precoFormatado + "R$");
                System.out.print("Deseja comprar? [s/n]: ");
                String confirmacaoUser = sc.nextLine();

                if (confirmacaoUser.equalsIgnoreCase("s")) {
                    System.out.print("Insira a quantidade: ");
                    int quantidadeComprar = sc.nextInt();
                    produtoUser.comprar(quantidadeComprar, produtos, produtoUser);
                    System.out.println(produtos);

                } else {
                    System.out.println("Fim ");
                }

            } else {
                System.out.println("O produto digitado nao existe!");
            }
        }

    }

}
