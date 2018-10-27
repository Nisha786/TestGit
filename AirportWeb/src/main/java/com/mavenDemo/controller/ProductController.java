package com.mavenDemo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.mavenDemo.Model.ProductDTO;
import com.mavenDemo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/product")
	public String showProduct(Map<String, Object> map) throws InterruptedException {
		System.out.println("Inside product page");
		map.put("productData", new ProductDTO());
		List<ProductDTO> proList = productService.getProductDetails();
		map.put("getProductDetails", proList);
		return "product";
	}

	@RequestMapping(value = "/submitProduct", method = RequestMethod.POST)
	public String submit(@ModelAttribute("productData") ProductDTO product, Map<String, Object> map) {
		System.out.println("product controller");
		product.getProductName();
		product.getProductDesc();
		product.getPrice();
		product.getQuantity();
		productService.productRegister(product);
		List<ProductDTO> proList = productService.getProductDetails();
		map.put("getProductDetails", proList);
		return "product";
	}
}