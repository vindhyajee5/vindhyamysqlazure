package com.vindhya.contoller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vindhya.entity.Product;
import com.vindhya.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);

	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return service.getAllProducts();

	}

	@GetMapping("/productsbyId/{id}")
	public Product getProductByid(@PathVariable int id) {
		return service.getProductByid(id);
	}

	@GetMapping("/productsByName/{name}")
	public Product getProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}

	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return service.UpdateProduct(product);
	}

	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);

	}
}
