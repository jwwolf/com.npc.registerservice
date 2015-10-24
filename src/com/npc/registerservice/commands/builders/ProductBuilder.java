package com.npc.registerservice.commands.builders;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

public class ProductBuilder {
	
	public static org.npc.models.Product buildNewModelProduct(){
		return (new org.npc.models.Product()).setItemLookupCode(RandomStringUtils.randomAlphanumeric(PRODUCT_LOOKUP_CODE_LENGTH)).
				setQuantity(MIN_PRODUCT_COUNT + random.nextInt(MAX_PRODUCT_COUNT - MIN_PRODUCT_COUNT));
	}
	
	public static List<org.npc.models.Product> buildManyNewModelProducts() {
		List<org.npc.models.Product> products = new LinkedList<org.npc.models.Product>();
		int listLength = MIN_PRODUCT_LIST_LENGTH + random.nextInt(MAX_PRODUCT_LIST_LENGTH - MIN_PRODUCT_LIST_LENGTH);
		
		for (int i = 0; i < listLength; i++) {
			products.add(buildNewModelProduct());
		}
		
		return products;
	}
	
	public static org.npc.models.Product buildModelProduct() {
		return (new org.npc.models.Product(UUID.randomUUID())).
				setItemLookupCode(RandomStringUtils.randomAlphanumeric(PRODUCT_LOOKUP_CODE_LENGTH)).
				setQuantity(MIN_PRODUCT_COUNT + random.nextInt(MAX_PRODUCT_COUNT - MIN_PRODUCT_COUNT));
	}
	
	public static List<org.npc.models.Product> buildManyModelProducts() {
		List<org.npc.models.Product> products = new LinkedList<org.npc.models.Product>();
		int listLength = MIN_PRODUCT_LIST_LENGTH + random.nextInt(MAX_PRODUCT_LIST_LENGTH - MIN_PRODUCT_LIST_LENGTH);
		for (int i = 0; i < listLength; i++) {
			products.add(buildModelProduct());
		}		
		return products;
	}
	
	public static org.npc.models.api.Product buildNewApiProduct() {
		return (new org.npc.models.api.Product()).
				setItemLookupCode(RandomStringUtils.randomAlphanumeric(PRODUCT_LOOKUP_CODE_LENGTH)).
				setQuantity(MIN_PRODUCT_COUNT + random.nextInt(MAX_PRODUCT_COUNT - MIN_PRODUCT_COUNT));
	}
	
	public static List<org.npc.models.api.Product> buildManyNewApiProducts() {
		List<org.npc.models.api.Product> products = new LinkedList<org.npc.models.api.Product>();
		int listLength = MIN_PRODUCT_LIST_LENGTH + random.nextInt(MAX_PRODUCT_LIST_LENGTH - MIN_PRODUCT_LIST_LENGTH);

		for (int i = 0; i < listLength; i++) {
			products.add(buildNewApiProduct());
		}		
		return products;
	}
	
	public static org.npc.models.api.Product buildApiProduct() {
		return (new org.npc.models.api.Product()).
				setId(UUID.randomUUID()).
				setItemLookupCode(RandomStringUtils.randomAlphanumeric(PRODUCT_LOOKUP_CODE_LENGTH)).
				setQuantity(MIN_PRODUCT_COUNT + random.nextInt(MAX_PRODUCT_COUNT - MIN_PRODUCT_COUNT));
	}
	
	public static List<org.npc.models.api.Product> buildManyApiProducts() {
		List<org.npc.models.api.Product> products = new LinkedList<org.npc.models.api.Product>();
		int listLength = MIN_PRODUCT_LIST_LENGTH + random.nextInt(MAX_PRODUCT_LIST_LENGTH - MIN_PRODUCT_LIST_LENGTH);
		
		for (int i = 0; i < listLength; i++) {
			products.add(buildApiProduct());
		}		
		return products;
	}
	
	private static Random random;
	
	private static final int MIN_PRODUCT_COUNT = 50;
	private static final int MAX_PRODUCT_COUNT = 500;
	private static final int MIN_PRODUCT_LIST_LENGTH = 2;
	private static final int MAX_PRODUCT_LIST_LENGTH = 10;
	private static final int PRODUCT_LOOKUP_CODE_LENGTH = 20;
	
	static {
		random = new Random(System.currentTimeMillis());
	}
}
