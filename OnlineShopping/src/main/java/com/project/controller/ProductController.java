package com.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ProductDto;
import com.project.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path="/sortProduct")
	public List<ProductDto> sortProduct(@RequestParam("by") String by, @RequestParam("order") boolean order)
	{
		return this.productService.sortProduct(by, order);
	}
	
	@GetMapping(path="/search")
	public List<ProductDto> search(@RequestParam("search") String search) {
		
			return this.productService.search(search);
		
	}
	
	@GetMapping(path = "/getProductById") 
	public ProductDto getProductById(@RequestParam("pId") String pId)
	{
		return this.productService.toListAllProducts(Integer.parseInt(pId));
	} 
	
	/*@GetMapping(path = "/getProduct") 
	public ProductDto getProductById()
	{
		return this.productService.toListAllProducts();
	} */
	
	@GetMapping(path = "/filterProduct")
	public List<ProductDto> filterProductMethod(@RequestParam("brand") String brand,@RequestParam("start")  String start, @RequestParam("end")  String end)
	{
		return this.productService.filterProduct(brand, Double.parseDouble(start), Double.parseDouble(end));
	}
	
}
