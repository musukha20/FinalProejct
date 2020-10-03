package com.project.repository;

import java.util.List;

import com.project.entity.Product;

public interface ProductDao {

	public List<Product> search(String keyword);
}
