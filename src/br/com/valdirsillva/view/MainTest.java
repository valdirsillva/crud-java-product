package br.com.valdirsillva.view;

import java.util.Scanner;

import br.com.valdirsillva.entity.Product;
import br.com.valdirsillva.services.ProductService;

public class MainTest {

	public static void main(String[] args) {
		try {
			ProductService productService = new ProductService();
			Product product = new Product();

			Scanner inputMenu = new Scanner(System.in);
			int option;

			System.out.println("--------SISTEMA CONTROLE ESTOQUE--------");
			System.out.println("-------- MENU ------------");
			System.out.println("[1] Visualizar produtos em estoque");
			System.out.println("[2] Cadastrar produto");
			System.out.println("[3] Deletar produto");
			option = inputMenu.nextInt();

			switch (option) {
				case 1:
					String id = "1825d6fb-6735-430d-abf3-28dda7d0e931";
					Product pro = productService.get(id);

					System.out.println(pro);
					break;
				case 2:
					product.setName("Smartphone Galary A30");
					product.setDescription("Smartphone Galary A30 Samsung 8RAM");
					product.setPrice(1900.00);
					product.setQuantity(10);

					productService.save(product);
					break;
				case 3:
					String productId = "ac9d38a5-e678-4aa0-a814-61519ba06433";
					productService.deleteById(productId);

					break;

				default:
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
