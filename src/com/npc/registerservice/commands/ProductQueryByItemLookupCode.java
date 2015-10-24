package com.npc.registerservice.commands;

import java.util.UUID;

import org.npc.models.Product;
import org.npc.models.repositories.interfaces.ProductRepositoryInterface;
import com.npc.registerservice.commands.Interface.ResultCommandInterface;

public class ProductQueryByItemLookupCode implements ResultCommandInterface<Product> {
	
	@Override
	public Product execute() {
		return new Product((UUID) this.productRepository.byItemLookupCode(this.itemLookupCode).getId() );
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