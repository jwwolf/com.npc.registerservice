package com.npc.registerservice.commands;

import org.npc.models.api.Product;
import org.npc.models.repositories.interfaces.ProductRepositoryInterface;
import com.npc.registerservice.commands.Interface.ResultCommandInterface;

public class ProductQueryByItemLookupCode implements ResultCommandInterface<Product> {
	
	@Override
	public Product execute() {
		return new Product( (this.productRepository.byItemLookupCode(this.itemLookupCode)) );
	}

	private String itemLookupCode;
	public String getItemLookupCode() {
		return this.itemLookupCode;
	}
	public ProductQueryByItemLookupCode setItemLookupCode(String itemLookupCode){
		this.itemLookupCode = itemLookupCode;
		return this;
	}

	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductQueryByItemLookupCode setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
}