package com.npc.registerservice.commands;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.models.api.Product;
import org.npc.models.enums.ProductApiRequestStatus;
import org.npc.models.repositories.interfaces.ProductRepositoryInterface;

import com.npc.registerservice.commands.Interface.ResultCommandInterface;

public class CreateProductCommand implements ResultCommandInterface<Product> {

	@Override
	public Product execute() {
		if (StringUtils.isBlank(this.apiProduct.getItemLookupCode())) {
			return (new Product()).setApiRequestStatus(ProductApiRequestStatus.INVALID_INPUT);
		}
		
		org.npc.models.Product modelProduct = this.productRepository.byItemLookupCode(this.apiProduct.getItemLookupCode());
		if (modelProduct != null) {
			return (new Product()).setApiRequestStatus(ProductApiRequestStatus.LOOKUP_CODE_ALREADY_EXISTS);
		}
		
		this.apiProduct.setId(UUID.randomUUID());
		modelProduct = new org.npc.models.Product(this.apiProduct);
		
		return this.apiProduct;
	}
																		
	
		
		
		
		//Properties
		private Product apiProduct;
		public Product getApiProduct() {
			return this.apiProduct;
		}
		public CreateProductCommand setApiProduct(Product apiProduct) {
			this.apiProduct = apiProduct;
			return this;
		}
		
		private ProductRepositoryInterface productRepository;
		public ProductRepositoryInterface getProductRepository() {
			return this.productRepository;
		}
		public CreateProductCommand setProductRepository(ProductRepositoryInterface productRepository) {
			this.productRepository = productRepository;
			return this;
		}
}
