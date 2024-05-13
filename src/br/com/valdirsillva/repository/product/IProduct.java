package br.com.valdirsillva.repository.product;

import java.util.List;

import br.com.valdirsillva.entity.Product;

public interface IProduct {

	void add(Product product);

	List<Product> list();

	ProductImpl findById(String id);

	void update(String id);

	void delete(String id);
}
