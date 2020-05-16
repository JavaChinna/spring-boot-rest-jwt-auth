package com.javachinna.controller;

import java.util.List;

import com.javachinna.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
public interface ProductApi {

	@ApiOperation(value = "Get list of products in the System ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess"), @ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not found!") })
	public List<Product> getProductList(String consumerKey);

	@ApiOperation(value = "Get product by product ID", response = Product.class)
	public Product getProduct(Long productId);

	@ApiOperation(value = "Create product", response = String.class)
	public String createProduct(Product product);

	@ApiOperation(value = "Update product by product ID", response = String.class)
	public String updateProduct(Long productId, Product product);

	@ApiOperation(value = "Delete product by product ID", response = String.class)
	public String deleteProduct(Long productId);
}
