package com.mavenDemo.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mavenDemo.Model.ProductDTO;
import com.mavenDemo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void productRegister(ProductDTO product) {

		System.out.println("Inside product service");
		System.out.println(product.getProductName());
		System.out.println(product.getProductDesc());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		productRepository.checkProduct(product);
	}

	public List<ProductDTO> getProductDetails() {

	return productRepository.getProductDetails();

	}
}
