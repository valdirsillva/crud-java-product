package br.com.valdirsillva.view;

import br.com.valdirsillva.entity.Product;
import br.com.valdirsillva.services.ProductService;

public class MainTest {

	public static void main(String[] args) {

		try {
			ProductService productService = new ProductService();

			Product product = new Product();
			product.setName("Smartphone Galary A30");
			product.setDescription("Smartphone Galary A30 Samsung 8RAM");
			product.setPrice(1900.00);
			product.setQuantity(10);

			productService.save(product);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
