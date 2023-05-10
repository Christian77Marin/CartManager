package com.cmarinre;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.cmarinre.models.Cart;
import com.cmarinre.models.Product;

public class removeProductFromCart{

	@Test
	public void testRemoveProductFromCart() {
		 Cart cart = new Cart(2);
		 Product producto1 = new Product(4, "Pan", 12);
		 Product producto2 = new Product(6, "Coca Cola", 24);
		 Product producto3 = new Product(42, "Pepsi", 14);
		 
		 cart.addProduct(producto1);
		 cart.addProduct(producto2);
		 cart.addProduct(producto3);
		 cart.removeProduct(producto1);
		 
		 assertEquals(2, cart.getProducts().size());
	}
}
