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
import com.project.dto.RetailerLoginStatus;
import com.project.entity.Retailer;
import com.project.dto.AddProductStatus;
import com.project.dto.AdminLoginStatus;
import com.project.dto.Login;
import com.project.dto.Status;
import com.project.entity.Admin;
import com.project.entity.Product;
import com.project.exception.CustomerServiceException;
import com.project.exception.RetailerServiceException;
import com.project.service.ProductService;
import com.project.service.RetailerService;

@RestController
@CrossOrigin()
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
	public Status addProduct(@RequestBody Product product,@RequestParam("retailerId") int retailerId) {
		try {
			Retailer retailer = new Retailer();
			retailer.setId(retailerId);
			product.setRetailer(retailer);
			System.out.println(product);
			int id = retailerService.additionOfProduct(product, retailerId);
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

		String sourceFile = "C:/Users/RSP/Desktop/products/" + product.getProductImage1();


		//String sourceFile = "C:/Users/Windows-10/Desktop/products/" + product.getProductImage1();


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
		System.out.println(tempDownloadPath);
		// creating a folder within the project where we will place the profile pic of
		// the customer getting fetched
		for (Product product : list) {

			File f = new File(tempDownloadPath);
			if (!f.exists())
				f.mkdir();
			String targetFile1 = tempDownloadPath + product.getProductImage1();
			String targetFile2 = tempDownloadPath + product.getProductImage2();
			String targetFile3 = tempDownloadPath + product.getProductImage3();
			String targetFile4 = tempDownloadPath + product.getProductImage4();
			// the original image location

			String sourceFile1 = "C:/Users/Windows-10/Desktop/products/" + product.getProductImage1();
			String sourceFile2 = "C:/Users/Windows-10/Desktop/products/" + product.getProductImage2();
			String sourceFile3 = "C:/Users/Windows-10/Desktop/products/" + product.getProductImage3();
			String sourceFile4 = "C:/Users/Windows-10/Desktop/products/" + product.getProductImage4();

			//String sourceFile = "C:/Users/Windows-10/Desktop/products/" + product.getProductImage1();
			//String sourceFile = "C:Users/w/Desktop/picture/" + product.getProductImage1();

			try {
				FileCopyUtils.copy(new File(sourceFile1), new File(targetFile1));
				FileCopyUtils.copy(new File(sourceFile2), new File(targetFile2));
				FileCopyUtils.copy(new File(sourceFile3), new File(targetFile3));
				FileCopyUtils.copy(new File(sourceFile4), new File(targetFile4));
			} catch (IOException e) {
				e.printStackTrace();
				// maybe for this customer no profile pic
			}
		}
		return list;

	}
	@PostMapping("/retailerlogin")
    //@PostMapping(path="/login", consumes ="application/json")
    public RetailerLoginStatus login(@RequestBody Login login) {
        try {
        	//System.out.println(loginDto.getEmail());
            Retailer retailer = retailerService.login(login.getEmail(), login.getPassword());
            RetailerLoginStatus retailerloginStatus = new RetailerLoginStatus();
            retailerloginStatus.setStatus(true);
            retailerloginStatus.setStatusMessage("Login Sucessful");
            retailerloginStatus.setRetailerId(retailer.getId());
            retailerloginStatus.setRetailerName(retailer.getName());
            return retailerloginStatus;
            
        }
        catch(CustomerServiceException e) {
            RetailerLoginStatus retailerloginStatus = new RetailerLoginStatus();
            retailerloginStatus.setStatusMessage(e.getMessage());
            return retailerloginStatus;
        }
        
    }
	
	 
	

}
