package br.com.valdirsillva.repository.product;

import java.util.List;

import br.com.valdirsillva.entity.Product;

public interface IProduct {

	void add(Product product);

	List<Product> list();

	Product findById(String id);

	void update(String id, Product product);

	void delete(String id);
}
