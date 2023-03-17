package entities;

import java.text.DecimalFormat;

import repositories.Products;

public class Product {

    private String name;
    private double price;
    private Integer quantity;

    public Product() {

    }

    public Product(String name, double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void comprar(int quantidadeComprar, Products produtos, Product produto) {
        if (quantidadeComprar > quantity) {
            System.out.println("Esse item tem somente " + quantity + " unidades!");
        } else {
            quantity -= quantidadeComprar;
            if (quantity <= 0) {
                produtos.removerItemZero(produto);
            }
            double resultadoCompra = price * quantidadeComprar;
            DecimalFormat formatador = new DecimalFormat("###,###");
            String totalGasto = formatador.format(resultadoCompra);
            System.out.println("Voce comprou " + quantidadeComprar + " " + produto.getName());
            System.out.println("Total gasto: " + totalGasto + "R$");
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

}
