package com.mavenDemo.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mavenDemo.Model.ProductDTO;

@Repository
public class ProductRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public boolean checkProduct(ProductDTO product) {

		System.out.println("Inside product repository");
		System.out.println(product.getProductName());
		System.out.println(product.getProductDesc());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());

		if (product != null) {

			hibernateTemplate.save(product);
			return true;
		} else {
			return false;
		}
	}

	public List<ProductDTO> getProductDetails() {

		return hibernateTemplate.find("FROM ProductDTO");
	}
}
