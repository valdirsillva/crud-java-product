package br.com.valdirsillva.factories;

import br.com.valdirsillva.entity.Product;

public abstract class ProductFactory {

    public static Product getProduct() {
        return new Product();
    }
}
