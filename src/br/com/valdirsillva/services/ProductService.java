package br.com.valdirsillva.services;

import br.com.valdirsillva.entity.Product;
import br.com.valdirsillva.repository.product.ProductImpl;

public class ProductService {
    private final ProductImpl productImpl;

    public ProductService() {
        this.productImpl = new ProductImpl();
    }

    public void save(Product product) {
        this.productImpl.add(product);
    }

    public void deleteById(String id) {
        this.productImpl.delete(id);
    }
}
