package com.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.project.dto.ProductDto;
import com.project.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path="/sortProduct/{by}/{order}")
	public List<ProductDto> sortProduct(@PathVariable String by, @PathVariable boolean order)
	{
		return this.productService.sortProduct(by, order);
	}
}
