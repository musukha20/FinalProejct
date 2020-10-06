package com.project.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.PicUpload;
import com.project.dto.ProductDto;
import com.project.entity.Retailer;
import com.project.dto.AddProductStatus;
import com.project.dto.Status;
import com.project.entity.Product;
import com.project.entity.Retailer;
import com.project.exception.RetailerServiceException;
import com.project.service.ProductService;
import com.project.service.RetailerService;

@RestController
@CrossOrigin
public class RetailerController {

	@Autowired
	private RetailerService retailerService;

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/register")
	public Status register(@RequestBody Retailer retailer) {
		try {
			int id = retailerService.register(retailer);
			Status status = new Status();
			status.setStatus(true);
			status.setStatusMessage("Registration Successfull");
			return status;
		} catch (RetailerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping(path = "/addproduct")
	public Status addProduct(@RequestBody Product product, Retailer retailer) {
		try {
			int id = retailerService.additionOfProduct(product, retailer);
			AddProductStatus status = new AddProductStatus();
			status.setProductId(product.getProductId());
			status.setStatus(true);
			status.setStatusMessage("Product added successfully");
			status.setMsg("Congrats on uploading");
			return status;
		} catch (RetailerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}

	@GetMapping("/productdisplay")
	public ProductDto profile(@RequestParam("productId") int id, HttpServletRequest request) {
		// fetching customer data from db
		ProductDto product = productService.get(id);
		// Retailer retailer= retailerService.get(id);
		// Customer customer = customerService.get(id);

		// reading the project's deployed folder location
		String projPath = request.getServletContext().getRealPath("/");
		System.out.println(projPath); // this will help you understand the above line
		String tempDownloadPath = projPath + "/downloads/";
		// creating a folder within the project where we will place the profile pic of
		// the customer getting fetched
		File f = new File(tempDownloadPath);
		if (!f.exists())
			f.mkdir();
		String targetFile1 = tempDownloadPath + product.getProductImage1();
		// the original image location
		String sourceFile = "C:/Users/Windows-10/Desktop/products/" + product.getProductImage1();
		try {
			FileCopyUtils.copy(new File(sourceFile), new File(targetFile1));
		} catch (IOException e) {
			e.printStackTrace();
			// maybe for this customer no profile pic
		}
		return product;

	}

	@GetMapping("/all-productdisplay")
	public List<Product> allProfile(HttpServletRequest request) {
		// fetching customer data from db
		List<Product> list = productService.getAllProducts();

		// reading the project's deployed folder location
		String projPath = request.getServletContext().getRealPath("/");
		System.out.println(projPath); // this will help you understand the above line
		String tempDownloadPath = projPath + "/downloads/";
		// creating a folder within the project where we will place the profile pic of
		// the customer getting fetched
		for (Product product : list) {

			File f = new File(tempDownloadPath);
			if (!f.exists())
				f.mkdir();
			String targetFile1 = tempDownloadPath + product.getProductImage1();
			// the original image location
			String sourceFile = "C:/Users/Windows-10/Desktop/products/" + product.getProductImage1();
			try {
				FileCopyUtils.copy(new File(sourceFile), new File(targetFile1));
			} catch (IOException e) {
				e.printStackTrace();
				// maybe for this customer no profile pic
			}
		}
		return list;

	}

}
