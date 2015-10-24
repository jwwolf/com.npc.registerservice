package com.npc.registerservice.commands;

import java.util.stream.Collectors;

import com.npc.registerservice.commands.Interface.ResultCommandInterface;
import org.npc.models.api.Product;
import org.npc.models.api.ProductListing;
import org.npc.models.repositories.interfaces.ProductRepositoryInterface;

public class ProductsQuery implements ResultCommandInterface<ProductListing> {
	@Override
	public ProductListing execute() {
		return (new ProductListing()).
			setProducts(
				this.productRepository.all().stream().map(mp -> (new Product(mp))).collect(Collectors.toList()
			)
		);
	}

	//Properties
	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductsQuery setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
}
