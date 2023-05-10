package com.cmarinre;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cmarinre.controllers.CartController;
import com.cmarinre.models.Cart;
import com.cmarinre.models.Product;

public class RemoveCart {

	@Test
	public void testRemoveCart() {
		 Cart cart1 = new Cart(2);
		 Cart cart2 = new Cart(3);
		 Product producto1 = new Product(4, "Pan", 12);
		 Product producto2 = new Product(6, "Coca Cola", 24);
		 Product producto3 = new Product(42, "Pepsi", 14);
		 
		 cart1.addProduct(producto1);
		 cart1.addProduct(producto2);
		 cart2.addProduct(producto3);
		 
		 CartController cartC = new CartController();
		 cartC.addCart(cart1);
		 cartC.addCart(cart2);
		 cartC.removeCart(cart2);
		 
		    assertEquals(1, cartC.getCarts().size());

		 
	}

}
