package br.com.valdirsillva.services;

import java.util.List;
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

    public List<Product> getAll() {
        List<Product> productsList = this.productImpl.list();
        return productsList;
    }

    public Product getById(String id) {
        return this.productImpl.findById(id);
    }

    public void update(String id, Product product) {
        this.productImpl.update(id, product);
    }

    public void deleteById(String id) {
        this.productImpl.delete(id);
    }
}
