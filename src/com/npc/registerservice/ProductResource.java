package com.npc.registerservice;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.npc.models.api.ProductListing;
import org.npc.models.repositories.ProductRepository;
import com.npc.registerservice.commands.CreateProductCommand;

import com.npc.registerservice.commands.ProductQuery;
import com.npc.registerservice.commands.ProductQueryByItemLookupCode;

import org.npc.models.api.Product;

import com.npc.registerservice.commands.ProductsQuery;

	@Path("product/")
	public class ProductResource {
	@GET
	@Path("apiv0/products")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductListing getProducts() {
		return (new ProductsQuery()).
			setProductRepository(new ProductRepository()).
			execute();
	}
	
	@GET
	@Path("apiv0/byproductid/{productid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductQuery(@PathParam("productid") UUID productId) {
		return (new ProductQuery()).
			setProductId(productId).
			setProductRepository(new ProductRepository()).
			execute();
	}
	
	@GET
	@Path("apiv0/byitemlookupcode/{itemlookupcode}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductQueryByItemLookupCode(@PathParam("itemlookupcode")
						String itemlookupcode){
		return (new ProductQueryByItemLookupCode()).
				setItemLookupCode(itemlookupcode).
				setProductRepository(new ProductRepository()).
				execute();
	}
	
	@PUT
	@Path("apiv0")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product createProduct(JAXBElement<Product> apiProduct) {
		return (new CreateProductCommand()).
			setApiProduct(apiProduct.getValue()).
			setProductRepository(new ProductRepository()).
			execute();
	}
	
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Successful test (.../test/)";
	}

}
