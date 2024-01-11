package com.vindhya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vindhya.entity.Product;
import com.vindhya.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getProductByid(int id) {
		return repository.findById(id).orElse(null);

	}

	public Product getProductByName(String name) {
		return repository.findByName(name).orElse(null);

	}

	public String deleteProduct(int id) {
		repository.deleteById(id);

		return "Product has been deleted" + id;

	}

	public Product UpdateProduct(Product product) {
		Product oldProduct = repository.findById(product.getId()).orElse(null);

		oldProduct.setName(product.getName());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setQuantity(product.getQuantity());

		return oldProduct;

	}

}
